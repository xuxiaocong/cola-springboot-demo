package com.xxc.demo.customer.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.xxc.demo.dto.CustomerListByNameQry;
import com.xxc.demo.dto.data.CustomerDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class CustomerListByNameQryExe{
    public MultiResponse<CustomerDTO> execute(CustomerListByNameQry cmd) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerName("Frank");
        customerDTOList.add(customerDTO);
        return MultiResponse.of(customerDTOList);
    }
}
