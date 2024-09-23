package com.customerorder.test;

import com.customerorder.model.Customer;
import com.customerorder.model.Order;
import com.customerorder.service.OrderProcessingService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(1, LocalDate.of(2023, 5, 10), 150.75);
        Order order2 = new Order(2, LocalDate.of(2023, 6, 15), 225.50);
        Order order3 = new Order(3, LocalDate.of(2023, 7, 18), 90.00);
        Order order4 = new Order(4, LocalDate.of(2023, 8, 22), 400.10);

        Customer customer1 = new Customer(1, "John Doe", Arrays.asList(order1, order2));
        Customer customer2 = new Customer(2, "Jane Smith", Arrays.asList(order3, order4));

        List<Customer> customers = Arrays.asList(customer1, customer2);

        OrderProcessingService service = new OrderProcessingService();

        // Calculate total sales per customer
        Map<String, Double> totalSalesPerCustomer = service.calculateTotalSalesPerCustomer(customers);
        totalSalesPerCustomer.forEach((customer, total) ->
                System.out.println("Customer: " + customer + ", Total Sales: " + total));

        // Filter orders by minimum amount
        double minOrderAmount = 100.00;
        List<Order> filteredOrders = service.filterOrdersByMinAmount(customers, minOrderAmount);
        filteredOrders.forEach(order ->
                System.out.println("Order ID: " + order.getOrderId() + ", Amount: " + order.getTotalAmount()));
    }
}
