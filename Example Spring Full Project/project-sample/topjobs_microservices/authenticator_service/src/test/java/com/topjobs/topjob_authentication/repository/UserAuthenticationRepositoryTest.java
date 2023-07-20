package com.topjobs.topjob_authentication.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.topjobs.topjob_authentication.model.User;

import org.mockito.MockitoAnnotations;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class UserAuthenticationRepositoryTest {
	
    @Autowired
    private UserRepository repo;
    
    private User user;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setUsername("test");
        user.setPassword("password");
        user.setRole("admin");
    }
    
    @AfterEach
    public void tearDown() throws Exception {
    	repo.deleteAll();
    }

    @Test
    public void testRegisterUserSuccess() {
    	repo.save(user);
        User fetchUser = repo.findById(user.getUsername()).get();
        assertThat(user.getUsername(), is(fetchUser.getUsername()));
    }

    @Test
    public void testLoginUserSuccess() {
    	repo.save(user);
        User fetchUser = repo.findById(user.getUsername()).get();
        assertThat(user.getUsername(), is(fetchUser.getUsername()));
    }



}
