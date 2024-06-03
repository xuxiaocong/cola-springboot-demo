package com.xxc.demo.user.dto;

import com.alibaba.cola.dto.PageQuery;
import com.xxc.demo.user.dto.constant.Sex;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserPageQry extends PageQuery {
    @Parameter(description = "姓名")
    private String name;

    @Parameter(description = "性别")
    private Sex sex;
}
