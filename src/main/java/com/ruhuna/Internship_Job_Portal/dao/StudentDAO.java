package com.ruhuna.Internship_Job_Portal.dao;

import com.ruhuna.Internship_Job_Portal.model.Company;
import com.ruhuna.Internship_Job_Portal.model.Student;

public interface StudentDAO {
    Student findById(int id);
    void save(Student student);

    public Student findByEmail(String email, String password) throws Exception;
}
