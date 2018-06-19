package com.taxi.controller;

import com.taxi.RequestMapper.DriverRequestMapper;
import com.taxi.RequestMapper.SearchRequestMapping;
import com.taxi.TransferObject.DriverAtrributesObject;
import com.taxi.TransferObject.DriverDocumentsObject;
import com.taxi.TransferObject.DriverLocationObject;
import com.taxi.TransferObject.DriverObject;
import com.taxi.domain.DriverAttributes;
import com.taxi.domain.DriverDocuments;
import com.taxi.domain.Drivers;
import com.taxi.domain.Locations;
import com.taxi.service.AccessTokenService;
import com.taxi.service.CabsService;
import com.taxi.service.DriversAttributesService;
import com.taxi.service.DriversDocumentsService;
import com.taxi.service.DriversService;
import com.taxi.service.LocationsService;
import com.taxi.service.UserService;
import com.taxi.to.DriversTo;
import com.taxi.to.Response;
import com.taxi.to.ViewDriver;
import com.taxi.util.Constants;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author
 */
@Controller
@RequestMapping("/driver")
@Api(value = "driver")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@CrossOrigin
public class DriverController {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(DriverController.class);

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    LocationsService locationsService;

    @Autowired
    UserService userServices;

    @Autowired
    DriversService driversService;

    @Autowired
    CabsService cabsService;

    @Autowired
    DriversAttributesService driversAttributesService;

    @Autowired
    DriversDocumentsService driversDocumentsService;

    @ApiOperation(value = "Add driver details", response = Response.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addDriver(@RequestParam("userId") long userId, @RequestBody DriverRequestMapper driverRequestMapper) {
        Response response = null;
        try {
            Locations locations = new Locations();
            locations = DriverLocationObject.locationObject(true, driverRequestMapper);
            Long locationId = locationsService.add(locations);
            locations.setLocationId(locationId);
            //Driver Attributes
            DriverAttributes driverAttributes = new DriverAttributes();
            driverAttributes = DriverAtrributesObject.driverAttributesObject(true, driverRequestMapper);
            Long attributeId = driversAttributesService.add(driverAttributes);
            driverAttributes.setDriverAttribteId(attributeId);
            //Driver documents
            DriverDocuments driverDocuments = new DriverDocuments();
            driverDocuments = DriverDocumentsObject.driverDocumentObject(true, driverRequestMapper);
            Long documentId = driversDocumentsService.add(driverDocuments);
            driverDocuments.setDriverDocumentId(documentId);

            boolean isDriverAdded = driversService.add(DriverObject.driverObject(false,
                    locations, driverRequestMapper, userId, null, cabsService, driverDocuments, driverAttributes));
            if (isDriverAdded) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }

        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Update driver details", response = Response.class)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateDriver(@RequestParam("userId") long userId, @RequestBody DriverRequestMapper driverRequestMapper) {
        Response response = null;
        try {
            Drivers details = driversService.locationId(driverRequestMapper.getDriverId());
            Locations locations = new Locations();
            locations = DriverLocationObject.locationObject(true, driverRequestMapper);
            locations.setLocationId(details.getLocations().getLocationId());
            locationsService.update(locations);

            //Driver Attributes
            DriverAttributes driverAttributes = new DriverAttributes();
            driverAttributes = DriverAtrributesObject.driverAttributesObject(true, driverRequestMapper);
            driverAttributes.setDriverAttribteId(driverRequestMapper.getDriverAttribteId());
            driversAttributesService.update(driverAttributes);

            //Driver documents
            DriverDocuments driverDocuments = new DriverDocuments();
            driverDocuments = DriverDocumentsObject.driverDocumentObject(true, driverRequestMapper);
            driverDocuments.setDriverDocumentId(driverRequestMapper.getDriverDocumentId());
            driversDocumentsService.update(driverDocuments);

            boolean isDriverAdded = driversService.add(DriverObject.driverObject(true, locations, driverRequestMapper, userId, details, cabsService, driverDocuments, driverAttributes));
            if (isDriverAdded) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Driver", notes = "Delete Driver Details", response = Response.class)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteDriver(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        Response response = null;
        try {
            boolean isDriverDeleted = driversService.updateStatus(id);
            if (isDriverDeleted) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            LOG.error("Exception occured while deleting {}" + ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "All Driver List", notes = "Retrieves a List of drivers", response = DriversTo.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<?> driverList(@RequestParam("userId") long userId) {
        try {
            return new ResponseEntity<>(driversService.list(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while getting list of vendors {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Driver Details", notes = "Retrieves a driver details", response = ViewDriver.class)
    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @Produces("application/json")
    public ResponseEntity<?> view(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        List<DriversTo> details = new ArrayList();
        try {
            return new ResponseEntity<>(driversService.ViewById(id), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while search view {}" + ex.getMessage());
        }
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @ApiOperation(value = "Search Driver Details", notes = "Search Driver Details", response = DriversTo.class)
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchDriver(@RequestParam("userId") long userId, @RequestBody SearchRequestMapping searchRequestMapping) {
        try {
            return new ResponseEntity<>(driversService.search(searchRequestMapping.getSearch()), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while search records {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Driver Details", notes = "Retrieves a driver details", response = DriversTo.class)
    @RequestMapping(value = "/details", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @Produces("application/json")
    public ResponseEntity<?> editDetails(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        try {
            return new ResponseEntity<>(driversService.findById(id), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while getting edit details" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
