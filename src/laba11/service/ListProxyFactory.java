package laba11.service;

import laba11.entity.ProxyResult;
import laba11.proxy.AddCounterInvocationHandler;

import java.lang.reflect.Proxy;
import java.util.List;

public class ListProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> ProxyResult<T> createAddCountingProxy(List<T> targetList) {
        AddCounterInvocationHandler handler = new AddCounterInvocationHandler(targetList);
        List<T> proxyInstance = (List<T>) Proxy.newProxyInstance(
                targetList.getClass().getClassLoader(),
                targetList.getClass().getInterfaces(),
                handler
        );
        return new ProxyResult<>(proxyInstance, handler);
    }
}