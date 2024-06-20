package com.xxc.demo.user.api;

import com.alibaba.cola.dto.PageResponse;
import com.xxc.demo.user.dto.*;

public interface UserServiceI {
    void add(UserAddCmd cmd);

    void edit(Long id, UserEditCmd cmd);

    void delete(Long id);

    PageResponse<UserPageCO> page(UserPageQry qry);

    UserDetailCO getDetail(Long id);
}
