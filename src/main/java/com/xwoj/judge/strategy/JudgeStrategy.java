package com.xwoj.judge.strategy;

import com.xwoj.judge.codesandbox.model.JudgeInfo;

/**
 * 判题策略
 * @author 西尾coding
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}