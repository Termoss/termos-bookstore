package com.termos.controller;

import com.termos.dto.ApiResponse;
import com.termos.dto.OrderDTO;
import com.termos.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class)
public class OrdersControlerTest {
    @Mock
    private OrderService orderServiceMock;
    @Test
    public void test_Orders_Get_if_Order_exists() {
        // given
        Mockito.when(orderServiceMock.findAll()).thenReturn(Stream.empty());
        Mockito.when(orderServiceMock.getRecordCount()).thenReturn(1);
        OrderController orderController = new OrderController(orderServiceMock);

        // when
        ResponseEntity<ApiResponse<Stream<OrderDTO>>> actual = orderController.orders();

        // then
        Assert.assertEquals("Message should be fixed", "List of all orders, count: 1", actual.getBody().message);
        Assert.assertTrue("Message should be success if retrive order", actual.getBody().isSuccess);
    }

    @Test
    public void test_Orders_Get_if_Orders_does_not_exist() {
        // given
        Mockito.when(orderServiceMock.findAll()).thenReturn(Stream.empty());
        Mockito.when(orderServiceMock.getRecordCount()).thenReturn(0);
        OrderController orderController = new OrderController(orderServiceMock);

        // when
        ResponseEntity<ApiResponse<Stream<OrderDTO>>> actual = orderController.orders();

        // then
        Assert.assertEquals("Message should be fixed", "No content on store.", actual.getBody().message);
        Assert.assertTrue("Message should be success if retrive no orders", actual.getBody().isSuccess);
    }

    @Test
    public void test_Orders_Get_retering_the_same_stream_as_orderService_findAll_method() {
        // given
        Stream<OrderDTO> aStream = Stream.empty();
        Mockito.when(orderServiceMock.findAll()).thenReturn(aStream);
        Mockito.when(orderServiceMock.getRecordCount()).thenReturn(1);
        OrderController orderController = new OrderController(orderServiceMock);

        // when
        ResponseEntity<ApiResponse<Stream<OrderDTO>>> actual = orderController.orders();

        // then
        Assert.assertTrue("Message should be fixed", aStream == actual.getBody().payload);
    }
}
