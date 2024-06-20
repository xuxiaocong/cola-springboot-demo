package com.xxc.demo.user.executor;

import com.alibaba.cola.dto.Response;
import com.xxc.demo.domain.user.gateway.UserGateway;
import com.xxc.demo.domain.user.model.User;
import com.xxc.demo.user.dto.UserAddCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAddExe {
    private final UserGateway gateway;

    public Response execute(UserAddCmd cmd) {
        User user = new User(cmd.getName(), cmd.getSex(), cmd.getPassword());
        gateway.save(user);
        return Response.buildSuccess();
    }
}
