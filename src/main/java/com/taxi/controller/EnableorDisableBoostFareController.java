/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxi.controller;

import com.taxi.RequestMapper.EnableOrDisableBoostPrice;
import static com.taxi.controller.Statistics.LOG;
import com.taxi.domain.EnableOrDisableBoostingFare;
import com.taxi.service.EnableOrDisableBoostingFareService;
import com.taxi.to.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @author santopat
 */
@Controller
@RequestMapping("/boostfare")
@Api(value = "boostfare")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class EnableorDisableBoostFareController {

    @Autowired
    EnableOrDisableBoostingFareService boostingFareService;

    @ApiOperation(value = "Enable/Disable boosting price", notes = "Enable/Disable boosting price", response = Response.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> list(@RequestParam("userId") long userId) {
        try {
            return new ResponseEntity<>(boostingFareService.list(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while getting staticstics {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT, HttpStatus.OK);
    }

    @ApiOperation(value = "update enable/disable boost/surge pricing", notes = "update enable/disable boost/surge pricing", response = EnableOrDisableBoostPrice.class)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePricing(@RequestParam("userId") long userId, @RequestBody EnableOrDisableBoostPrice enableOrDisableBoostPrice) {
        try {

            EnableOrDisableBoostingFare enableOrDisableBoostingFare = new EnableOrDisableBoostingFare();
            enableOrDisableBoostingFare.setBoostEnable(enableOrDisableBoostPrice.getBoostEnable());
            enableOrDisableBoostingFare.setId(enableOrDisableBoostPrice.getId());
            enableOrDisableBoostingFare.setSurgeEnable(enableOrDisableBoostPrice.getSurgeEnable());
            boostingFareService.update(enableOrDisableBoostingFare);

        } catch (Exception ex) {
            LOG.error("Exception occure while updating boost pricing {}", ex);
            return new ResponseEntity<>(enableOrDisableBoostPrice, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(enableOrDisableBoostPrice, HttpStatus.OK);
    }
}
