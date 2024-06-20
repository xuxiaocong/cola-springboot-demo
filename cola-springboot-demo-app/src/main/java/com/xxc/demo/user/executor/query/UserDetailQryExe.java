package com.xxc.demo.user.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.xxc.demo.domain.user.gateway.UserGateway;
import com.xxc.demo.user.dto.UserDetailCO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailQryExe {
    private final UserGateway gateway;

    public SingleResponse<UserDetailCO> execute(Long id) {
        UserDetailCO detailCO = gateway.getDetail(id);
        return SingleResponse.of(detailCO);
    }
}
