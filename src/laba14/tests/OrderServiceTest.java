package laba14.tests;

import laba14.entity.Item;
import laba14.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    @DisplayName("Проверка расчёта стоимости без скидок для стандартного клиента")
    void testStandardOrderCalculation() {
        OrderService service = new OrderService();
        List<Item> items = List.of(new Item("Book", 100.0, 2));
        double res = service.calc(items, "STANDARD");
        assertEquals(200.0, res);
    }

    @Test
    @DisplayName("Проверка расчёта стоимости со скидкой для VIP клиента")
    void testVipDiscountCalculation() {
        OrderService service = new OrderService();
        List<Item> items = List.of(new Item("Book", 100.0, 2));
        double res = service.calc(items, "VIP");
        assertEquals(180.0, res);
    }

    @Test
    @DisplayName("Проверка расчёта стоимости со скидкой для нового клиента")
    void testNewDiscountCalculation() {
        OrderService service = new OrderService();
        List<Item> items = List.of(new Item("Book", 100.0, 2));
        double res = service.calc(items, "NEW");
        assertEquals(190.0, res);
    }

    @Test
    @DisplayName("Проверка применения пороговой скидки при сумме больше 1000")
    void testThresholdDiscountCalculation() {
        OrderService service = new OrderService();
        List<Item> items = List.of(new Item("Laptop", 1200.0, 1));
        double res = service.calc(items, "STANDARD");
        assertEquals(1150.0, res);
    }
}
