package com.xwoj.judge.codesandbox;

import com.xwoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.xwoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author  * @createTime 2023/8/30 星期三 12:09
 * 代码沙箱接口定义
 */
public interface CodeSandBox {

    /**
     * 代码沙箱执行代码接口
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
