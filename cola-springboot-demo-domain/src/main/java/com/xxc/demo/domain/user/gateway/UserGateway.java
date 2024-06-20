package com.xxc.demo.domain.user.gateway;

import com.xxc.demo.domain.user.model.User;
import com.xxc.demo.user.dto.UserDetailCO;

public interface UserGateway {
    void save(User user);

    User get(Long id);

    void delete(Long id);

    UserDetailCO getDetail(Long id);
}
