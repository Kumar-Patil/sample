package com.taxi.controller;

import com.taxi.RequestMapper.SearchSurgeRequestMapping;
import com.taxi.RequestMapper.SurgePricingMapping;
import com.taxi.domain.SurgePricing;
import com.taxi.service.AccessTokenService;
import com.taxi.service.SurgePricingService;
import com.taxi.service.VendorsService;
import com.taxi.to.Response;
import com.taxi.to.SurgePricingTo;
import com.taxi.to.SurgePricingViewTo;
import com.taxi.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.Timestamp;
import java.util.Calendar;
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
@RequestMapping("/surge")
@Api(value = "price")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class SurgeController {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(SurgeController.class);

    @Autowired
    VendorsService vendorsService;

    @Autowired
    SurgePricingService surgePricingService;

    @Autowired
    AccessTokenService accessTokenService;

    @ApiOperation(value = "Add surge pricing details", response = Response.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addSurge(@RequestParam("userId") long userId, @RequestBody SurgePricingMapping surgePricingMapping) {
        Response response = null;
        try {
            /*Setting of SurgePricing detials */
            SurgePricing surgePricing = new SurgePricing();
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

            surgePricing.setName(surgePricingMapping.getName());
            surgePricing.setStatus(surgePricingMapping.getStatus());
            surgePricing.setCreatedAt(currentTimestamp);
            surgePricing.setUpdatedAt(currentTimestamp);
            surgePricing.setFactor(surgePricingMapping.getFactor());
            surgePricing.setLatitudeEnd(surgePricingMapping.getLatitudeEnd());
            surgePricing.setLatitudeStart(surgePricingMapping.getLatitudeStart());
            surgePricing.setLongitudeEnd(surgePricingMapping.getLongitudeEnd());
            surgePricing.setLongitudeStart(surgePricingMapping.getLongitudeStart());
            surgePricing.setSurgeExpiryEndDate(surgePricingMapping.getSurgeExpiryEndDate());
            surgePricing.setSurgeExpiryStartDate(surgePricingMapping.getSurgeExpiryStartDate());
            boolean isSurgePriceAdded = surgePricingService.add(surgePricing);
            if (isSurgePriceAdded) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "update surge pricing details", response = Response.class)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSurge(@RequestParam("userId") long userId, @RequestBody SurgePricingMapping surgePricingMapping) {
        Response response = null;
        try {
            /*Setting of SurgePricing detials */
            SurgePricing surgePricing = new SurgePricing();
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            SurgePricingTo surgePricingDetails = surgePricingService.ViewById(surgePricingMapping.getSurgeId());
            surgePricing.setName(surgePricingMapping.getName());
            surgePricing.setStatus(surgePricingMapping.getStatus());
            surgePricing.setCreatedAt(surgePricingDetails.getCreatedAt());
            surgePricing.setUpdatedAt(currentTimestamp);
            surgePricing.setFactor(surgePricingMapping.getFactor());
            surgePricing.setLatitudeEnd(surgePricingMapping.getLatitudeEnd());
            surgePricing.setLatitudeStart(surgePricingMapping.getLatitudeStart());
            surgePricing.setLongitudeEnd(surgePricingMapping.getLongitudeEnd());
            surgePricing.setLongitudeStart(surgePricingMapping.getLongitudeStart());
            surgePricing.setSurgeExpiryEndDate(surgePricingMapping.getSurgeExpiryEndDate());
            surgePricing.setSurgeExpiryStartDate(surgePricingMapping.getSurgeExpiryStartDate());
            surgePricing.setSurgeId(surgePricingDetails.getSurgeId());
            boolean isPriceUpdated = surgePricingService.add(surgePricing);
            if (isPriceUpdated) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete surge pricing details", notes = "Delete surge pricing details", response = Response.class)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteSurge(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        Response response = null;
        try {
            boolean isPriceDeleted = surgePricingService.updateStatus(id);
            if (isPriceDeleted) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            LOG.error("Exception occured while deleting {}" + ex.getMessage());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Surge pricing List", notes = "Retrieves a List of surge pricing", response = SurgePricingTo.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> surgeDetails(@RequestParam("userId") long userId) {
        try {
            return new ResponseEntity<>(surgePricingService.list(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while getting list of vendors {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Surge Pricing details", notes = "Retrieves a surge pricing details", response = SurgePricingViewTo.class)
    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> viewSurge(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        try {
            return new ResponseEntity<>(surgePricingService.ViewById(id), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while search view {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Search Surge Pricing Details", notes = "Search Surge Pricing Details", response = SurgePricingTo.class)
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchSurge(@RequestParam("userId") long userId, @RequestBody SearchSurgeRequestMapping searchSurgeRequestMapping) {
        try {
            return new ResponseEntity<>(surgePricingService.search(searchSurgeRequestMapping.getSearch()), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while search records {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Surge Pricing Details", notes = "Surge Pricing Details", response = SurgePricingViewTo.class)
    @RequestMapping(value = "/details", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getSurgeEditDetail(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        Response response = null;
        try {
            return new ResponseEntity<>(surgePricingService.updateDetails(id), HttpStatus.OK);
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
