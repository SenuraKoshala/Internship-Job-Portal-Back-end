package com.ruhuna.Internship_Job_Portal.service;

import com.ruhuna.Internship_Job_Portal.dao.StudentDAOJpaImpl;
import com.ruhuna.Internship_Job_Portal.model.Company;
import com.ruhuna.Internship_Job_Portal.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDAOJpaImpl studentDAOJpa;

    public StudentServiceImpl(StudentDAOJpaImpl studentDAOJpa) {
        this.studentDAOJpa = studentDAOJpa;
    }

    @Override
    public Student findStudentById(int id) {
        return studentDAOJpa.findById(id);
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentDAOJpa.save(student);
    }

    @Override
    public int findByEmail(String email, String password) throws Exception {
        Student student = studentDAOJpa.findByEmail(email, password);
        return student.getStudentId();
    }
}
