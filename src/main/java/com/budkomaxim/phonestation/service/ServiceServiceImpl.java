package com.budkomaxim.phonestation.service;

import com.budkomaxim.phonestation.dao.ServiceDao;
import  org.springframework.stereotype.Service;
//import com.budkomaxim.phonestation.model.Service;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
class ServiceServiceImpl implements ServiceService {
    private ServiceDao serviceDao;

    public void setServiceDao(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    @Override
    @Transactional
    public void addService(com.budkomaxim.phonestation.model.Service service) {
        this.serviceDao.addService(service);
    }

    @Override
    @Transactional
    public void updateService(com.budkomaxim.phonestation.model.Service service) {
        this.serviceDao.updateService(service);
    }

    @Override
    @Transactional
    public void remoteService(int id) {
        this.serviceDao.removeService(id);
    }

    @Override
    @Transactional
    public com.budkomaxim.phonestation.model.Service getServiceById(int id) {
        return this.serviceDao.getServiceById(id);
    }

    @Override
    @Transactional
    public List<com.budkomaxim.phonestation.model.Service> listServices() {
        return this.serviceDao.listServices();
    }
}
