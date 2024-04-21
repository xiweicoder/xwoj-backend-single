package com.xwoj.judge;

import com.xwoj.model.entity.QuestionSubmit;

/**
 * @author 西尾coding
 * 判题服务 ：执行代码
 */
public interface JudgeService {
    /**
     * 判题
     *
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
