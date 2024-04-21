package com.xwoj.judge.codesandbox;

import com.xwoj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.xwoj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.xwoj.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * @author  西尾coding
 * 代码沙箱工厂（根据字符串参数创建指定的代码沙箱实例），
 */
public class CodeSandboxFactory {

    /**
     * 创建代码沙箱实例
     *
     * @param type 沙箱类型
     * @return
     */
    public static CodeSandBox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
