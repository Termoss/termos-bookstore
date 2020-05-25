package com.termos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Order extends AbstractModel{
    @JsonProperty("order_id")
    private String orderID;
    @JsonProperty("book_id")
    private String bookId;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("order_date")
    private Timestamp orderDate;
    private int quantity;
    private float  price;
    private String status;
    private String invoice;

    public Order(String orderID, String bookId, String userId, Timestamp orderDate, int quantity, float price, String status, String invoice) {
        this.orderID = orderID;
        this.bookId = bookId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.invoice = invoice;
    }

    @Override
    public String getId() {
        return orderID;
    }


}