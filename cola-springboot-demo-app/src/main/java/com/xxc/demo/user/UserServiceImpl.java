package com.xxc.demo.user;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.xxc.demo.user.api.UserServiceI;
import com.xxc.demo.user.dto.*;
import com.xxc.demo.user.executor.UserAddExe;
import com.xxc.demo.user.executor.UserDeleteExe;
import com.xxc.demo.user.executor.UserEditExe;
import com.xxc.demo.user.executor.query.UserDetailQryExe;
import com.xxc.demo.user.executor.query.UserPageQryExe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceI {
    private final UserAddExe userAddExe;
    private final UserEditExe userEditExe;
    private final UserDeleteExe userDeleteExe;
    private final UserPageQryExe userPageQryExe;
    private final UserDetailQryExe userDetailQryExe;

    @Override
    public Response add(UserAddCmd cmd) {
        return userAddExe.execute(cmd);
    }

    @Override
    public Response edit(Long id, UserEditCmd cmd) {
        return userEditExe.execute(id, cmd);
    }

    @Override
    public Response delete(Long id) {
        return userDeleteExe.execute(id);
    }

    @Override
    public PageResponse<UserPageCO> page(UserPageQry qry) {
        return userPageQryExe.execute(qry);
    }

    @Override
    public SingleResponse<UserDetailCO> getDetail(Long id) {
        return userDetailQryExe.execute(id);
    }
}
