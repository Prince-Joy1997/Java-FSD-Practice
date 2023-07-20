package com.topjobs.topjob_authentication.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.topjobs.topjob_authentication.exception.DuplicateUsernameException;
import com.topjobs.topjob_authentication.exception.UsernameNotFoundException;
import com.topjobs.topjob_authentication.model.User;
import com.topjobs.topjob_authentication.repository.UserRepository;

import java.util.Optional;

public class UserAuthenticationServiceTest {

    @Mock
    private UserRepository repo;
    
    private User user;
    
    @InjectMocks
    private UserServiceImpl service;
    
    Optional<User> optional;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setUsername("Testid");
        user.setPassword("testpassword");
        user.setRole("admin");
        optional = Optional.of(user);
    }
    
    @Test
    public void testRegisterUserSuccess() throws DuplicateUsernameException {

        Mockito.when(repo.save(user)).thenReturn(user);
        User user1 = service.registerUser(user);
        assertEquals(user, user1);
    }
    
    @Test
    public void testRegisterUserFailure() {

        Mockito.when(repo.findById("Testid")).thenReturn(optional);
        Mockito.when(repo.save(user)).thenReturn(user);
        assertThrows(
        		DuplicateUsernameException.class,
                    () -> { service.registerUser(user); });

    }
    
    @Test
    public void testLogin() throws UsernameNotFoundException {
        Mockito.when(repo.findByUsernameAndPasswordAndRole("Testid", "testpassword", "admin")).thenReturn(user);
        boolean flag = service.login("Testid", "testpassword", "admin");
        assertEquals(true, flag);
    }
    
    @Test
    public void testLoginFailure() {
    	  Mockito.when(repo.findById("Testid")).thenReturn(optional);
          Mockito.when(repo.save(user)).thenReturn(user);
          assertThrows(
        		  UsernameNotFoundException.class,
                      () -> { service.login("Testid", "testpassword", "admin"); });

    }


}
