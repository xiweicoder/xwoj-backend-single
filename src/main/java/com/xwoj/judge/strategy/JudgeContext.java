package com.xwoj.judge.strategy;


import com.xwoj.judge.codesandbox.model.JudgeInfo;
import com.xwoj.model.dto.question.JudgeCase;
import com.xwoj.model.entity.Question;
import com.xwoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 * @author 西尾coding
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
