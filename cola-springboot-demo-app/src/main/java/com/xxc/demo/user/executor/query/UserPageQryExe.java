package com.xxc.demo.user.executor.query;

import com.alibaba.cola.dto.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxc.demo.user.convertor.UserConvertor;
import com.xxc.demo.user.dto.UserPageCO;
import com.xxc.demo.user.dto.UserPageQry;
import com.xxc.demo.user.mapper.UserMapper;
import com.xxc.demo.user.mapper.dataobject.UserDO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserPageQryExe {
    private final UserMapper mapper;
    private final UserConvertor convertor;

    public PageResponse<UserPageCO> execute(UserPageQry qry) {
        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(qry.getName()), UserDO::getName, qry.getName())
                .eq(qry.getSex() != null, UserDO::getSex, qry.getSex())
                .orderByDesc(UserDO::getId);

        IPage<UserDO> iPage = new Page<>(qry.getPageIndex(), qry.getPageSize());

        IPage<UserDO> pageResult = mapper.selectPage(iPage, wrapper);

        List<UserPageCO> pageList = convertor.toPageList(pageResult.getRecords());

        return PageResponse.of(pageList, (int) pageResult.getTotal(),
                (int) pageResult.getPages(), (int) pageResult.getCurrent());
    }
}
