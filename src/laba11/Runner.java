package laba11;

import laba11.service.ListProxyFactory;
import laba11.task.Magic;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        // хахахаах, вообщем
        // я когда запустил в первый раз, там первый генератор 0 сделал
        // и второй выдал ошибку, что не может некстИнт(0) сделать
        // поэтому "не стесняемся, делаем"
        boolean success = false;
        int attempt = 0;

        while (!success && attempt < MAX_ATTEMPTS) {
            attempt++;
            try {
                List<Integer> list = new ArrayList<>(List.of(3, 4, 5));
                var result = ListProxyFactory.createAddCountingProxy(list);

                Magic.test(result.proxyList());

                System.out.println("Количество вызовов метода add: " + result.handler().getAddCallCount());
                success = true;
            } catch (IllegalArgumentException e) {
                System.err.println("[Попытка " + attempt + "] Ошибка в Magic.test (addNum=0), перезапуск...");

                if (attempt >= MAX_ATTEMPTS) {
                    System.err.println("Превышено максимальное количество попыток выполнения.");
                    e.printStackTrace();
                }
            }
        }
    }
}