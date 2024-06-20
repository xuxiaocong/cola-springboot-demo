package com.xxc.demo.user.dto;

import com.xxc.demo.user.dto.constant.Sex;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDetailCO {
    @Schema(title = "id")
    private Long id;

    @Schema(title = "姓名")
    private String name;

    @Schema(title = "性别")
    private Sex sex;

    @Schema(title = "性别描述")
    public String getSexDescription() {
        return sex.getDescription();
    }
}
