package com.xxc.demo.user.api;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.xxc.demo.user.dto.*;

public interface UserServiceI {
    Response add(UserAddCmd cmd);

    Response edit(Long id, UserEditCmd cmd);

    Response delete(Long id);

    PageResponse<UserPageCO> page(UserPageQry qry);

    SingleResponse<UserDetailCO> getDetail(Long id);
}
