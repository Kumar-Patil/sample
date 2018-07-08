package com.taxi.controller;

import com.taxi.RequestMapper.ChangePassword;
import com.taxi.RequestMapper.Login;
import com.taxi.domain.AccessToken;
import com.taxi.domain.User;
import com.taxi.helper.PasswordReset;
import com.taxi.service.AccessTokenService;
import com.taxi.service.UserService;
import com.taxi.to.Response;
import com.taxi.to.SessionResponse;
import com.taxi.util.Config;
import com.taxi.util.Constants;
import com.taxi.util.StaticSessionHandler;
import com.taxi.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author
 */
@Controller
@RequestMapping("/login")
@Api(value = "login")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@CrossOrigin
public class LoginController {

    /**
     *
     * @param api_key
     * @param login
     * @return
     */
    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(LoginController.class);

    @Autowired
    UserService userServices;

    @Autowired
    AccessTokenService accessTokenService;

    @ApiOperation(value = "User login", notes = "Retrieves a user details", response = SessionResponse.class)
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> login(@RequestBody Login login) {
        long userId = 0;
        AccessToken accessToken = null;
        SessionResponse sessionResponse = null;
        try {
            userId = userServices.isValidUser(login.getEmail(), login.getPassword());
        } catch (Exception ex) {
            LOG.error("Exception occured while reading user details {}" + ex.getMessage());
        }
        if (userId == 0) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            boolean isAdded = false;
            accessToken = new AccessToken();
            sessionResponse = new SessionResponse();
            accessToken.setAccessToken(Util.generateRandomString());
            accessToken.setRefreshToken(Util.generateRandomString());
            accessToken.setUserId(userId);
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            accessToken.setExpiryAt(currentTimestamp);
            try {
                isAdded = accessTokenService.add(accessToken);
            } catch (Exception ex) {
                LOG.error("Exception occured creating access token {}" + ex.getMessage());
            }
            if (isAdded) {
                sessionResponse.setAccessToken(accessToken.getAccessToken());
                sessionResponse.setRefreshToken(accessToken.getRefreshToken());
                User user;
                try {
                    user = userServices.findById(userId);
                } catch (Exception ex) {
                    Response response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
                sessionResponse.setEmail(user.getEmail());
                sessionResponse.setFirstName(user.getFirstName());
                sessionResponse.setLastName(user.getLastName());
                sessionResponse.setRole(user.getRole());
                sessionResponse.setStatus(user.getStatus());
                sessionResponse.setUserId(userId);
                String numberAsString = String.valueOf(userId);
                StaticSessionHandler.sessionMap(numberAsString,accessToken.getAccessToken());
                return new ResponseEntity<>(sessionResponse, HttpStatus.OK);
            } else {
                Response response = new Response(Constants.ERROR_RESPONCE, "Not able to generate access token, try again");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

        }
    }

    @ApiOperation(value = "send OTP", notes = "Retrieves a OTP", response = Response.class)
    @RequestMapping(value = "/sendOTP", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendOTPMail(@RequestParam("emailId") String emailId) {
        try {
            Config cfg = new Config();
            boolean validationStatus = userServices.isValidEmailId(emailId);
            if (!validationStatus) {//emailIdNotExisted
                Response response = new Response(Constants.ERROR_RESPONCE, "Enter valid emailId .");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                List<String> recipientEmails = new ArrayList<>();
                recipientEmails.add(emailId);
                String fromEmail = cfg.getProperty("FROM_EMAIL_ID");
                String emailBody = null;
                int randNum = (new Random()).nextInt(900000) + 100000;
                StringBuilder message = new StringBuilder();
                message.append("<table><tr style=\"vertical-align:top;\"><td><b>Use OTP to change existed password  :" + randNum + "</b></td>");
                emailBody = message.toString();
                Thread thread1 = new Thread(new PasswordReset(recipientEmails, fromEmail, emailBody, "Reset Password : OTP details"));
                thread1.start();
                userServices.updateOTP(emailId, String.valueOf(randNum));
                Response response = new Response(Constants.SUCESS_RESPONCE, "OTP sent successfully");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            LOG.error(e.toString());
        }
        Response response = new Response(Constants.ERROR_RESPONCE, "Enter valid emailId .");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "otp Verification", notes = "otp Verification", response = Response.class)
    @RequestMapping(value = "/otpVerification", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> otpVerification(@RequestParam("emailId") String emailId, @RequestParam("otpValue") String otpValue) {
        Response response = null;
        try {
            boolean validationStatus = userServices.OTPVerification(emailId, otpValue);
            if (!validationStatus) {//Successfully verified
                response = new Response(Constants.SUCESS_RESPONCE, "Valid OTP");
            } else {//Failed to verify
                response = new Response(Constants.ERROR_RESPONCE, "Entered invalid OTP value");
            }
        } catch (Exception e) {
            LOG.error("Exception occured in otpVerification {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "forgot Password", notes = "forgot Password", response = Response.class)
    @RequestMapping(value = "/forgotpassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> forgotpassword(@RequestBody Login login) {
        Response response = null;
        try {
            String emailId = login.getEmail();
            String otpValue = login.getOtp();
            String newPwd = login.getPassword();
            boolean isValidOTP = userServices.OTPVerification(emailId, otpValue);
            if (isValidOTP) {//Successfully verified
                userServices.forgotPassword(newPwd, emailId, otpValue);
                response = new Response(Constants.SUCESS_RESPONCE, "Password changed successfully");
            } else {//Failed to verify
                response = new Response(Constants.ERROR_RESPONCE, "Entered valid mail and  OTP value");
            }
        } catch (Exception e) {
            LOG.error("Exception occured in changePassword {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "logout", notes = "logout", response = Response.class)
    @RequestMapping(value = "/logout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> logout(@RequestParam("userId") long userId) {
        Response response = null;
        try {
            boolean isAccessTokenDeleted = accessTokenService.deleteAccessToken(userId);
            if (isAccessTokenDeleted) {//Successfully verified
                response = new Response(Constants.SUCESS_RESPONCE, "Done");
            } else {//Failed to verify
                response = new Response(Constants.ERROR_RESPONCE, "Entered valid user id");
            }
        } catch (Exception e) {
            LOG.error("Exception occured in logout {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "change Password", notes = "change Password", response = Response.class)
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changePassword(@RequestParam("userId") long userId, @RequestBody ChangePassword changePassword) {
        Response response = null;
        try {
            String emailId = changePassword.getEmail();
            String newPwd = changePassword.getNewPassword();
            userServices.changePassword(newPwd, emailId);
            response = new Response(Constants.SUCESS_RESPONCE, "Password changed successfully");

        } catch (Exception e) {
            response = new Response(Constants.ERROR_RESPONCE, "Entered valid mail and  OTP value");
            LOG.error("Exception occured in changePassword {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
