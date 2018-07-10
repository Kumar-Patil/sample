package com.taxi.controller;

import com.taxi.RequestMapper.DeliverySystemRequestMapping;
import com.taxi.RequestMapper.PricingGroupsMapping;
import com.taxi.RequestMapper.SearchPriceRequestMapping;
import com.taxi.TransferObject.DSObject;
import com.taxi.domain.DeliverySystem;
import com.taxi.domain.PricingGroups;
import com.taxi.domain.User;
import com.taxi.domain.Vendors;
import com.taxi.service.DeliverySystemService;
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
 * @author Santosh
 */
@Controller
@RequestMapping("/ds")
@Api(value = "ds")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class DeliverySystemController {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(PricingGroupsController.class);
    @Autowired
    VendorsService vendorsService;

    @Autowired
    DeliverySystemService deliverySystemService;

    @ApiOperation(value = "Add Delivery details", response = Response.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestParam("userId") long userId, @RequestBody DeliverySystemRequestMapping deliverySystemRequestMapping) {
        Response response = null;
        try {
            DeliverySystem deliverySystem = new DeliverySystem();
            deliverySystem = DSObject.DSObject(true, deliverySystemRequestMapping);
            User user = new User();
            user.setId(userId);
            deliverySystem.setUser(user);
            boolean isDS = deliverySystemService.add(deliverySystem);
            if (isDS) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "update ds details", response = Response.class)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestParam("userId") long userId, @RequestBody DeliverySystemRequestMapping deliverySystemRequestMapping) {
        Response response = null;
        try {
            DeliverySystem deliverySystem = new DeliverySystem();
            deliverySystem = DSObject.DSObject(true, deliverySystemRequestMapping);
            DeliverySystem ds = new DeliverySystem();
            User user = new User();
            user.setId(userId);
            deliverySystem.setUser(user);
            ds = deliverySystemService.findById(deliverySystemRequestMapping.getDeliveryId());
            deliverySystem.setCreatedAt(ds.getCreatedAt());
            deliverySystem.setDeliveryId(ds.getDeliveryId());
            boolean isDS = deliverySystemService.add(deliverySystem);
            if (isDS) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete ds", notes = "Delete ds", response = Response.class)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deletePrice(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        Response response = null;
        try {
            boolean isDSDeleted = deliverySystemService.updateStatus(id);
            if (isDSDeleted) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }

        } catch (Exception ex) {
            LOG.error("Exception occured while deleting {}" + ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "All ds List", notes = "Retrieves a List of ds", response = DeliverySystemRequestMapping.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> priceDetails(@RequestParam("userId") long userId) {
        try {
            return new ResponseEntity<>(deliverySystemService.list(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while getting list of pricing groups {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Pricing Groups Details", notes = "Retrieves a PricingGroups details", response = PricingGroupsTo.class)
    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> view(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        /*try {
            return new ResponseEntity<>(deliverySystemService.ViewById(id), HttpStatus.OK);

        } catch (Exception ex) {
            LOG.error("Exception occured while viewing {}" + ex.getMessage());
        }*/
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Search ds Details", notes = "Search ds Details", response = PricingTo.class)
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> priceSearch(@RequestParam("userId") long userId, @RequestBody SearchPriceRequestMapping searchPriceRequestMapping) {
        /*try {
            return new ResponseEntity<>(deliverySystemService.search(searchPriceRequestMapping.getSearch()), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while search records {}" + ex.getMessage());
        }*/
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "DS Details", notes = "Retrieves a PricingGroups details", response = PricingGroupsTo.class)
    @RequestMapping(value = "/details", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getPriceDetails(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        Response response = null;
        /*try {
            return new ResponseEntity<>(deliverySystemService.ViewById(id), HttpStatus.OK);

        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }*/
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "update ds status", response = Response.class)
    @RequestMapping(value = "/updatedsstatus", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateDSStatus(@RequestParam("userId") long userId, @RequestParam("id") long dsId, @RequestParam("status") String status) {
        Response response = null;
        try {
            boolean isDS = deliverySystemService.updateDeliveryStatus(dsId, status);
            if (isDS) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
