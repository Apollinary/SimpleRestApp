package org.example.controller;


import org.example.dto.ResponseTransfer;
import org.example.dto.User;
import org.example.service.UserService;
import org.example.dao.UserStatus;
import org.example.dto.rest.AddUserRequest;
import org.example.exceptions.UserNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Mock
    private UserService service = Mockito.mock(UserService.class);
    @Mock
    private AddUserRequest user1 = Mockito.mock(AddUserRequest.class);
    @Mock
    private AddUserRequest user2 = Mockito.mock(AddUserRequest.class);

    private UserController controller;

    private static final long USER_ID_1 = 1;
    private static final long USER_ID_2 = 2;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        setUpUsers();
    }

    @Test
    public void testGetMethod_whenCorrectUserRequest_thenCorrectResponse() {
        controller = new UserController(service, objectMapper, userServiceNplus1, mapper);
        when(service.findById(USER_ID_1)).thenReturn(user1);
        assertEquals(ResponseEntity.ok(user1), controller.getUser(USER_ID_1));
    }


    @Test(expected = UserNotFoundException.class)
    public void testGetMethod_whenIncorrectUserRequest_thenNotFoundResponse() {
        controller = new UserController(service, objectMapper, userServiceNplus1, mapper);
        when(service.findById(USER_ID_1)).thenReturn(new User());
        controller.getUser(USER_ID_1);
    }

    @Test
    public void testPostMethod_whenCorrectUserGiven_thenUserIdReturned() {
        controller = new UserController(service, objectMapper, userServiceNplus1, mapper);
        when(service.addUser(user1)).thenReturn(USER_ID_1);
        assertEquals(USER_ID_1, controller.addUser(user1));

    }


    @Test
    public void testPatchMethod_whenCorrectUserStatusGiven_thenCorrectResponse() {
        ResponseTransfer transfer = new ResponseTransfer();
        transfer.setUserId(USER_ID_1);
        transfer.setCurrentStatus(UserStatus.AWAY);
        transfer.setPreviousStatus(UserStatus.ONLINE);

        controller = new UserController(service, objectMapper, userServiceNplus1, mapper);
        when(service.findById(user1.getUserId())).thenReturn(user1);
        when(service.updateUserStatus(user1.getUserId(), UserStatus.AWAY)).thenReturn(UserStatus.AWAY);
        assertEquals(ResponseEntity.ok(transfer), controller.updateUserStatus(user1.getUserId(), UserStatus.AWAY));
    }

    @Test(expected = UserNotFoundException.class)
    public void testPatchMethod_whenIncorrectUserIdGiven_thenInvalidUserFieldsResponse() {
        controller = new UserController(service, objectMapper, userServiceNplus1, mapper);
        when(service.updateUserStatus(USER_ID_2, UserStatus.AWAY)).thenThrow(new NoSuchElementException());
        controller.updateUserStatus(USER_ID_2, UserStatus.AWAY);
    }

    private void setUpUsers() {
        when(user1.getFirstName()).thenReturn("Vasya");
        when(user1.getLastName()).thenReturn("Pupkin");
        when(user1.getAge()).thenReturn(18);
        when(user1.getUserId()).thenReturn(USER_ID_1);
        when(user1.getEmail()).thenReturn("vasya@mail.com");
        when(user1.getPhoneNumber()).thenReturn("81234567890");
        when(user1.getStatus()).thenReturn(UserStatus.ONLINE);


        when(user2.getFirstName()).thenReturn("Petya");
        when(user2.getLastName()).thenReturn("Pupkin");
        when(user2.getAge()).thenReturn(20);
        when(user2.getUserId()).thenReturn(USER_ID_2);
        when(user2.getEmail()).thenReturn("petya@mailcom");
        when(user2.getPhoneNumber()).thenReturn("81234567891");
        when(user2.getStatus()).thenReturn(UserStatus.ONLINE);

    }

}
