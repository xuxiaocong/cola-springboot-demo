package com.xxc.demo.web;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.xxc.demo.user.api.UserServiceI;
import com.xxc.demo.user.dto.UserAddCmd;
import com.xxc.demo.user.dto.UserEditCmd;
import com.xxc.demo.user.dto.UserPageCO;
import com.xxc.demo.user.dto.UserPageQry;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceI userService;

    @PostMapping("")
    public Response add(UserAddCmd cmd) {
        userService.add(cmd);
        return Response.buildSuccess();
    }

    @PatchMapping("/{id}")
    public Response edit(@PathVariable("id") Long id, @RequestBody UserEditCmd cmd) {
        userService.edit(id, cmd);
        return Response.buildSuccess();
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return Response.buildSuccess();
    }

    @GetMapping("")
    public PageResponse<UserPageCO> getPage(@Validated @ParameterObject UserPageQry qry) {
        return userService.page(qry);
    }
}
