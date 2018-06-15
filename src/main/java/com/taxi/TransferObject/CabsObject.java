package com.taxi.TransferObject;

import com.taxi.RequestMapper.CabsRequestMapping;
import com.taxi.domain.CabAttributes;
import com.taxi.domain.CabDocuments;
import com.taxi.domain.Cabs;
import com.taxi.domain.Locations;
import com.taxi.domain.PricingGroups;
import com.taxi.domain.Vendors;
import com.taxi.service.CabsService;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author
 */
public class CabsObject {

    public static Cabs cabsObject(boolean isAddedUpdated, Locations locations, CabsRequestMapping cabsRequestMapping, long userId, Cabs details, CabsService cabsService, CabDocuments cabDocuments, CabAttributes cabAttributes) throws Exception {
        Calendar calendar = Calendar.getInstance();
        Cabs cabs = new Cabs();
        Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        //Setting cabs attributes and cabs documents
        if (isAddedUpdated) {
            cabs.setCreatedAt(details.getCreatedAt());
            cabs.setCabId(details.getCabId());
        }
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
        cabs.setStatus(cabsRequestMapping.getStatus());
        cabs.setVehicleStart(cabsRequestMapping.getVehicleStart());
        cabs.setYearOfRegistration(cabsRequestMapping.getYearOfRegistration());

        Vendors vendors = new Vendors();
        PricingGroups pricingGroups = new PricingGroups();
        vendors.setVendorId(cabsRequestMapping.getVendorId());
        pricingGroups.setPricingId(cabsRequestMapping.getPricingId());

        cabs.setVendors(vendors);
        cabs.setPricingGroups(pricingGroups);
        cabs.setCabAttributes(cabAttributes);
        cabs.setCabDocuments(cabDocuments);

        return cabs;
    }
}
