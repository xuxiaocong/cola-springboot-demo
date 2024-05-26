package com.xxc.demo.domain.customer.gateway;

import com.xxc.demo.domain.customer.Customer;

public interface CustomerGateway {
    Customer getByById(String customerId);
}
