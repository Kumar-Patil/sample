package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.DeliveryProgress;
import com.taxi.to.MapData;
import com.taxi.util.PolylineData;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

public class DeliveryProgressDaoImpl implements DeliveryProgressDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(DeliveryProgressDaoImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public List<PolylineData> list() throws Exception {
        List<MapData> mapDataList = new ArrayList<>();
        List<PolylineData> polylineDatas = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            session.beginTransaction();
            mapDataList = session.createSQLQuery("SELECT source as source ,destination as destination,\n"
                    + "source_lat as sourceLat, source_lng as sourceLng\n"
                    + ",destination_lat as destinationLat,destination_lng as destinationLng FROM delivery_progress\n"
                    + "where is_progress = 1")
                    .addScalar("source")
                    .addScalar("destination")
                    .addScalar("sourceLat", StandardBasicTypes.FLOAT)
                    .addScalar("sourceLng", StandardBasicTypes.FLOAT)
                    .addScalar("destinationLat", StandardBasicTypes.FLOAT)
                    .addScalar("destinationLng", StandardBasicTypes.FLOAT)
                    .setResultTransformer(Transformers.aliasToBean(MapData.class))
                    .list();
            tx.commit();
            for (MapData ts : mapDataList) {
                //https://maps.google.com/mapfiles/kml/shapes/parking_lot_maps.png
                polylineDatas.add(new PolylineData(ts.getSourceLat(), ts.getSourceLng(), "SOURCE",
                        "http://maps.google.com/mapfiles/kml/shapes/truck.png", true));
                /*polylineDatas.add(new PolylineData(ts.getDestinationLat(), ts.getDestinationLng(), "Destination",
                        "", true));
                 */
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting list {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return polylineDatas;
    }

    @Override
    public boolean update(DeliveryProgress deliveryProgress) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
