package com.xxc.demo.user.executor;


import com.xxc.demo.domain.user.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDeleteExe {
    private final UserGateway gateway;

    public void execute(Long id) {
        gateway.delete(id);
    }
}
