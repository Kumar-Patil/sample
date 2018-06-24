package com.taxi.controller;

import com.taxi.RequestMapper.PricingGroupsMapping;
import com.taxi.RequestMapper.SearchPriceRequestMapping;
import com.taxi.domain.PricingGroups;
import com.taxi.domain.Vendors;
import com.taxi.service.AccessTokenService;
import com.taxi.service.PricingGroupsService;
import com.taxi.service.VendorsService;
import com.taxi.to.PricingGroupsTo;
import com.taxi.to.PricingTo;
import com.taxi.to.Response;
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
@RequestMapping("/price")
@Api(value = "price")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class PricingGroupsController {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(PricingGroupsController.class);
    @Autowired
    VendorsService vendorsService;

    @Autowired
    PricingGroupsService pricingGroupsService;

    @Autowired
    AccessTokenService accessTokenService;

    @ApiOperation(value = "Add pricing details", response = Response.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addPrice(@RequestParam("userId") long userId, @RequestBody PricingGroupsMapping pricingGroupsMapping) {
        Response response = null;
        try {
            /*Setting of vendors detials */
            PricingGroups pricingGroups = new PricingGroups();
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            pricingGroups.setName(pricingGroupsMapping.getPricingGroupName());
            pricingGroups.setPricePerMinute(pricingGroupsMapping.getPricePerMinute());
            pricingGroups.setPricePerUnitDistance(pricingGroupsMapping.getPricePerUnitDistance());
            pricingGroups.setStatus(pricingGroupsMapping.getStatus());
            pricingGroups.setCreatedAt(currentTimestamp);
            pricingGroups.setUpdatedAt(currentTimestamp);
            Vendors vendors = new Vendors();
            vendors.setVendorId(pricingGroupsMapping.getVendorId());
            pricingGroups.setVendors(vendors);
            boolean isVendroAdded = pricingGroupsService.add(pricingGroups);
            if (isVendroAdded) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "update pricing details", response = Response.class)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePricing(@RequestParam("userId") long userId, @RequestBody PricingGroupsMapping pricingGroupsMapping) {
        Response response = null;
        try {
            PricingGroups pricingGroups = new PricingGroups();
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            pricingGroups.setName(pricingGroupsMapping.getPricingGroupName());
            pricingGroups.setPricePerMinute(pricingGroupsMapping.getPricePerMinute());
            pricingGroups.setPricePerUnitDistance(pricingGroupsMapping.getPricePerUnitDistance());
            pricingGroups.setStatus(pricingGroupsMapping.getStatus());
            pricingGroups.setCreatedAt(pricingGroupsService.findById(pricingGroupsMapping.getPricingId()).getCreatedAt());
            pricingGroups.setUpdatedAt(currentTimestamp);
            pricingGroups.setPricingId(pricingGroupsMapping.getPricingId());
            Vendors vendors = new Vendors();
            vendors.setVendorId(pricingGroupsMapping.getVendorId());
            pricingGroups.setVendors(vendors);
            boolean isPriceUpdated = pricingGroupsService.add(pricingGroups);
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

    @ApiOperation(value = "Delete pricing group", notes = "Delete pricing group", response = Response.class)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deletePrice(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        Response response = null;
        try {
            boolean isPriceDeleted = pricingGroupsService.updateStatus(id);
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

    @ApiOperation(value = "All pricing List", notes = "Retrieves a List of pricing", response = PricingTo.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> priceDetails(@RequestParam("userId") long userId) {
        try {
            return new ResponseEntity<>(pricingGroupsService.list(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while getting list of pricing groups {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Pricing Groups Details", notes = "Retrieves a PricingGroups details", response = PricingGroupsTo.class)
    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> view(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        try {
            return new ResponseEntity<>(pricingGroupsService.ViewById(id), HttpStatus.OK);

        } catch (Exception ex) {
            LOG.error("Exception occured while viewing {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Search pricing Details", notes = "Search pricing Details", response = PricingTo.class)
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> priceSearch(@RequestParam("userId") long userId, @RequestBody SearchPriceRequestMapping searchPriceRequestMapping) {
        try {
            return new ResponseEntity<>(pricingGroupsService.search(searchPriceRequestMapping.getSearch()), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while search records {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "PricingGroups Details", notes = "Retrieves a PricingGroups details", response = PricingGroupsTo.class)
    @RequestMapping(value = "/details", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getPriceDetails(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        Response response = null;
        try {
            return new ResponseEntity<>(pricingGroupsService.ViewById(id), HttpStatus.OK);

        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
