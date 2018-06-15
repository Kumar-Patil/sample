package com.taxi.controller;

import com.taxi.service.AccessTokenService;
import com.taxi.service.CabsService;
import com.taxi.service.DriversService;
import com.taxi.service.VendorsService;
import com.taxi.to.CabsTo;
import com.taxi.to.DriversTo;
import com.taxi.to.Response;
import com.taxi.to.UserDetails;
import com.taxi.to.VendorsTo;
import com.taxi.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author
 */
@Controller
@RequestMapping("/report")
@Api(value = "report")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class ReportController {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(ReportController.class);

    @Autowired
    VendorsService vendorsService;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    CabsService cabsService;

    @Autowired
    DriversService driversService;

    @ApiOperation(value = "List of Vendors", notes = "Retrieves a List of vendors", response = VendorsTo.class)
    @RequestMapping(value = "/vendorsreport", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> vendorsReport(@RequestParam("userId") long userId) {
        Response response = null;
        try {
            return new ResponseEntity<>(vendorsService.list(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while getting list of vendors {}" + ex.getMessage());
            response = new Response(Constants.SUCESS_RESPONCE, "yes");
        }
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "List of cabs", notes = "Retrieves a List of cabs", response = CabsTo.class)
    @RequestMapping(value = "/cabsreport", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> cabsReport(@RequestParam("userId") long userId, @RequestParam(name = "vendorId", required = false) Long vendorId) {
        try {
            if (vendorId == null) {
                return new ResponseEntity<>(cabsService.list(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(cabsService.listOfCabsBasedOnVendorType((long) (vendorId)), HttpStatus.OK);
            }

        } catch (Exception ex) {
            LOG.error("Exception occured while getting list of cabs {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "List of drivers", notes = "Retrieves a List of drivers", response = DriversTo.class)
    @RequestMapping(value = "/driversreport", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> driversReport(@RequestParam("userId") long userId, @RequestParam(name = "vendorId", required = false) Long vendorId) {
        try {
            if (vendorId == null) {
                return new ResponseEntity<>(driversService.list(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(driversService.listOfCabsBasedOnVendorType(vendorId), HttpStatus.OK);

            }
        } catch (Exception ex) {
            LOG.error("Exception occured while getting list of drivers {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/tripsreport", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> tripsReport(@RequestHeader(value = "api_key") String api_key, @QueryParam("userId") long userId, @QueryParam("vendorId") long vendorId) {
        try {
            if (accessTokenService.isAccessTokenValid(userId, api_key)) {
                return new ResponseEntity<>(cabsService.listOfCabsBasedOnVendorType(vendorId), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            LOG.error("Exception occured while getting list of vendors {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
