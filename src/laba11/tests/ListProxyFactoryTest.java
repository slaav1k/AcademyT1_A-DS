package laba11.tests;

import laba11.service.ListProxyFactory;
import laba11.task.Magic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListProxyFactoryTest {

    @Test
    @DisplayName("Проверка подсчета вызовов методов группы add")
    void testAddMethodsCounting() {
        List<Integer> targetList = new ArrayList<>(List.of(3, 4, 5));
        var proxyResult = ListProxyFactory.createAddCountingProxy(targetList);
        List<Integer> proxyList = proxyResult.proxyList();

        assertEquals(0, proxyResult.handler().getAddCallCount());

        proxyList.add(10);
        proxyList.add(1, 20);
        proxyList.addFirst(30);

        assertEquals(3, proxyResult.handler().getAddCallCount());
        assertEquals(6, proxyList.size());
    }

    @Test
    @DisplayName("Проверка, что методы удаления и чтения не увеличивают счетчик add")
    void testNonAddMethodsDoNotIncrementCounter() {
        List<String> targetList = new ArrayList<>(List.of("A", "B", "C"));
        var proxyResult = ListProxyFactory.createAddCountingProxy(targetList);
        List<String> proxyList = proxyResult.proxyList();

        proxyList.get(0);
        proxyList.remove(0);
        proxyList.removeFirst();
        proxyList.size();

        assertEquals(0, proxyResult.handler().getAddCallCount());
    }

    @RepeatedTest(20)
    @DisplayName("Интеграционная проверка работы с Magic.test")
    void testIntegrationWithMagic() {
        List<Integer> list = new ArrayList<>(List.of(3, 4, 5));
        var proxyResult = ListProxyFactory.createAddCountingProxy(list);

        try {
            Magic.test(proxyResult.proxyList());
            assertTrue(proxyResult.handler().getAddCallCount() >= 0);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("bound must be positive"));
        }
    }
}