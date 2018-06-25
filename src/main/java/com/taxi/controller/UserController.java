package com.taxi.controller;

import com.taxi.RequestMapper.SearchRequestMapping;
import com.taxi.RequestMapper.UserRequestMapper;
import com.taxi.TransferObject.UserObject;
import com.taxi.domain.BankAccountDetails;
import com.taxi.domain.Locations;
import com.taxi.domain.User;
import com.taxi.domain.UserDocuments;
import com.taxi.service.AccessTokenService;
import com.taxi.service.BankAccountDetailsService;
import com.taxi.service.LocationsService;
import com.taxi.service.UserService;
import com.taxi.service.UsersDocumentsService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    LocationsService locationsService;

    @Autowired
    BankAccountDetailsService accountDetailsService;

    @Autowired
    UsersDocumentsService documentsService;

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
            Locations locations = new Locations();
            locations = UserObject.userObject(true, userRequestMapper);
            Long locationId = locationsService.add(locations);
            locations.setLocationId(locationId);

            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            //Bank Details
            BankAccountDetails bankAccountDetails = new BankAccountDetails();
            bankAccountDetails.setAccountNo(userRequestMapper.getAccountNo());
            bankAccountDetails.setAdddress(userRequestMapper.getAddress());
            bankAccountDetails.setAdddress1(userRequestMapper.getAddress());
            bankAccountDetails.setAdddress2(userRequestMapper.getAddress());
            bankAccountDetails.setCreatedAt(currentTimestamp);
            bankAccountDetails.setUpdatedAt(currentTimestamp);
            bankAccountDetails.setIfsc(userRequestMapper.getIfsc());
            bankAccountDetails.setName(userRequestMapper.getName());
            bankAccountDetails.setStatus(userRequestMapper.getStatus());
            Long id = accountDetailsService.add(bankAccountDetails);
            bankAccountDetails.setAccountId(id);
            //Dcoumnets Details
            UserDocuments UserDocuments = new UserDocuments();
            UserDocuments.setAggrement1(userRequestMapper.getAggrement1());
            UserDocuments.setAggrement2(userRequestMapper.getAggrement2());
            UserDocuments.setAggrement3(userRequestMapper.getAggrement3());
            UserDocuments.setAggrement4(userRequestMapper.getAggrement4());
            UserDocuments.setCreatedAt(currentTimestamp);
            UserDocuments.setProofOfAddress(userRequestMapper.getProofOfAddress());
            UserDocuments.setStatus(userRequestMapper.getStatus());
            UserDocuments.setUpdatedAt(currentTimestamp);
            UserDocuments.setUserPic(userRequestMapper.getUserPic());
            Long documentId = documentsService.add(UserDocuments);
            UserDocuments.setUserId(documentId);

            User user = new User();
            user.setEmail(userRequestMapper.getEmail());
            user.setCreatedAt(currentTimestamp);
            user.setUpdatedAt(currentTimestamp);
            user.setPassword(userRequestMapper.getPassword());
            user.setPhone(userRequestMapper.getPhone());
            user.setRole(userRequestMapper.getRole());
            user.setStatus(userRequestMapper.getStatus());
            user.setFirstName(userRequestMapper.getFirstName());
            user.setLastName(userRequestMapper.getLastName());
            user.setEmailVerified(0);
            user.setPhoneVerified(0);
            //Additional Fields
            user.setHireDate(currentTimestamp);
            user.setHireEndDate(currentTimestamp);
            user.setSex(userRequestMapper.getSex());
            user.setOtherphone(userRequestMapper.getOtherphone());
            //Mapping setting here
            user.setUserDocuments(UserDocuments);
            user.setAccountDetails(bankAccountDetails);
            user.setLocations(locations);
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
            Locations locations = new Locations();
            locations = UserObject.userObject(true, userRequestMapper);
            locations.setLocationId(userDetails.getLocations().getLocationId());
            locationsService.update(locations);

            //Bank Details
            BankAccountDetails bankAccountDetails = new BankAccountDetails();
            bankAccountDetails.setAccountNo(userRequestMapper.getAccountNo());
            bankAccountDetails.setAdddress(userRequestMapper.getAddress());
            bankAccountDetails.setAdddress1(userRequestMapper.getAddress());
            bankAccountDetails.setAdddress2(userRequestMapper.getAddress());
            bankAccountDetails.setCreatedAt(currentTimestamp);
            bankAccountDetails.setUpdatedAt(currentTimestamp);
            bankAccountDetails.setIfsc(userRequestMapper.getIfsc());
            bankAccountDetails.setName(userRequestMapper.getName());
            bankAccountDetails.setStatus(userRequestMapper.getStatus());
            bankAccountDetails.setAccountId(userDetails.getAccountDetails().getAccountId());
            accountDetailsService.update(bankAccountDetails);

            //Dcoumnets Details
            UserDocuments UserDocuments = new UserDocuments();
            UserDocuments.setAggrement1(userRequestMapper.getAggrement1());
            UserDocuments.setAggrement2(userRequestMapper.getAggrement2());
            UserDocuments.setAggrement3(userRequestMapper.getAggrement3());
            UserDocuments.setAggrement4(userRequestMapper.getAggrement4());
            UserDocuments.setCreatedAt(currentTimestamp);
            UserDocuments.setProofOfAddress(userRequestMapper.getProofOfAddress());
            UserDocuments.setStatus(userRequestMapper.getStatus());
            UserDocuments.setUpdatedAt(currentTimestamp);
            UserDocuments.setUserPic(userRequestMapper.getUserPic());
            UserDocuments.setUserId(userDetails.getUserDocuments().getUserId());
            documentsService.update(UserDocuments);

            user.setEmail(userRequestMapper.getEmail());
            user.setCreatedAt((Timestamp) userDetails.getCreatedAt());
            user.setUpdatedAt(currentTimestamp);
            user.setPassword(userRequestMapper.getPassword());
            user.setPhone(userRequestMapper.getPhone());
            user.setRole(userRequestMapper.getRole());
            user.setStatus(userRequestMapper.getStatus());
            user.setFirstName(userRequestMapper.getFirstName());
            user.setLastName(userRequestMapper.getLastName());
            user.setEmailVerified(0);
            user.setPhoneVerified(0);
            //Additional Fields
            user.setHireDate(currentTimestamp);
            user.setHireEndDate(currentTimestamp);
            user.setSex(userRequestMapper.getSex());
            user.setOtherphone(userRequestMapper.getOtherphone());
            //Mapping setting here
            user.setUserDocuments(UserDocuments);
            user.setAccountDetails(bankAccountDetails);
            user.setLocations(locations);
            user.setId(userRequestMapper.getId());
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
                details.add(new UserDetails(user.getId(), user.getRole(), user.getPhone(), user.getEmail(), user.getFirstName(), user.getLastName(), Constants.status().get(user.getStatus())));
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
                details.add(new UserDetails(user.getId(), user.getRole(), user.getPhone(), user.getEmail(), user.getFirstName(), user.getLastName(), Constants.status().get(user.getStatus())));
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

    @ApiOperation(value = "user details", notes = "user details", response = UserRequestMapper.class)
    @RequestMapping(value = "/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> details(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        try {
            return new ResponseEntity<>(userServices.details(id), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while search view {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
