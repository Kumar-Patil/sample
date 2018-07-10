package com.taxi.TransferObject;

import com.taxi.RequestMapper.CabsRequestMapping;
import com.taxi.domain.CabAttributes;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author
 */
public class CabsAtrributesObject {

    public static CabAttributes cabsAttributesObject(boolean isAddOrUpdate, CabsRequestMapping cabsRequestMapping) {
        CabAttributes cabAttributes = new CabAttributes();
        Calendar calendar = Calendar.getInstance();
        Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
        cabAttributes.setAvgCondition(cabsRequestMapping.getAvgCondition());
        cabAttributes.setCreatedAt(currentTimestamp);
        cabAttributes.setUpdatedAt(currentTimestamp);
        cabAttributes.setEightSeater(cabsRequestMapping.getEightSeater());
        cabAttributes.setExexutive(cabsRequestMapping.getExexutive());
        cabAttributes.setFiveSeater(cabsRequestMapping.getFiveSeater());
        cabAttributes.setFourSeater(cabsRequestMapping.getFourSeater());
        cabAttributes.setGoodCOndition(cabsRequestMapping.getGoodCOndition());
        cabAttributes.setSevenSeater(cabsRequestMapping.getSevenSeater());
        cabAttributes.setSixSeater(cabsRequestMapping.getSixSeater());
        cabAttributes.setWheelChair(cabsRequestMapping.getWheelChair());
        return cabAttributes;
    }
}
