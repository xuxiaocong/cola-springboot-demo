package com.xxc.demo.user.executor;

import com.alibaba.cola.dto.Response;
import com.xxc.demo.domain.user.gateway.UserGateway;
import com.xxc.demo.domain.user.model.User;
import com.xxc.demo.user.dto.UserEditCmd;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEditExe {
    private final UserGateway gateway;

    public Response execute(Long id, UserEditCmd cmd) {
        User user = gateway.get(id);
        user.edit(cmd.getName(), cmd.getSex(), cmd.getPassword());
        gateway.save(user);
        return Response.buildSuccess();
    }
}
