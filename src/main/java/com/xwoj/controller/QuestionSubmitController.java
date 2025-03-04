package com.xwoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xwoj.common.BaseResponse;
import com.xwoj.common.ErrorCode;
import com.xwoj.common.ResultUtils;
import com.xwoj.exception.BusinessException;
import com.xwoj.model.dto.questionsumbit.QuestionSubmitAddRequest;
import com.xwoj.model.dto.questionsumbit.QuestionSubmitQueryRequest;
import com.xwoj.model.entity.QuestionSubmit;
import com.xwoj.model.entity.User;
import com.xwoj.model.vo.QuestionSubmitVO;
import com.xwoj.service.QuestionSubmitService;
import com.xwoj.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author 西尾coding
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
@Deprecated
// @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@CrossOrigin(origins = "http://oj.kongxw.top", allowCredentials = "true")
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return 提交记录 id
     */
    @PostMapping("/sumbit")
    @ApiOperation(value = "题目提交")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                               HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取题目提交列表（除了管理员外，其他普通用户只能看到非答案、提交的代码等公开信息）
     *
     * @param questionSubmitQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page")
    @ApiOperation(value = "分页获取题目提交列表")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                         HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long pageSize = questionSubmitQueryRequest.getPageSize();

        // 从数据库中查询到原始的题目提交信息
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, pageSize),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        final User loginUer = userService.getLoginUser(request);
        // 返回脱敏信息
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUer));
    }

}
