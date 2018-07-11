package com.taxi.controller;

import com.taxi.RequestMapper.DeliverySystemRequestMapping;
import com.taxi.RequestMapper.DeliverySystemTackingHistoryRequestMapping;
import com.taxi.TransferObject.DSObject;
import com.taxi.domain.Cabs;
import com.taxi.domain.DeliverySystem;
import com.taxi.domain.DeliverySystemTrackingDetails;
import com.taxi.domain.Drivers;
import com.taxi.domain.User;
import com.taxi.service.DeliverySystemTrackingHistoryService;
import com.taxi.to.DeliverySystemTrackingHistoryTransfer;
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
@RequestMapping("/dsh")
@Api(value = "dsh")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class DeliverySystemTrackingHistoryController {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(PricingGroupsController.class);

    @Autowired
    DeliverySystemTrackingHistoryService deliverySystemTrackingHistoryService;

    @ApiOperation(value = "Assign to cab", response = Response.class)
    @RequestMapping(value = "/assign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestParam("userId") long userId, @RequestBody DeliverySystemTackingHistoryRequestMapping deliverySystemTackingHistoryRequestMapping) {
        Response response = null;
        try {
            DeliverySystemTrackingDetails deliverySystemTrackingDetails = new DeliverySystemTrackingDetails();
            Drivers drivers = new Drivers();
            drivers.setDriverId(deliverySystemTackingHistoryRequestMapping.getDriverId());

            Cabs cab = new Cabs();
            cab.setCabId(deliverySystemTackingHistoryRequestMapping.getCabId());
            deliverySystemTrackingDetails.setCabs(cab);
            User user = new User();
            user.setId(userId);

            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

            deliverySystemTrackingDetails.setCreatedAt(currentTimestamp);
            deliverySystemTrackingDetails.setDeliveryMessage(deliverySystemTackingHistoryRequestMapping.getDeliveryMessage());
            deliverySystemTrackingDetails.setDeliveryStatus(deliverySystemTackingHistoryRequestMapping.getDeliveryStatus());

            deliverySystemTrackingDetails.setDrivers(drivers);
            deliverySystemTrackingDetails.setUpdatedAt(currentTimestamp);
            deliverySystemTrackingDetails.setUser(user);
            boolean isDS = deliverySystemTrackingHistoryService.add(deliverySystemTrackingDetails);
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

    @ApiOperation(value = "Delivery history List", notes = "Retrieves a List of ds history", response = DeliverySystemTrackingHistoryTransfer.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> list(@RequestParam("userId") long userId, @RequestParam("deliveryId") long deliveryId) {
        try {
            return new ResponseEntity<>(deliverySystemTrackingHistoryService.list(deliveryId), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while getting list of ds history {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "tracking to ds", response = Response.class)
    @RequestMapping(value = "/tracking", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> trackingHitory(@RequestParam("userId") long userId, @RequestBody DeliverySystemRequestMapping deliverySystemRequestMapping) {
        Response response = null;
        /* try {
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
        }*/
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
