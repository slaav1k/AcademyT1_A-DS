package laba14.service;

import laba14.entity.Item;

import java.util.List;

public class OrderService {

    private static final double VIP_DISCOUNT_MULTIPLIER = 0.9;
    private static final double NEW_DISCOUNT_MULTIPLIER = 0.95;
    private static final double THRESHOLD_AMOUNT = 1000.0;
    private static final double THRESHOLD_DISCOUNT_VALUE = 50.0;
    private static final int ITEM_COUNT_THRESHOLD = 10;
    private static final double QUANTITY_DISCOUNT_MULTIPLIER = 0.99;

    /**
     * Рассчитывает общую стоимость товаров в заказе с учетом типа клиента и применимых скидок.
     *
     * @param items список товаров в корзине
     * @param type  тип клиента (например, "VIP", "NEW" и др.)
     * @return итоговая стоимость заказа после применения скидок
     */
    public double calc(List<Item> items, String type) {
        double subtotal = calculateSubtotal(items);
        double discountedByClientType = applyClientDiscount(subtotal, type);
        double discountedByQuantity = applyQuantityDiscount(items, discountedByClientType);
        return applyThresholdDiscount(discountedByQuantity);
    }

    /**
     * Применяет дополнительную скидку 1%, если общее количество товаров больше порогового значения.
     *
     * @param items  список товаров в корзине
     * @param amount текущая сумма заказа
     * @return сумма заказа после учета количества товаров
     */
    private double applyQuantityDiscount(List<Item> items, double amount) {
        int totalQuantity = 0;
        for (Item item : items) {
            totalQuantity += item.getQuantity();
        }

        if (totalQuantity > ITEM_COUNT_THRESHOLD) {
            return amount * QUANTITY_DISCOUNT_MULTIPLIER;
        }
        return amount;
    }

    /**
     * Вычисляет промежуточную общую стоимость всех товаров без учета скидок.
     *
     * @param items список товаров в корзине
     * @return сумма стоимости всех товаров
     */
    private double calculateSubtotal(List<Item> items) {
        double sum = 0;
        for (Item item : items) {
            sum += item.getPrice() * item.getQuantity();
        }
        return sum;
    }

    /**
     * Применяет скидку в зависимости от типа клиента.
     *
     * @param amount текущая сумма заказа
     * @param type   тип клиента ("VIP", "NEW" и др.)
     * @return сумма заказа после клиентской скидки
     */
    private double applyClientDiscount(double amount, String type) {
        if ("VIP".equals(type)) {
            return amount * VIP_DISCOUNT_MULTIPLIER;
        }
        if ("NEW".equals(type)) {
            return amount * NEW_DISCOUNT_MULTIPLIER;
        }
        return amount;
    }

    /**
     * Применяет фиксированную пороговую скидку, если сумма превышает лимит.
     *
     * @param amount текущая сумма заказа
     * @return сумма заказа с учетом пороговой скидки
     */
    private double applyThresholdDiscount(double amount) {
        if (amount > THRESHOLD_AMOUNT) {
            return amount - THRESHOLD_DISCOUNT_VALUE;
        }
        return amount;
    }
}