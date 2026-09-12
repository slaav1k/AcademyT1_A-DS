package laba11.entity;

import laba11.proxy.AddCounterInvocationHandler;

import java.util.List;

public record ProxyResult<T>(List<T> proxyList, AddCounterInvocationHandler handler) {

}
