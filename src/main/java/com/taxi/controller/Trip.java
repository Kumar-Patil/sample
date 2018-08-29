package com.taxi.controller;

import com.taxi.RequestMapper.BookingRequestMapping;
import com.taxi.domain.Cabs;
import com.taxi.domain.Trips;
import com.taxi.domain.User;
import com.taxi.service.TripsService;
import com.taxi.to.Response;
import com.taxi.to.TripsInProgress;
import com.taxi.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/statistics")
@Api(value = "statistics")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class Trip {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(Trip.class);

    @Autowired
    TripsService tripsService;

    @ApiOperation(value = "Trips in Progress", notes = "Trips in Progress", response = TripsInProgress.class)
    @RequestMapping(value = "/tripsongoing", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> tripsonprogress(@RequestParam("userId") long userId) {
        try {
            List<TripsInProgress> inProgresses = tripsService.tripsInProgress(userId, "in progress");
            if (inProgresses.size() > 0) {
                return new ResponseEntity<>(inProgresses, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT, HttpStatus.OK);
            }
        } catch (Exception ex) {
            LOG.error("Exception occured while getting system staticstics {}" + ex.getMessage());
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @ApiOperation(value = "Add Bookings", response = Response.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestParam("userId") long userId, @RequestBody BookingRequestMapping bookingRequestMapping) {
        Response response = null;
        try {
            Trips trips = new Trips();
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

            trips.setLat(userId);
            trips.setLng(userId);

            /*User rider = new User();
            rider.setId(bookingRequestMapping.getCust_id());
            trips.setUserRider(rider);

            User userVendor = new User();
            userVendor.setId(bookingRequestMapping.getCust_id());
            trips.setUserVendor(userVendor);

            User userDriver = new User();
            rider.setId(bookingRequestMapping.getCust_id());
            trips.setUserDriver(userDriver);
             */
            User user = new User();
            user.setId(userId);
            trips.setUserDriver(user);
            trips.setUserRider(user);
            trips.setUserVendor(user);
            
            Cabs cab = new Cabs();
            cab.setCabId(new Long(1));
            trips.setCab(cab);

            trips.setSource(bookingRequestMapping.getSource());
            trips.setDestination(bookingRequestMapping.getDestination());

            trips.setCreatedAt(currentTimestamp);
            trips.setUpdatedAt(currentTimestamp);

            //Yet Get these values
            trips.setActual_distance(0);
            trips.setActual_end_time(currentTimestamp);
            trips.setActual_fare(0);
            trips.setActual_start_time(currentTimestamp);

            trips.setEstimated_distance(0);
            trips.setEstimated_end_time(currentTimestamp);
            trips.setEstimated_fare(0);

            trips.setEstimated_start_time(currentTimestamp);
            trips.setEvent_message("Bookking");
            trips.setLast_updated_at(currentTimestamp);
            trips.setTrip_status("in progress");

            Long isAdded = tripsService.add(trips);
            if (isAdded != null) {
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
