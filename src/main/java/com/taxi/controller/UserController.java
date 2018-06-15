package com.taxi.controller;

import com.taxi.RequestMapper.SearchRequestMapping;
import com.taxi.RequestMapper.UserRequestMapper;
import com.taxi.domain.User;
import com.taxi.service.AccessTokenService;
import com.taxi.service.UserService;
import com.taxi.to.Response;
import com.taxi.to.UserDetails;
import com.taxi.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author
 */
@Controller
@RequestMapping("/user")
@Api(value = "user")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class UserController {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(UserController.class);

    @Autowired
    UserService userServices;

    @Autowired
    AccessTokenService accessTokenService;

    @ApiOperation(value = "User exist", notes = "User exist", response = Response.class)
    @RequestMapping(value = "/exist", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> userExist(@RequestParam("userId") long userId, @RequestParam("email") String email) {
        Response response = null;
        try {
            boolean isUserExist = userServices.isValidEmailId(email);
            if (isUserExist) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Add user", notes = "Add user", response = Response.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(@RequestParam("userId") long userId, @RequestBody UserRequestMapper userRequestMapper) {
        Response response = null;
        try {
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            User user = new User();
            user.setEmail(userRequestMapper.getEmail());
            user.setCreatedAt(currentTimestamp);
            user.setUpdatedAt(currentTimestamp);
            user.setPassword(userRequestMapper.getPassword());
            user.setPhone(userRequestMapper.getPhone());
            user.setRole(userRequestMapper.getRole());
            user.setStatus(1);
            user.setFirstName(userRequestMapper.getFirstName());
            user.setLastName(userRequestMapper.getLastName());
            user.setEmailVerified(0);
            user.setPhoneVerified(0);
            boolean isUserAdded = userServices.add(user);
            if (isUserAdded) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "update user", notes = "Add user", response = Response.class)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(@RequestParam("userId") long userId, @RequestBody UserRequestMapper userRequestMapper) {
        Response response = null;
        try {
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            User user = new User();
            User userDetails = userServices.findById(userRequestMapper.getId());
            user.setEmail(userRequestMapper.getEmail());
            user.setCreatedAt(userDetails.getDeletedAt());
            user.setUpdatedAt(currentTimestamp);
            user.setPassword(userRequestMapper.getPassword());
            user.setPhone(userRequestMapper.getPhone());
            user.setRole(userRequestMapper.getRole());
            user.setStatus(1);
            user.setId(userRequestMapper.getId());
            user.setFirstName(userRequestMapper.getFirstName());
            user.setLastName(userRequestMapper.getLastName());
            user.setEmailVerified(0);
            user.setPhoneVerified(0);
            boolean isUserAdded = userServices.add(user);
            if (isUserAdded) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "search user", notes = "search user", response = UserDetails.class)
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> search(@RequestParam("userId") long userId, @RequestBody SearchRequestMapping searchRequestMapping) {
        List<UserDetails> details = new ArrayList();
        try {
            List<User> users = null;
            users = userServices.search(searchRequestMapping.getSearch());
            for (User user : users) {
                details.add(new UserDetails(user.getId(), user.getRole(), user.getPhone(), user.getEmail(), user.getFirstName(), user.getLastName()));
            }

        } catch (Exception ex) {
            LOG.error("Exception occured while search records {}" + ex.getMessage());
        }
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete user", notes = "Delete user", response = Response.class)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> delete(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        Response response = null;
        try {
            boolean isUserDeleted = userServices.updateStatus(id);
            if (isUserDeleted) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }

        } catch (Exception ex) {
            LOG.error("Exception occured while search delete {}" + ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "List users", notes = "List users", response = UserDetails.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> details(@RequestParam("userId") long userId) {
        List<UserDetails> details = new ArrayList();
        try {
            List<User> users = null;
            users = userServices.list();
            for (User user : users) {
                details.add(new UserDetails(user.getId(), user.getRole(), user.getPhone(), user.getEmail(), user.getFirstName(), user.getLastName()));
            }
        } catch (Exception ex) {
            LOG.error("Exception occured while search records {}" + ex.getMessage());
        }
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @ApiOperation(value = "View user", notes = "View user", response = User.class)
    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> view(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        User details = null;
        try {
            details = userServices.viewById(id);
        } catch (Exception ex) {
            LOG.error("Exception occured while search view {}" + ex.getMessage());
        }
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @ApiOperation(value = "user details", notes = "user details", response = User.class)
    @RequestMapping(value = "/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> details(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        User details = null;
        try {
            details = userServices.viewById(id);
        } catch (Exception ex) {
            LOG.error("Exception occured while search view {}" + ex.getMessage());
        }
        return new ResponseEntity<>(details, HttpStatus.OK);
    }
}
