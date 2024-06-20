package com.xxc.demo.user.executor.query;

import com.alibaba.cola.dto.PageQuery;
import com.alibaba.cola.dto.PageResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(qry.getName()), "name", qry.getName())
                .eq(qry.getSex() != null, "sex", qry.getSex())
                .orderBy(StringUtils.isNotBlank(qry.getOrderBy()), PageQuery.ASC.equals(qry.getOrderDirection()), qry.getOrderBy())
                // group在这个例子中不是特别合适
                .groupBy(StringUtils.isNotBlank(qry.getGroupBy()), qry.getGroupBy());

        IPage<UserDO> iPage = new Page<>(qry.getPageIndex(), qry.getPageSize(), qry.isNeedTotalCount());

        IPage<UserDO> pageResult = mapper.selectPage(iPage, wrapper);
        List<UserPageCO> pageList = convertor.toPageList(pageResult.getRecords());

        return PageResponse.of(pageList, (int) pageResult.getTotal(), qry.getPageSize(), qry.getPageIndex());
    }
}
