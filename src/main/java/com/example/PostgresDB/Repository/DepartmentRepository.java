package com.example.PostgresDB.Repository;
// Java Program to Illustrate DepartmentRepository File

// Importing necessary packages

import com.example.PostgresDB.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Department entity.
 * Provides CRUD operations and custom query methods through JpaRepository.
 */
@Repository // Indicates that this interface is a Spring Data repository.
public interface DepartmentRepository extends JpaRepository<Department, Long> {}
