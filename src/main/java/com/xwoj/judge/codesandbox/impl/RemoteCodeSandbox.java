package com.xwoj.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.xwoj.common.ErrorCode;
import com.xwoj.exception.BusinessException;
import com.xwoj.judge.codesandbox.CodeSandBox;
import com.xwoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.xwoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 远程代码沙箱（实际调用接口的沙箱）
 *
 * @author 西尾coding
 */
public class RemoteCodeSandbox implements CodeSandBox {

    // 定义鉴权请求头和密钥
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        // todo 修改成线上的接口
         String url = "http://localhost:8081/executeCode";
//        String url = "http://xxxxx:8081/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
               .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
               .body(json)
               .execute()
               .body();
        if (StringUtils.isBlank(responseStr)) {
           throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
