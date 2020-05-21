package com.termos.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
@Data

public class OrderDTO extends AbstractDTO{
    @NotNull
    @NotEmpty
    private String orderId;

    @NotNull
    @NotEmpty
    private String bookId;

    @NotNull
    @NotEmpty
    private String userId;


    @NotNull
    private java.sql.Timestamp orderDate;

    @NotNull
    private int quantity;

    @NotNull
    @NotEmpty
    private float price;

    @NotNull
    @NotEmpty
    private String status;

    @NotNull
    @NotEmpty
    private String invoice;

}