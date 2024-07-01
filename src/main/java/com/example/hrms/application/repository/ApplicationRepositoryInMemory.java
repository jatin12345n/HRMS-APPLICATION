package com.example.hrms.application.repository;

import com.example.hrms.application.exception.ApplicationDoesNotExistException;
import com.example.hrms.application.exception.DuplicateApplicationIdException;
import com.example.hrms.application.domain.Application;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ApplicationRepositoryInMemory implements ApplicationRepository {

    private final Map<String, Application> applicationMap = new ConcurrentHashMap<>();

    @Override
    public void createApplication(Application application) throws DuplicateApplicationIdException {
        Application previousApplication = applicationMap.putIfAbsent(application.getApplicationId(), application);
        if (previousApplication != null) {
            throw new DuplicateApplicationIdException(
                    "Application id " + application.getApplicationId() + "already exists");
        }
    }

    @Override
    public List<Application> findAllApplications() {
        return new ArrayList<>(applicationMap.values());
    }

    @Override
    public Application getApplication(String applicationId) {
        if (applicationMap.containsKey(applicationId)) {
            return applicationMap.get(applicationId);
        } else {
            throw new ApplicationDoesNotExistException("Application is not found");
        }
    }

    @Override
    public void clearApplications() {
        applicationMap.clear();
    }

    @Override
    public Application updateApplication(String applicationId, Map<String, Object> updates) {
        Application application = applicationMap.get(applicationId);
        if (application == null) {
            throw new ApplicationDoesNotExistException("Application not found with id: " + applicationId);
        }
        updates.forEach((key, value) -> {
            switch (key) {
                case "applicantName":
                    application.setApplicantName((String) value);
                    break;
                case "jobTitle":
                    application.setJobTitle((String) value);
                    break;

            }
        });

        applicationMap.put(applicationId, application);
        return application;
    }

    @Override
    public void deleteApplication(String applicationId) {
        applicationMap.remove(applicationId);
    }
}




