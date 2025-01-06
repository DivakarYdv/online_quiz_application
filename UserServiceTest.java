package com.quizproject.service;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testRegisterUser() {
        boolean result = userService.registerUser("Alice", "alice@example.com", "password123");
        assertTrue(result, "User should be registered successfully");
    }

    @Test
    public void testAuthenticateUser() {
        userService.registerUser("Bob", "bob@example.com", "securepass");
        boolean isAuthenticated = userService.authenticateUser("bob@example.com", "securepass");
        assertTrue(isAuthenticated, "Authentication should be successful");
    }
}
