package com.taxi.daoImpl;

import com.taxi.dao.*;
import com.taxi.domain.UserOnline;
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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

public class UserOnlineDaoImpl implements UserOnlineDao {

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;
    static final Logger LOG = Logger.getLogger(UserOnlineDaoImpl.class);

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public Long add(UserOnline userOnline) throws Exception {
        Long userOnlineId = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            userOnlineId = (Long) session.save(userOnline);
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while adding {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userOnlineId;
    }

    @Override
    public UserOnline findById(long id) throws Exception {
        UserOnline userOnline = null;
        try {
            session = sessionFactory.openSession();
            userOnline = (UserOnline) session.load(UserOnline.class, id);
            tx = session.getTransaction();
            session.beginTransaction();
            tx.commit();
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userOnline;
    }

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
                    + ",destination_lat as destinationLat,destination_lng as destinationLng FROM user_online\n"
                    + "where is_online = 1")
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
                polylineDatas.add(new PolylineData(ts.getSourceLat(), ts.getSourceLng(), "SOURCE",
                        "http://maps.google.com/mapfiles/kml/pal4/icon37.png", true));
                //polylineDatas.add(new PolylineData(ts.getDestinationLat(), ts.getDestinationLng(), "Destination",
                 //       "", true));
            }
        } catch (HibernateException e) {
            LOG.error("Exception occured while getting findById {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return polylineDatas;
    }

    @Override
    @Cascade({CascadeType.SAVE_UPDATE})
    public boolean update(UserOnline userOnline) throws Exception {
        boolean isUpdated = false;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(userOnline);
            tx.commit();
            isUpdated = true;
        } catch (HibernateException e) {
            LOG.error("Exception occured while update {}" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return isUpdated;
    }
}
