package com.xiaoqiang;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @author George on 2020-05-13
 **/

@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER})
public class ProviderHelloFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("hello ok ====>");
        return invoker.invoke(invocation);
    }
}
