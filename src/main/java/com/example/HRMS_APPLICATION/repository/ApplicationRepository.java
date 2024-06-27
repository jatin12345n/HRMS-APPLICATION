package com.example.HRMS_APPLICATION.repository;

import com.example.HRMS_APPLICATION.exception.DuplicateApplicationIdException;
import com.example.HRMS_APPLICATION.domain.Application;

import java.util.List;

public interface ApplicationRepository{

    void createApplication(Application application)throws DuplicateApplicationIdException;

    List<Application> findAllApplications();

    Application getApplication(String applicationId);

    void clearApplications();
}
