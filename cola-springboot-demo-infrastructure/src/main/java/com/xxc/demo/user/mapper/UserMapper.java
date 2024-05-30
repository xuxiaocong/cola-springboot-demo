package com.xxc.demo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxc.demo.user.mapper.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
