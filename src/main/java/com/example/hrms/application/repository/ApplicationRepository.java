package com.example.hrms.application.repository;

import com.example.hrms.application.exception.DuplicateApplicationIdException;
import com.example.hrms.application.domain.Application;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ApplicationRepository {

    void createApplication(Application application) throws DuplicateApplicationIdException;

    List<Application> findAllApplications();

    Application getApplication(String applicationId);

    void clearApplications();

    Application updateApplication(String applicationId, Map<String, Object> updates);


    void deleteApplication(String applicationId);
}
