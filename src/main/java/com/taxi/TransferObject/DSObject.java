package com.taxi.TransferObject;

import com.taxi.RequestMapper.DeliverySystemRequestMapping;
import com.taxi.domain.DeliverySystem;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author
 */
public class DSObject {

    public static DeliverySystem DSObject(boolean isAddOrUpdate, DeliverySystemRequestMapping dsrm) {
        DeliverySystem ds = new DeliverySystem();
        Calendar calendar = Calendar.getInstance();
        Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

        ds.setBookingAt(dsrm.getBookingAt());
        ds.setContactPersonEmail(dsrm.getContactPersonEmail());
        ds.setContactPersonMobileno(dsrm.getContactPersonMobileno());
        ds.setContactPersonName(dsrm.getContactPersonName());

        ds.setCreatedAt(currentTimestamp);
        ds.setDeliveryAt(dsrm.getDeliveryAt());
        ds.setDeliveryCurrentStatus(dsrm.getDeliveryCurrentStatus());
        ds.setNoOfUnits(dsrm.getNoOfUnits());

        ds.setOrderCategory(dsrm.getOrderCategory());
        ds.setOrderType(dsrm.getOrderType());
        ds.setPickUpAddress(dsrm.getPickUpAddress());
        ds.setPickUpAt(dsrm.getPickUpAt());

        ds.setPickUpPinCode(dsrm.getPickUpPinCode());
        ds.setReciptentAddress(dsrm.getReciptentAddress());
        ds.setReciptentName(dsrm.getReciptentName());
        ds.setReciptentEmail(dsrm.getReciptentEmail());

        ds.setReciptentMobileNo(dsrm.getReciptentMobileNo());
        ds.setReciptentPinCode(dsrm.getReciptentPinCode());
        ds.setStatus(dsrm.getStatus());
        ds.setType(dsrm.getType());
        ds.setUpdatedAt(currentTimestamp);
        ds.setWeight(dsrm.getWeight());
        return ds;
    }
}
