package com.xwoj.model.dto.question;

import lombok.Data;

/**
 * 判题用例
 *
 * @author 西尾coding
 * @createTime 2023/8/25 星期五 19:34
 */
@Data
public class JudgeCase {
    /**
     * 输入用例
     */
    private String input;

    /**
     * 输出用例
     */
    private String output;
}
