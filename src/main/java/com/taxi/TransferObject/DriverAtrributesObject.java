package com.taxi.TransferObject;

import com.taxi.RequestMapper.DriverRequestMapper;
import com.taxi.domain.DriverAttributes;

/**
 *
 * @author
 */
public class DriverAtrributesObject {
    
    public static DriverAttributes driverAttributesObject(boolean isAddOrUpdate, DriverRequestMapper driverRequestMapper) {
        DriverAttributes driverAttributes = new DriverAttributes();
        driverAttributes.setCrb(driverRequestMapper.getCrb());
        driverAttributes.setDelivery(driverRequestMapper.getDelivery());
        driverAttributes.setFemale(driverRequestMapper.getFemale());
        driverAttributes.setLuggage(driverRequestMapper.getLuggage());
        driverAttributes.setNHS(driverRequestMapper.getNHS());
        driverAttributes.setPets(driverRequestMapper.getPets());
        driverAttributes.setStatus(driverRequestMapper.getStatus());
        driverAttributes.setTopman(driverRequestMapper.getTopman());
        driverAttributes.setUniformed(driverRequestMapper.getUniformed());
        return driverAttributes;
    }
}
