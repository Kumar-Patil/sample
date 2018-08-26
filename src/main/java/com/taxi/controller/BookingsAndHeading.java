package com.taxi.controller;

import io.swagger.annotations.Api;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Santosh
 */
@Controller
@RequestMapping("/bookings")
@Api(value = "bookings")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class BookingsAndHeading {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(BookingsAndHeading.class);

}
