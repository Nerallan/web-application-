package com.budkomaxim.phonestation.dao.impl;

import com.budkomaxim.phonestation.dao.ServiceDao;
import com.budkomaxim.phonestation.model.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ServiceDao")
public class ServiceDaoImpl implements ServiceDao {
    private static final Logger logger =  LoggerFactory.getLogger(ServiceDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addService(Service service) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(service);
        logger.info("Service successfully added. Details: " + service);
    }

    @Override
    public void updateService(Service service) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(service);
        logger.info("Service successfully update. Details: " + service);
    }

    @Override
    public void removeService(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Service service = (Service) session.load(Service.class, new Integer(id));

        if(service != null){
            session.delete(service);
            logger.info("Service successfully removed. Details: " + service);
        }
    }

    @Override
    public Service getServiceById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Service service = (Service) session.load(Service.class, new Integer(id));
        logger.info("Service successfully loaded. Details: " + service);
        return service;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Service> listServices() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Service> serviceList = session.createQuery("from Service").list();

        for (Service service : serviceList){
            logger.info("Service list: " + service);
        }
        return serviceList;
    }
}
