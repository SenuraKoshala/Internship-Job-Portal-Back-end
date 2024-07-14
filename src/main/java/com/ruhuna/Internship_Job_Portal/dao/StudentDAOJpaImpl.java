package com.ruhuna.Internship_Job_Portal.dao;

import com.ruhuna.Internship_Job_Portal.model.Company;
import com.ruhuna.Internship_Job_Portal.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOJpaImpl implements StudentDAO {

    private EntityManager entityManager;
    @Autowired
    public StudentDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student findById(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public void save(Student student) {
        Student studentSaved = entityManager.merge(student);
    }

    @Override
    public Student findByEmail(String email, String password) throws Exception {
        String query = "SELECT u FROM Student u WHERE u.email = :email";
        Student student = entityManager.createQuery(query, Student.class)
                .setParameter("email", email)
                .getSingleResult();

        if (student == null || !student.getPassword().equals(password)) {
            throw new Exception("Invalid email or password");
        }

        return student;
    }
}
