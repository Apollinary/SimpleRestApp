package org.example.validation;

import org.example.dao.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class UserValidatorTest {

    @Mock
    private User user1 = Mockito.mock(User.class);
    @Mock
    private User user2 = Mockito.mock(User.class);

    private static final long USER_ID_1 = 1;
    private static final long USER_ID_2 = 2;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        setUpUsers();
    }


    @Test
    public void testCorrectUserFields() {
        assertTrue(UserValidator.validateName(user1.getFirstName()));
        assertTrue(UserValidator.validateName(user1.getFirstName()));
        assertTrue(UserValidator.validateAge(user1.getAge()));
        assertTrue(UserValidator.validateEmail(user1.getEmail()));
        assertTrue(UserValidator.validatePhoneNumber(user1.getPhoneNumber()));
    }

    @Test
    public void testIncorrectUserFields() {
        assertFalse(UserValidator.validateName(user2.getFirstName()));
        assertFalse(UserValidator.validateName(user2.getFirstName()));
        assertFalse(UserValidator.validateAge(user2.getAge()));
        assertFalse(UserValidator.validateEmail(user2.getEmail()));
        assertFalse(UserValidator.validatePhoneNumber(user2.getPhoneNumber()));
    }

    private void setUpUsers() {
        when(user1.getFirstName()).thenReturn("Vasya");
        when(user1.getLastName()).thenReturn("Pupkin");
        when(user1.getAge()).thenReturn(18);
        when(user1.getUserId()).thenReturn(USER_ID_1);
        when(user1.getEmail()).thenReturn("vasya@mail.com");
        when(user1.getPhoneNumber()).thenReturn("81234567890");

        when(user2.getFirstName()).thenReturn("");
        when(user2.getLastName()).thenReturn("");
        when(user2.getAge()).thenReturn(0);
        when(user2.getUserId()).thenReturn(USER_ID_2);
        when(user2.getEmail()).thenReturn("petya@mailcom");
        when(user2.getPhoneNumber()).thenReturn("812fht91");
    }
}
