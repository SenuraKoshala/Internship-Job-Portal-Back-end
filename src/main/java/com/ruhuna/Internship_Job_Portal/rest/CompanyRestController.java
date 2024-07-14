package com.ruhuna.Internship_Job_Portal.rest;

import com.ruhuna.Internship_Job_Portal.dao.LoginRequest;
import com.ruhuna.Internship_Job_Portal.model.Company;
import com.ruhuna.Internship_Job_Portal.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@CrossOrigin("*")
@RestController
public class CompanyRestController {

    private CompanyService companyService;

    public CompanyRestController(CompanyService companyService) {
        this.companyService = companyService;
    }

//    @GetMapping("/api/companies/{id}")
//    public ResponseEntity<Company> getCompanyById(@PathVariable int id){
//        Company company = companyService.findCompanyById(id);
//        if(company == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(company, HttpStatus.OK);
//    }

    @PostMapping("api/companies")
    public void signUpCompany(@RequestBody Company company){
        companyService.companySignUp(company);
    }

    @PostMapping("api/companies/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Company company = companyService.findByEmail(loginRequest.getEmail(), loginRequest.getPassword());
            return (ResponseEntity<?>) ResponseEntity.ok(company);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }


    @GetMapping("api/companies")
    public ResponseEntity<List<Company>> getAllCompanies(){
        List<Company> companies = companyService.findAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PostMapping("api/companies/login/company")
    public ResponseEntity<Company> getCompanyById(@RequestBody int companyId){
        Company company = companyService.findCompanyById(companyId);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
}
