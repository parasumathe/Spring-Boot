package com.example.PostgresDB.Controller;

// Java Program to Demonstrate DepartmentController File
import com.example.PostgresDB.Entity.Department;
import com.example.PostgresDB.Service.DepartmentService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing Department entities.
 * Handles HTTP requests and routes them to the appropriate service methods.
 */
@RestController // Marks this class as a RESTful controller.
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService; // Injects the DepartmentService dependency.

    Logger logger =
            LoggerFactory.getLogger(DepartmentController.class);
    /**
     * Handles POST requests to save a new department.
     * @param department the department entity to be saved
     * @return the saved department entity
     */
    @PostMapping("/departments")
    public Department saveDepartment( @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    /**
     * Handles GET requests to fetch the list of all departments.
     * @return a list of department entities
     */
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        logger.info("Fetching all departments PPPP");
        return departmentService.fetchDepartmentList();
    }

    /**
     * Handles PUT requests to update an existing department.
     * @param department the department entity with updated information
     * @param departmentId the ID of the department to be updated
     * @return the updated department entity
     */
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId) {
        return departmentService.updateDepartment(department, departmentId);
    }

    /**
     * Handles DELETE requests to remove a department by ID.
     * @param departmentId the ID of the department to be deleted
     * @return a success message
     */
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully";
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }
}