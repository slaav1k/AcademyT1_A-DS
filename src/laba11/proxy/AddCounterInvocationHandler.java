package laba11.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class AddCounterInvocationHandler implements InvocationHandler {
    private final Object target;
    private final AtomicInteger addCallCount = new AtomicInteger(0);

    public AddCounterInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("add")) {
            addCallCount.incrementAndGet();
        }
        return method.invoke(target, args);
    }

    public int getAddCallCount() {
        return addCallCount.get();
    }
}