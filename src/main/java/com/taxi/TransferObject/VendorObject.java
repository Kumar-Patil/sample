package com.taxi.TransferObject;

import com.taxi.RequestMapper.VendorRequestMapper;
import com.taxi.domain.Locations;
import com.taxi.domain.User;
import com.taxi.domain.Vendors;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author
 */
public class VendorObject {
    
    public static Vendors vendorObject(boolean isAddedUpdated, Locations locations, VendorRequestMapper vendorRequestMapper, long userId, Vendors details) {
        Calendar calendar = Calendar.getInstance();
        Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        Vendors vendors = new Vendors();
        vendors.setLocations(locations);
        vendors.setCreatedAt(currentTimestamp);
        if (isAddedUpdated) {
            vendors.setCreatedAt(details.getCreatedAt());
            vendors.setVendorId(details.getVendorId());
        }
        vendors.setUpdatedAt(currentTimestamp);
        vendors.setStatus(vendorRequestMapper.getStatus());
        vendors.setFirstName(vendorRequestMapper.getFirstName());
        vendors.setLastName(vendorRequestMapper.getLastName());
        vendors.setPhoto(vendorRequestMapper.getPhoto());
        vendors.setStatus(vendorRequestMapper.getStatus());
        vendors.setEmail(vendorRequestMapper.getEmail());
        vendors.setMobileNo(vendorRequestMapper.getMobileNo());
        vendors.setVendorRegistrationNo(vendorRequestMapper.getVendorRegistrationNo());
        User user = new User();
        user.setId(userId);
        vendors.setUser(user);
        return vendors;
    }
}
