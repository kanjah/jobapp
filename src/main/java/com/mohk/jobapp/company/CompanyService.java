package com.mohk.jobapp.company;

import java.util.List;

public interface CompanyService {
        //    GET COMPANY
        List<Company> getAllCompanies();

    // UPDATE COMPANY
        boolean updateCompany(Company company, Long id);

       // CREATE COMPANY
       void createCompany(Company company);

    //    DELETE JOB
    boolean deleteCompanyById(Long id);

//    GET COMPANY BY ID
    Company getCompanyById(Long id);
}



