package com.taxi.TransferObject;

import com.taxi.RequestMapper.DriverRequestMapper;
import com.taxi.domain.Cabs;
import com.taxi.domain.DriverAttributes;
import com.taxi.domain.DriverDocuments;
import com.taxi.domain.Drivers;
import com.taxi.domain.Locations;
import com.taxi.domain.User;
import com.taxi.domain.Vendors;
import com.taxi.service.CabsService;
import com.taxi.to.CabsTo;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author
 */
public class DriverObject {

    public static Drivers driverObject(boolean isAddedUpdated, Locations locations, DriverRequestMapper driverRequestMapper, long userId, Drivers details, CabsService cabsService, DriverDocuments driverDocuments, DriverAttributes driverAtrributes) throws Exception {
        Calendar calendar = Calendar.getInstance();
        Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        Drivers drivers = new Drivers();
        drivers.setLocations(locations);
        drivers.setCreatedAt(currentTimestamp);
        if (isAddedUpdated) {
            drivers.setCreatedAt(details.getCreatedAt());
            drivers.setDriverId(details.getDriverId());
        }
        drivers.setUpdatedAt(currentTimestamp);
        drivers.setFirstName(driverRequestMapper.getFirstName());
        drivers.setLastName(driverRequestMapper.getLastName());
        drivers.setPhoto(driverRequestMapper.getPhoto());
        drivers.setStatus(driverRequestMapper.getStatus());
        drivers.setEmail(driverRequestMapper.getEmail());
        drivers.setMobileNo(driverRequestMapper.getMobileNo());
        drivers.setSex(driverRequestMapper.getSex());
        drivers.setPassword(driverRequestMapper.getPassword());
        drivers.setOtherPhone(driverRequestMapper.getOtherPhone());
        drivers.setAddress(driverRequestMapper.getAddress());
        drivers.setStartDate(driverRequestMapper.getStartDate());
        drivers.setDriverLicenceNumber(driverRequestMapper.getDriverLicenceNumber());
        drivers.setDriverLicenceExpiry(driverRequestMapper.getDriverLicenceExpiry());
        drivers.setInsuranceNumber(driverRequestMapper.getInsurance());
        drivers.setAliasName(driverRequestMapper.getAliasName());

        User user = new User();

        user.setId(userId);
        Cabs cabs = new Cabs();

        cabs.setCabId(driverRequestMapper.getCabId());
        Vendors vendors = new Vendors();
        vendors.setVendorId(cabsService.vendorId(driverRequestMapper.getCabId()));
        
        drivers.setVendors(vendors);

        drivers.setUser(user);

        drivers.setCabs(cabs);

        drivers.setDriverDocuments(driverDocuments);
        drivers.setDriverAttributes(driverAtrributes);
        return drivers;
    }
}
