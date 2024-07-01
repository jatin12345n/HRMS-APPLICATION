package com.example.hrms.application.service;

import com.example.hrms.application.repository.ApplicationRepository;
import com.example.hrms.application.domain.Application;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ApplicationService {

    @Getter
    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }


    public void createApplication(Application application) {
        this.applicationRepository.createApplication(application);
    }

    public Application getApplication(String applicationId) {
        return this.applicationRepository.getApplication(applicationId);

    }

    public List<Application> getAllApplications() {
        return this.applicationRepository.findAllApplications();
    }

    public Application updateApplication(String applicationId, Map<String, Object>updates) {
        return this.applicationRepository.updateApplication(applicationId, updates);

    }

    public void deleteApplication(String applicationId) {
         this.applicationRepository.deleteApplication(applicationId);
    }
}
