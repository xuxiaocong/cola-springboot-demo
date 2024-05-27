package com.xxc.demo.domain.user.model;

import com.xxc.demo.user.dto.constant.Sex;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Sex sex;
    private String encryptedPassword;

    public User(String name, Sex sex, String password) {
        this.name = name;
        this.sex = sex;
        this.encryptedPassword = getMd5(password);
    }

    public void edit(String name, Sex sex, String password) {
        this.name = name;
        this.sex = sex;
        if (password != null) {
            this.encryptedPassword = getMd5(password);
        }
    }

    /**
     * 使用md5加密
     *
     * @param password 原始密码
     * @return md5加密后的密码
     */
    private String getMd5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}
