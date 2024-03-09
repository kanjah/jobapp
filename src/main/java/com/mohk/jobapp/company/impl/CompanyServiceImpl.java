package com.mohk.jobapp.company.impl;

import com.mohk.jobapp.company.Company;
import com.mohk.jobapp.company.CompanyRepository;
import com.mohk.jobapp.company.CompanyService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

//    connection to db
    private CompanyRepository companyRepository;
//company service impl init
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @Override
//    GET ALL COMPANIES
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

//    UPDATE COMPANY

    @Override
    public boolean updateCompany(Company company, Long id) {
     Optional<Company> companyOptional = companyRepository.findById(id);
     if(companyOptional.isPresent()){
         Company companyToUpdate = companyOptional.get();
         companyToUpdate.setDescription(company.getDescription());
         companyToUpdate.setName(company.getName());
         companyToUpdate.setJobs(company.getJobs());
         companyRepository.save(companyToUpdate);
         return true;
     }
     return false;
    }
//    CREATE COMPANY
    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }
    //    DELETE COMPANY
    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

//    GET COMPANY BY ID
    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }


}



