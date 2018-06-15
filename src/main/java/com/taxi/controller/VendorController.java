package com.taxi.controller;

import com.taxi.RequestMapper.SearchRequestMapping;
import com.taxi.RequestMapper.VendorRequestMapper;
import com.taxi.TransferObject.LocationObject;
import com.taxi.TransferObject.VendorObject;
import com.taxi.domain.Locations;
import com.taxi.domain.Vendors;
import com.taxi.service.AccessTokenService;
import com.taxi.service.CitiesService;
import com.taxi.service.CountriesService;
import com.taxi.service.LocationsService;
import com.taxi.service.StateService;
import com.taxi.service.UserService;
import com.taxi.service.VendorsService;
import com.taxi.to.Response;
import com.taxi.to.UserDetails;
import com.taxi.to.VendorsTo;
import com.taxi.to.ViewVendorTo;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author
 */
@Controller
@RequestMapping("/vendor")
@Api(value = "vendor")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class VendorController {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(VendorController.class);

    @Autowired
    VendorsService vendorsService;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    LocationsService locationsService;

    @Autowired
    StateService stateService;

    @Autowired
    UserService userServices;

    @Autowired
    CountriesService countriesService;

    @Autowired
    CitiesService citiesService;

    @ApiOperation(value = "Add vendor details", response = Response.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addVendor(@RequestParam("userId") long userId, @RequestBody VendorRequestMapper vendorRequestMapper) {
        Response response = null;
        try {
            Locations locations = new Locations();
            locations = LocationObject.locationObject(true, vendorRequestMapper);
            Long locationId = locationsService.add(locations);
            locations.setLocationId(locationId);
            /*Setting of vendors detials */
            boolean isVendroAdded = vendorsService.add(VendorObject.vendorObject(false, locations, vendorRequestMapper, userId, null));
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

    @ApiOperation(value = "update vendor details", response = Response.class)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateVendor(@RequestParam("userId") long userId, @RequestBody VendorRequestMapper vendorRequestMapper) {
        Response response = null;
        try {
            Vendors details = vendorsService.details(vendorRequestMapper.getId());
            Locations locations = new Locations();
            locations = LocationObject.locationObject(true, vendorRequestMapper);
            locations.setLocationId(vendorRequestMapper.getLocationId());
            locationsService.update(locations);
            boolean isVendroAdded = vendorsService.add(VendorObject.vendorObject(true, locations, vendorRequestMapper, userId, details));
            /*Setting of vendors detials */
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

    @ApiOperation(value = "Delete vendor", notes = "Delete vendor", response = Response.class)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteVendor(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        Response response = null;
        try {
            boolean isUserDeleted = vendorsService.updateStatus(id);
            if (isUserDeleted) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            LOG.error("Exception occured while deleting vendor details{}" + ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "All Vendor List", notes = "Retrieves a List of vendors", response = VendorsTo.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> details(@RequestParam("userId") long userId) {
        List<UserDetails> details = new ArrayList();
        try {
            return new ResponseEntity<>(vendorsService.list(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while getting list of vendors {}" + ex.getMessage());
        }
        return new ResponseEntity<>(details, HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Vendor Details", notes = "Retrieves a vendor details", response = ViewVendorTo.class)
    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> viewVendor(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        try {
            return new ResponseEntity<>(vendorsService.viewById(id), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while search view {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Search Vendor Details", notes = "Search Vendor Details", response = VendorsTo.class)
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchVendor(@RequestParam("userId") long userId, @RequestBody SearchRequestMapping searchRequestMapping) {
        try {
            return new ResponseEntity<>(vendorsService.search(searchRequestMapping.getSearch()), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while search records {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Vendor Details", notes = "Retrieves a vendor details", response = VendorRequestMapper.class)
    @RequestMapping(value = "/details", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getVendor(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        Response response = null;
        try {
            return new ResponseEntity<>(vendorsService.findById(id), HttpStatus.OK);

        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
