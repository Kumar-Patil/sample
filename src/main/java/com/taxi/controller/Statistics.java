package com.taxi.controller;

import com.taxi.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
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
 * @author Santosh
 */
@Controller
@RequestMapping("/statistics")
@Api(value = "statistics")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class Statistics {
    
    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(Statistics.class);
    
    @Autowired
    StatisticsService statisticsService;
    
    @ApiOperation(value = "System Staticstics", notes = "System Staticstics", response = Map.class)
    @RequestMapping(value = "/staticstics", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> statistics(@RequestParam("userId") long userId) {
        try {
            Map m = new HashMap<Object, Object>();
            m.put("cabOnlineCount", statisticsService.totalCabsOnline(userId));
            m.put("availableCabsCount", statisticsService.totalCabsAvailable(userId));
            m.put("totalTrips", statisticsService.totalTrips(userId));
            m.put("totalDelivery", statisticsService.totalDelivery(userId));
            return new ResponseEntity<>(m, HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while getting staticstics {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT, HttpStatus.OK);
    }
}
