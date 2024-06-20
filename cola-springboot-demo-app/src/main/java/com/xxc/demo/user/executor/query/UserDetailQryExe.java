package com.xxc.demo.user.executor.query;

import com.xxc.demo.domain.user.gateway.UserGateway;
import com.xxc.demo.user.dto.UserDetailCO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailQryExe {
    private final UserGateway gateway;

    public UserDetailCO execute(Long id) {
        return gateway.getDetail(id);
    }
}
