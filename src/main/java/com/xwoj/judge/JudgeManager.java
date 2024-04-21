package com.xwoj.judge;

import com.xwoj.judge.codesandbox.model.JudgeInfo;
import com.xwoj.judge.strategy.DefaultJudgeStrategy;
import com.xwoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.xwoj.judge.strategy.JudgeContext;
import com.xwoj.judge.strategy.JudgeStrategy;
import com.xwoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 * @author 西尾coding
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getSubmitLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}