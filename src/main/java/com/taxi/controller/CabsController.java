package com.taxi.controller;

import com.taxi.RequestMapper.CabsRequestMapping;
import com.taxi.RequestMapper.SearchCabsRequestMapping;
import com.taxi.TransferObject.CabsAtrributesObject;
import com.taxi.TransferObject.CabsDocumentsObject;
import com.taxi.domain.CabAttributes;
import com.taxi.domain.CabDocuments;
import com.taxi.domain.Cabs;
import com.taxi.domain.PricingGroups;
import com.taxi.domain.Vendors;
import com.taxi.service.AccessTokenService;
import com.taxi.service.CabsAttributesService;
import com.taxi.service.CabsDocumentsService;
import com.taxi.service.CabsService;
import com.taxi.service.PricingGroupsService;
import com.taxi.service.VendorsService;
import com.taxi.to.CabsTo;
import com.taxi.to.CabsViewTo;
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
    @Autowired
    CabsAttributesService cabsAttributesService;

    @Autowired
    CabsDocumentsService cabsDocumentsService;

    @ApiOperation(value = "Add cab details", response = Response.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestParam("userId") long userId, @RequestBody CabsRequestMapping cabsRequestMapping) {
        Response response = null;
        try {
            Cabs cabs = new Cabs();
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            //Add attributes
            CabAttributes cabAttributes = CabsAtrributesObject.cabsAttributesObject(true, cabsRequestMapping);
            Long cabAttributeId = cabsAttributesService.add(cabAttributes);
            CabDocuments cabDocuments = CabsDocumentsObject.cabsDocumentObject(true, cabsRequestMapping);
            //Add documents
            Long cabDocumentId = cabsDocumentsService.add(cabDocuments);

            cabs.setStatus(cabsRequestMapping.getStatus());
            cabs.setCreatedAt(currentTimestamp);
            cabs.setUpdatedAt(currentTimestamp);
            cabs.setCabColor(cabsRequestMapping.getCabColor());
            cabs.setCabModel(cabsRequestMapping.getCabModel());
            cabs.setCabNo(cabsRequestMapping.getCabNo());
            cabs.setCabRegistrationNo(cabsRequestMapping.getCabRegistrationNo());
            cabs.setCabType(cabsRequestMapping.getCabType());
            cabs.setHireExpiry(cabsRequestMapping.getHireExpiry());
            cabs.setInsurancePolicyNumber(cabsRequestMapping.getInsurancePolicyNumber());
            cabs.setInsurer(cabsRequestMapping.getInsurer());
            cabs.setInuranceExpiryDate(cabsRequestMapping.getInuranceExpiryDate());
            cabs.setMot(cabsRequestMapping.getMot());
            cabs.setMotExpiry(cabsRequestMapping.getMotExpiry());
            cabs.setOwnerDriver(cabsRequestMapping.getOwnerDriver());
            cabs.setPlateNumber(cabsRequestMapping.getPlateNumber());
            cabs.setRoadTaxExpiry(cabsRequestMapping.getRoadTaxExpiry());
            cabs.setVehicleStart(cabsRequestMapping.getVehicleStart());
            cabs.setYearOfRegistration(cabsRequestMapping.getYearOfRegistration());

            PricingGroups pricingGroups = new PricingGroups();

            pricingGroups.setPricingId(cabsRequestMapping.getPricingId());
            cabs.setPricingGroups(pricingGroups);

            Vendors vendors = new Vendors();

            vendors.setVendorId(cabsRequestMapping.getVendorId());

            cabs.setVendors(vendors);

            cabs.setCabDocuments(cabDocuments);

            cabs.setCabAttributes(cabAttributes);

            boolean isCabAdded = cabsService.add(cabs);
            if (isCabAdded) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }

        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "update cab details", response = Response.class)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestParam("userId") long userId, @RequestBody CabsRequestMapping cabsRequestMapping) {
        Response response = null;
        try {
            Cabs cabs = new Cabs();
            Calendar calendar = Calendar.getInstance();
            Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
            Cabs cabsTo = cabsService.findById(cabsRequestMapping.getCabId());

            //Add attributes
            CabAttributes cabAttributes = CabsAtrributesObject.cabsAttributesObject(true, cabsRequestMapping);
            cabAttributes.setAttributeId(cabsTo.getCabAttributes().getAttributeId());
            cabsAttributesService.update(cabAttributes);

            CabDocuments cabDocuments = CabsDocumentsObject.cabsDocumentObject(true, cabsRequestMapping);
            cabDocuments.setDocumentId(cabsTo.getCabDocuments().getDocumentId());
            //Update documents
            cabsDocumentsService.update(cabDocuments);
            cabs.setCabId(cabsRequestMapping.getCabId());
            cabs.setStatus(cabsRequestMapping.getStatus());
            cabs.setCreatedAt(cabsTo.getCreatedAt());
            cabs.setUpdatedAt(currentTimestamp);
            cabs.setCabColor(cabsRequestMapping.getCabColor());
            cabs.setCabModel(cabsRequestMapping.getCabModel());
            cabs.setCabNo(cabsRequestMapping.getCabNo());
            cabs.setCabRegistrationNo(cabsRequestMapping.getCabRegistrationNo());
            cabs.setCabType(cabsRequestMapping.getCabType());
            cabs.setHireExpiry(cabsRequestMapping.getHireExpiry());
            cabs.setInsurancePolicyNumber(cabsRequestMapping.getInsurancePolicyNumber());
            cabs.setInsurer(cabsRequestMapping.getInsurer());
            cabs.setInuranceExpiryDate(cabsRequestMapping.getInuranceExpiryDate());
            cabs.setMot(cabsRequestMapping.getMot());
            cabs.setMotExpiry(cabsRequestMapping.getMotExpiry());
            cabs.setOwnerDriver(cabsRequestMapping.getOwnerDriver());
            cabs.setPlateNumber(cabsRequestMapping.getPlateNumber());
            cabs.setRoadTaxExpiry(cabsRequestMapping.getRoadTaxExpiry());
            cabs.setVehicleStart(cabsRequestMapping.getVehicleStart());
            cabs.setYearOfRegistration(cabsRequestMapping.getYearOfRegistration());
            cabs.setCabId(cabsTo.getCabId());
            PricingGroups pricingGroups = new PricingGroups();

            pricingGroups.setPricingId(cabsRequestMapping.getPricingId());
            cabs.setPricingGroups(pricingGroups);

            Vendors vendors = new Vendors();

            vendors.setVendorId(cabsRequestMapping.getVendorId());

            cabs.setVendors(vendors);

            cabs.setCabDocuments(cabDocuments);

            cabs.setCabAttributes(cabAttributes);
            boolean isCabAdded = cabsService.add(cabs);
            if (isCabAdded) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }
        } catch (Exception ex) {
            response = new Response(Constants.ERROR_RESPONCE, ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete cab", notes = "Delete cab", response = Response.class)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> delete(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        Response response = null;
        try {
            boolean iscabDeleted = cabsService.updateStatus(id);
            if (iscabDeleted) {
                response = new Response(Constants.SUCESS_RESPONCE, "yes");
            } else {
                response = new Response(Constants.SUCESS_RESPONCE, "no");
            }

        } catch (Exception ex) {
            LOG.error("Exception occured while deleting {}" + ex.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "All cab List", notes = "Retrieves a List of cab", response = CabsTo.class)
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> cabs(@RequestParam("userId") long userId) {
        try {
            return new ResponseEntity<>(cabsService.list(), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while getting list of vendors {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Cab cabView", notes = "Retrieves a cab details", response = CabsViewTo.class)
    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> cabView(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        try {
            return new ResponseEntity<>(cabsService.view(id), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while view {}" + ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Search cabs Details", notes = "Search cabs Details", response = CabsTo.class)
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> cabSearch(@RequestParam("userId") long userId, @RequestBody SearchCabsRequestMapping searchCabsRequestMapping) {
        List<UserDetails> details = new ArrayList();
        try {
            return new ResponseEntity<>(cabsService.search(searchCabsRequestMapping.getSearch()), HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Exception occured while search records {}" + ex.getMessage());
        }
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @ApiOperation(value = "Cabs Details", notes = "Retrieves a Cabs details", response = CabsTo.class)
    @RequestMapping(value = "/details", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getCabDetails(@RequestParam("userId") long userId, @RequestParam("id") long id) {
        Response response = null;
        try {
            return new ResponseEntity<>(cabsService.details(id), HttpStatus.OK);
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
