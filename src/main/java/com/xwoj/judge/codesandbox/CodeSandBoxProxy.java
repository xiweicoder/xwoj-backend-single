package com.xwoj.judge.codesandbox;

import com.xwoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.xwoj.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 西尾coding

 * 代理代码沙箱接口
 */
@Slf4j
@AllArgsConstructor
public class CodeSandBoxProxy implements CodeSandBox {

    private CodeSandBox codeSandBox;

    /**
     * 代码沙箱执行代码接口
     *
     * @param executeCodeRequest
     * @return
     */
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息" + executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        log.info("代码沙箱响应信息" + executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
