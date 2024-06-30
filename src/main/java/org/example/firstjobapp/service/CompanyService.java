package org.example.firstjobapp.service;

import org.example.firstjobapp.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();
    void createCompany(Company company);
    boolean updateCompanyById(Long id, Company company);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);
}
