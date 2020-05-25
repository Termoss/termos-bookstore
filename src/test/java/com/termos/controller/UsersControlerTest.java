package com.termos.controller;

import com.termos.dto.ApiResponse;
import com.termos.dto.UserDTO;
import com.termos.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class)
public class UsersControlerTest {
    @Mock
    private UserService userServiceMock;
    @Test
    public void test_Users_Get_if_Users_exists() {
        // given
        Mockito.when(userServiceMock.findAll()).thenReturn(Stream.empty());
        Mockito.when(userServiceMock.getRecordCount()).thenReturn(1);
        UserController userController = new UserController(userServiceMock);

        // when
        ResponseEntity<ApiResponse<Stream<UserDTO>>> actual = userController.users();

        // then
        Assert.assertEquals("Message should be fixed", "List of all users, count: 1", actual.getBody().message);
        Assert.assertTrue("Message should be success if retrive users", actual.getBody().isSuccess);
    }

    @Test
    public void test_Users_Get_if_Users_does_not_exist() {
        // given
        Mockito.when(userServiceMock.findAll()).thenReturn(Stream.empty());
        Mockito.when(userServiceMock.getRecordCount()).thenReturn(0);
        UserController userController = new UserController(userServiceMock);

        // when
        ResponseEntity<ApiResponse<Stream<UserDTO>>> actual = userController.users();

        // then
        Assert.assertEquals("Message should be fixed", "No content on store.", actual.getBody().message);
        Assert.assertTrue("Message should be success if retrive no users", actual.getBody().isSuccess);
    }

    @Test
    public void test_Users_Get_retering_the_same_stream_as_UsersService_findAll_method() {
        // given
        Stream<UserDTO> aStream = Stream.empty();
        Mockito.when(userServiceMock.findAll()).thenReturn(aStream);
        Mockito.when(userServiceMock.getRecordCount()).thenReturn(1);
        UserController userControler = new UserController(userServiceMock);

        // when
        ResponseEntity<ApiResponse<Stream<UserDTO>>> actual = userControler.users();

        // then
        Assert.assertTrue("Message should be fixed", aStream == actual.getBody().payload);
    }
}
