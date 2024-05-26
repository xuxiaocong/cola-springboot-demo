package com.xxc.demo.domain.customer.gateway;

import com.xxc.demo.domain.customer.Credit;

//Assume that the credit info is in another distributed Service
public interface CreditGateway {
    Credit getCredit(String customerId);
}
