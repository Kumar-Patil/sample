package com.taxi.TransferObject;

import com.taxi.RequestMapper.CabsRequestMapping;
import com.taxi.domain.CabDocuments;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author
 */
public class CabsDocumentsObject {

    public static CabDocuments cabsDocumentObject(boolean isAddOrUpdate, CabsRequestMapping cabsRequestMapping) {
        Calendar calendar = Calendar.getInstance();
        Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());

        CabDocuments cabDocuments = new CabDocuments();
        cabDocuments.setCreatedAt(currentTimestamp);
        cabDocuments.setInuranceCopy(cabsRequestMapping.getInuranceCopy());
        cabDocuments.setLicencePapers(cabsRequestMapping.getLicencePapers());
        cabDocuments.setLicencePhoto(cabsRequestMapping.getLicencePhoto());
        cabDocuments.setPcolicence(cabsRequestMapping.getPcolicence());
        cabDocuments.setPoliceDisclouser(cabsRequestMapping.getPoliceDisclouser());
        cabDocuments.setProofOfAddress(cabsRequestMapping.getProofOfAddress());
        cabDocuments.setStatus(cabsRequestMapping.getStatus());
        cabDocuments.setUpdatedAt(currentTimestamp);

        return cabDocuments;
    }
}
