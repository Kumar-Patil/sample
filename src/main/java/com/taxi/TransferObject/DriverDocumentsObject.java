package com.taxi.TransferObject;

import com.taxi.RequestMapper.DriverRequestMapper;
import com.taxi.domain.DriverDocuments;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author
 */
public class DriverDocumentsObject {

    public static DriverDocuments driverDocumentObject(boolean isAddOrUpdate, DriverRequestMapper driverRequestMapper) {
        Calendar calendar = Calendar.getInstance();
        Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

        DriverDocuments driverDocuments = new DriverDocuments();
        
        driverDocuments.setAgreement(driverRequestMapper.getAgreement());
        driverDocuments.setInsurance(driverRequestMapper.getInsurance());
        driverDocuments.setLicencePaper(driverRequestMapper.getLicencePaper());
        driverDocuments.setLicencePhoto(driverRequestMapper.getLicencePhoto());
        
        driverDocuments.setPcoLicence(driverRequestMapper.getPcoLicence());
        driverDocuments.setPoliceDisclose(driverRequestMapper.getPoliceDisclose());
        driverDocuments.setProofOfAddress(driverRequestMapper.getProofOfAddress());
        driverDocuments.setStatus(driverRequestMapper.getStatus());
        
        driverDocuments.setUpdatedAt(currentTimestamp);
        driverDocuments.setCreatedAt(currentTimestamp);
        driverDocuments.setDeletedAt(currentTimestamp);
        return driverDocuments;
    }
}
