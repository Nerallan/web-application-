package com.budkomaxim.phonestation.controller;

import com.budkomaxim.phonestation.model.Service;
import com.budkomaxim.phonestation.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServiceController {
    private ServiceService serviceService;

    @Autowired(required = true)
    @Qualifier(value = "ServiceService")
    public void setServiceService(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @RequestMapping(value = "service", method = RequestMethod.GET)
    public String listServices(Model model){
        model.addAttribute("service", new Service());
        model.addAttribute("listServices", this.serviceService.listServices());
        return "service";
    }

    @RequestMapping(value = "/service/add", method = RequestMethod.POST)
    public String addService(@ModelAttribute("service") Service service){
        if(service.getId() == 0){
            this.serviceService.addService(service);
        } else {
            this.serviceService.updateService(service);
        }
        return "redirect:/service";
    }

    @RequestMapping("/remove/{id}")
    public String removeService(@PathVariable("id") int id){
        this.serviceService.remoteService(id);
        return "redirect:/service";
    }

    @RequestMapping("/edit/{id}")
    public String editService(@PathVariable("id") int id, Model model){
        model.addAttribute("service", this.serviceService.getServiceById(id));
        model.addAttribute("listServices", this.serviceService.listServices());
        return "service";
    }

    @RequestMapping("/servicedata/{id}")
    public String serviceData(@PathVariable("id") int id, Model model){
        model.addAttribute("service", this.serviceService.getServiceById(id));
        return "servicedata";
    }
}
