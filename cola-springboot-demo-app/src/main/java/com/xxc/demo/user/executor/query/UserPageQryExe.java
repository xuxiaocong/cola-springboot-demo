package com.xxc.demo.user.executor.query;

import com.alibaba.cola.dto.PageResponse;
import com.xxc.demo.user.dto.UserPageCO;
import com.xxc.demo.user.dto.UserPageQry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPageQryExe {
    public PageResponse<UserPageCO> execute(UserPageQry qry) {
        // TODO: 分页获取
        return null;
    }
}
