package com.xxc.demo.user.gatewayimpl;

import com.xxc.demo.domain.user.gateway.UserGateway;
import com.xxc.demo.domain.user.model.User;
import com.xxc.demo.user.convertor.UserConvertor;
import com.xxc.demo.user.mapper.UserMapper;
import com.xxc.demo.user.mapper.dataobject.UserDO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {
    private final UserMapper mapper;
    private final UserConvertor convertor;


    @Override
    public void save(User user) {
        UserDO dataObject = convertor.toDataObject(user);
        if (dataObject.getId() == null) {
            mapper.insert(dataObject);
            user.setId(dataObject.getId());
        } else {
            mapper.updateById(dataObject);
        }
    }

    @Override
    public User get(Long id) {
        UserDO dataObject = mapper.selectById(id);
        return convertor.toEntity(dataObject);
    }

    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }
}
