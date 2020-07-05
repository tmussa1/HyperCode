package com.lib.stats.helper.LibStatsHelper.controller;

import com.lib.stats.helper.LibStatsHelper.entity.AccessService;
import com.lib.stats.helper.LibStatsHelper.service.AccessServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccessServiceController {

    public void setService(AccessServiceService service) {
        this.service = service;
    }

    @Autowired
    private AccessServiceService service;

    @GetMapping("/accessServices")
    public List<AccessService> getAllAccessServices() {
        return service.getAccessServices();
    }

    @GetMapping("/accessServices/id/{id}")
    public AccessService getAccessServiceById(@PathVariable("id") int id) {
        return service.getAccessServiceById(id);
    }

    @GetMapping("/accessServices/year/{year}")
    public List<AccessService> getAccessServiceByYear(@PathVariable("year") int year) {
        return service.getAccessServicesByYear(year);
    }

    @GetMapping("/accessServices/semester/{semester}")
    public AccessService getAccessServiceBySemester(@PathVariable("semester") String semester) {
        return service.getAccessServiceBySemester(semester);
    }

    @PostMapping("/accessService")
    public AccessService createAccessService(@RequestBody AccessService accessservice) {
        return service.saveAccessService(accessservice);
    }

    @PostMapping("/accessServices")
    public List<AccessService> createAccessServices(@RequestBody List<AccessService> accessservices) {
        return service.saveAccessServices(accessservices);
    }


    @DeleteMapping("/accessServices/{id}")
    public String deleteAccessService(@PathVariable int id) {
        return service.deleteAccessService(id);
    }

}