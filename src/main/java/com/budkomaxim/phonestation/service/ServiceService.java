package com.budkomaxim.phonestation.service;

import com.budkomaxim.phonestation.model.Service;

import java.util.List;

public interface ServiceService {
    public void addService(Service service);

    public void updateService(Service service);

    public void remoteService(int id);

    public Service getServiceById(int id);

    public List<Service> listServices();

}
