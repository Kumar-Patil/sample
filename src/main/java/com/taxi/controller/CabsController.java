package com.taxi.controller;

import com.taxi.RequestMapper.CabsRequestMapping;
import com.taxi.RequestMapper.SearchCabsRequestMapping;
import com.taxi.domain.Cabs;
import com.taxi.domain.PricingGroups;
import com.taxi.domain.Vendors;
import com.taxi.service.AccessTokenService;
import com.taxi.service.CabsService;
import com.taxi.service.PricingGroupsService;
import com.taxi.service.VendorsService;
import com.taxi.to.CabsTo;
import com.taxi.to.City;
import com.taxi.to.Response;
import com.taxi.to.UserDetails;
import com.taxi.util.Constants;
import com.taxi.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author
 */
@Controller
@RequestMapping("/cab")
@Api(value = "cabs")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class CabsController {

    static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(CabsController.class);
    @Autowired
    VendorsService vendorsService;

    @Autowired
    CabsService cabsService;

    @Autowired
    AccessTokenService accessTokenService;

    @Autowired
    PricingGroupsService pricingGroupsService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestHeader(value = "api_key") String api_key, @QueryParam("userId") long userId, @RequestBody CabsRequestMapping cabsRequestMapping) {
        Response response = null;
        try {
            if (accessTokenService.isAccessTokenValid(userId, api_key)) {
                Cabs cabs = new Cabs();
                Calendar calendar = Calendar.getInstance();
                Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

                cabs.setStatus(cabsRequestMapping.getStatus());
                cabs.setCreatedAt(currentTimestamp);
                cabs.setUpdatedAt(currentTimestamp);
                cabs.setCabColor(cabsRequestMapping.getCabColor());
                cabs.setCabModel(cabsRequestMapping.getCabModel());
                cabs.setCabNo(cabsRequestMapping.getCabNo());
                cabs.setCabRegistrationNo(cabsRequestMapping.getCabRegistrationNo());
                cabs.setCabType(cabsRequestMapping.getCabType());
                PricingGroups pricingGroups = new PricingGroups();
                pricingGroups.setPricingId(cabsRequestMapping.getPricingId());
                cabs.setPricingGroups(pricingGroups);
                Vendors vendors = new Vendors();
                vendors.setVendorId(cabsRequestMapping.getVendorId());
                cabs.setVendors(vendors);
                boolean isCabAdded = cabsService.add(cabs);
                if (isCabAdded) {
                    response = new Response(Constants.SUCESS_RESPONCE, "yes");
                } else {
                    response = new Response(Constants.SUCESS_RESPONCE, "no");
                }
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestHeader(value = "api_key") String api_key, @QueryParam("userId") long userId, @RequestBody CabsRequestMapping cabsRequestMapping) {
        Response response = null;
        try {
            if (accessTokenService.isAccessTokenValid(userId, api_key)) {
                Cabs cabs = new Cabs();
                Calendar calendar = Calendar.getInstance();
                Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
                CabsTo cabsTo = cabsService.findById(cabsRequestMapping.getCabId());
                cabs.setStatus(cabsRequestMapping.getStatus());
                cabs.setCreatedAt(cabsTo.getCreatedAt());
                cabs.setUpdatedAt(currentTimestamp);
                cabs.setCabColor(cabsRequestMapping.getCabColor());
                cabs.setCabModel(cabsRequestMapping.getCabModel());
                cabs.setCabNo(cabsRequestMapping.getCabNo());
                cabs.setCabRegistrationNo(cabsRequestMapping.getCabRegistrationNo());
                cabs.setCabType(cabsRequestMapping.getCabType());
                cabs.setCabId(cabsRequestMapping.getCabId());
                PricingGroups pricingGroups = new PricingGroups();
                pricingGroups.setPricingId(cabsRequestMapping.getPricingId());
                cabs.setPricingGroups(pricingGroups);
                Vendors vendors = new Vendors();
                vendors.setVendorId(cabsRequestMapping.getVendorId());
                cabs.setVendors(vendors);
                boolean isCabAdded = cabsService.add(cabs);
                if (isCabAdded) {
                    response = new Response(Constants.SUCESS_RESPONCE, "yes");
                } else {
                    response = new Response(Constants.SUCESS_RESPONCE, "no");
                }
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@RequestHeader(value = "api_key") String api_key, @QueryParam("userId") long userId, @QueryParam("id") long id) {
        Response response = null;
        try {
            if (accessTokenService.isAccessTokenValid(userId, api_key)) {
                boolean isPriceDeleted = cabsService.updateStatus(id);
                if (isPriceDeleted) {
                    response = new Response(Constants.SUCESS_RESPONCE, "yes");
                } else {
                    response = new Response(Constants.SUCESS_RESPONCE, "no");
                }
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            LOG.error("Exception occured while deleting {}" + ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Cabs", notes = "Retrieves a single customer", response = CabsTo.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    @Produces("application/json")
    public ResponseEntity<?> cabs(@RequestParam("userId") long userId, @RequestHeader HttpHeaders headers) {
        try {
            Map<String, String> headerMap = headers.toSingleValueMap();
            String api_key = headerMap.get("api_key");
            if (accessTokenService.isAccessTokenValid(userId, api_key)) {
                return new ResponseEntity<>(cabsService.list(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            LOG.error("Exception occured while getting list of vendors {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cabView(@RequestHeader(value = "api_key") String api_key, @QueryParam("userId") long userId, @QueryParam("id") long id) {
        try {
            if (accessTokenService.isAccessTokenValid(userId, api_key)) {
                return new ResponseEntity<>(cabsService.findById(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            LOG.error("Exception occured while view {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cabSearch(@RequestHeader(value = "api_key") String api_key, @QueryParam("userId") long userId, @RequestBody SearchCabsRequestMapping searchCabsRequestMapping) {
        List<UserDetails> details = new ArrayList();
        try {
            if (accessTokenService.isAccessTokenValid(userId, api_key)) {
                return new ResponseEntity<>(cabsService.search(searchCabsRequestMapping.getSearch()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            LOG.error("Exception occured while search records {}" + ex.getMessage());
        }
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCabDetails(@RequestHeader(value = "api_key") String api_key, @QueryParam("userId") long userId, @QueryParam("id") long id) {
        Response response = null;
        try {
            if (accessTokenService.isAccessTokenValid(userId, api_key)) {
                return new ResponseEntity<>(cabsService.findById(id), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Get popUPData", notes = "popUPData", response = City.class)
    @RequestMapping(value = "/popUPData", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> allList(@RequestParam("userId") long userId) {
        Response response = null;
        try {
            Map m = new HashMap<Object, Object>();
            m.put("statusList", Util.getStatusList());
            m.put("vendorList", vendorsService.list());
            m.put("priceList", pricingGroupsService.list());
            return new ResponseEntity<>(m, HttpStatus.OK);

        } catch (Exception e) {
            LOG.error("Exception occured in popData {}" + e.toString());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
