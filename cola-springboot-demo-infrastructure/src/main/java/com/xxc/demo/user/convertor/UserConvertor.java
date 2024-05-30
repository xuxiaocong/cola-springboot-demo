package com.xxc.demo.user.convertor;

import com.xxc.demo.domain.user.model.User;
import com.xxc.demo.user.dto.UserPageCO;
import com.xxc.demo.user.mapper.dataobject.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserConvertor {
    User toEntity(UserDO dataObject);

    UserDO toDataObject(User entity);

    UserPageCO toPageCO(UserDO dataObject);

    List<UserPageCO> toPageList(List<UserDO> dataObjects);
}
