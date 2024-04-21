package com.xwoj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xwoj.common.ErrorCode;
import com.xwoj.exception.BusinessException;
import com.xwoj.exception.ThrowUtils;
import com.xwoj.mapper.UserCodeMapper;
import com.xwoj.model.entity.UserCode;
import com.xwoj.service.UserCodeService;
import org.springframework.stereotype.Service;

/**
 * @author 西尾coding
 * @description 针对表【user_code(用户)】的数据库操作Service实现
 * @createDate 2023-07-19 16:00:09
 */
@Service
public class UserCodeServiceImpl extends ServiceImpl<UserCodeMapper, UserCode>
        implements UserCodeService {

    @Override
    public UserCode getUserCodeByUserId(long userId) {
        if (userId < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<UserCode> wrapper = new QueryWrapper<>();
        wrapper.eq("userId", userId);
        UserCode userCode = this.getOne(wrapper);
        ThrowUtils.throwIf(userCode == null, ErrorCode.NULL_ERROR, "此用户不存在");
        return userCode;
    }
}




