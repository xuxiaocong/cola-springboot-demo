package com.xxc.demo.user.mapper.dataobject;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xxc.demo.user.dto.constant.Sex;
import lombok.Data;

@Data
@TableName("user")
public class UserDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Sex sex;
    private String encryptedPassword;
}
