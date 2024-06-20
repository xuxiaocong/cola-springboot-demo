package com.xxc.demo.user.executor;


import com.alibaba.cola.dto.Response;
import com.xxc.demo.domain.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDeleteExe {
    private final UserGateway gateway;

    public Response execute(Long id) {
        gateway.delete(id);
        return Response.buildSuccess();
    }
}
