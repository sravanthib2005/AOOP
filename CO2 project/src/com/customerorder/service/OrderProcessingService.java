package com.customerorder.service;

import com.customerorder.model.Customer;
import com.customerorder.model.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderProcessingService {

    // Method to calculate total sales per customer using Streams
    public Map<String, Double> calculateTotalSalesPerCustomer(List<Customer> customers) {
        return customers.stream()
                .collect(Collectors.toMap(
                        Customer::getName,
                        customer -> customer.getOrders()
                                .stream()
                                .mapToDouble(Order::getTotalAmount)
                                .sum()
                ));
    }

    // Method to filter orders by a minimum order amount
    public List<Order> filterOrdersByMinAmount(List<Customer> customers, double minAmount) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getTotalAmount() > minAmount)
                .collect(Collectors.toList());
    }
}
