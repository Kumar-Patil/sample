/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxi.controller;

import com.taxi.service.CabsOnlineService;
import com.taxi.service.DeliveryProgressService;
import com.taxi.service.TripsService;
import com.taxi.service.UserOnlineService;
import com.taxi.util.PolylineData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author santopat
 */
@Controller
@RequestMapping("/mapDetails")
@Api(value = "mapDetails")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class MapController {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(Trip.class);
    @Autowired
    CabsOnlineService cabsOnlineService;

    @Autowired
    UserOnlineService userOnlineService;

    @Autowired
    TripsService tripsService;

    @Autowired
    DeliveryProgressService deliveryProgressService;

    @ApiOperation(value = "Map Data", notes = "Map Data", response = PolylineData.class)
    @RequestMapping(value = "/mapData", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> polylineData(@RequestParam("userId") long userId, @RequestParam("type") String typeOfData) {
        try {
            List<PolylineData> polylineDatas = new ArrayList<>();
            if (typeOfData.equalsIgnoreCase("cabs")) {
                polylineDatas = cabsOnlineService.list();
            }
            if (typeOfData.equalsIgnoreCase("users")) {
                polylineDatas = userOnlineService.list();
            }
            if (typeOfData.equalsIgnoreCase("trips")) {
                polylineDatas = tripsService.polyLineData(userId, "in progress");
            }
            if (typeOfData.equalsIgnoreCase("delivery")) {
                polylineDatas = deliveryProgressService.list();
            }
            if (typeOfData.equalsIgnoreCase("all")) {
                polylineDatas.addAll(cabsOnlineService.list());
                polylineDatas.addAll(userOnlineService.list());
                polylineDatas.addAll(tripsService.polyLineData(userId, "in progress"));
                polylineDatas.addAll(deliveryProgressService.list());
            }
            if (polylineDatas.size() > 0) {
                return new ResponseEntity<>(polylineDatas, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT, HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error("Exception occured while getting map data {}" + ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
