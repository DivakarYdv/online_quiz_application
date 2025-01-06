package com.quizproject.dao;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;

public class UserDAOTest {
    private UserDAO userDAO;

    @BeforeEach
    public void setUp() {
        userDAO = new UserDAO();
    }

    @Test
    public void testSaveUser() {
        boolean result = userDAO.saveUser("John Doe", "john@example.com", "password123");
        assertTrue(result, "User should be saved successfully");
    }

    @Test
    public void testFindUserByEmail() {
        userDAO.saveUser("Jane Doe", "jane@example.com", "password123");
        String name = userDAO.findUserByEmail("jane@example.com");
        assertEquals("Jane Doe", name, "User should be found by email");
    }
}
