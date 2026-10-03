package laba14.service;

import laba14.entity.Item;

import java.util.List;

public class OrderService {

    /**
     * Рассчитывает общую стоимость товаров в заказе с учетом типа клиента и применимых скидок.
     *
     * @param items список товаров в корзине
     * @param type  тип клиента (например, "VIP", "NEW" и др.)
     * @return итоговая стоимость заказа после применения скидок
     */
    public double calc(List<Item> items, String type) {
        double s = 0;
        for (Item i : items) {
            s += i.getPrice() * i.getQuantity();
        }

        if (type.equals("VIP")) {
            s = s * 0.9;
        }

        if (type.equals("NEW")) {
            s = s * 0.95;
        }

        if (s > 1000) {
            s = s - 50;
        }

        return s;
    }
}