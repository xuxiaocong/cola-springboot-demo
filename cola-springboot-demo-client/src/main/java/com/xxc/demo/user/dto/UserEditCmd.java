package com.xxc.demo.user.dto;

import com.xxc.demo.user.dto.constant.Sex;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserEditCmd {
    @Schema(title = "姓名")
    @NotBlank(message = "name不能为空")
    private String name;

    @Schema(title = "性别")
    @NotEmpty(message = "sex不能为空")
    private Sex sex;

    @Schema(title = "密码")
    @NotBlank(message = "password不能为空")
    private String password;
}
