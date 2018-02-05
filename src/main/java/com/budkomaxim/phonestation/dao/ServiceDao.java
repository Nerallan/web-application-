package com.budkomaxim.phonestation.dao;

import com.budkomaxim.phonestation.model.Service;

import java.util.List;

public interface ServiceDao {

    public void addService(Service service);

    public void updateService(Service service);

    public void removeService(int id);

    public Service getServiceById(int id);

    public List<Service> listServices();

}
