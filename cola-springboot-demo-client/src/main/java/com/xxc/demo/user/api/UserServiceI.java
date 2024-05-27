package com.xxc.demo.user.api;

import com.alibaba.cola.dto.PageResponse;
import com.xxc.demo.user.dto.UserAddCmd;
import com.xxc.demo.user.dto.UserEditCmd;
import com.xxc.demo.user.dto.UserPageCO;
import com.xxc.demo.user.dto.UserPageQry;

public interface UserServiceI {
    void add(UserAddCmd cmd);

    void edit(Long id, UserEditCmd cmd);

    void delete(Long id);

    PageResponse<UserPageCO> page(UserPageQry qry);
}
