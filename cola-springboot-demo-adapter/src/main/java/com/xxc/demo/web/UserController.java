package com.xxc.demo.web;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.xxc.demo.user.api.UserServiceI;
import com.xxc.demo.user.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "用户管理")
public class UserController {
    private final UserServiceI userService;

    @Operation(summary = "新增用户")
    @PostMapping("")
    public Response add(@RequestBody UserAddCmd cmd) {
        userService.add(cmd);
        return Response.buildSuccess();
    }

    @Operation(summary = "编辑")
    @PatchMapping("/{id}")
    public Response edit(@PathVariable("id") Long id, @RequestBody UserEditCmd cmd) {
        userService.edit(id, cmd);
        return Response.buildSuccess();
    }

    @Operation(summary = "删除用户")
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return Response.buildSuccess();
    }

    @Operation(summary = "分页获取列表")
    @GetMapping("")
    public PageResponse<UserPageCO> getPage(@Validated @ParameterObject UserPageQry qry) {
        return userService.page(qry);
    }

    @Operation(summary = "获取详情")
    @GetMapping("/{id}")
    public SingleResponse<UserDetailCO> getDetail(@PathVariable("id") Long id) {
        return SingleResponse.of(userService.getDetail(id));
    }
}
