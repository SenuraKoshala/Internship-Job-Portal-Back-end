package com.ruhuna.Internship_Job_Portal.service;

import com.ruhuna.Internship_Job_Portal.model.Company;
import com.ruhuna.Internship_Job_Portal.model.Student;

public interface StudentService {
    Student findStudentById(int id);
    void saveStudent(Student student);

    int findByEmail(String email, String password) throws Exception;
}
