package org.course.reactive.task.lessons5.assignment;

import lombok.Data;
import lombok.ToString;
import org.course.reactive.util.Util;


@Data
@ToString
public class PurchaseOrder {
    private String item;
    private double price;
    private String category;
    private int quantity;

    public PurchaseOrder() {
        this.price = Double.parseDouble(Util.faker().commerce().price());
        this.item = Util.faker().commerce().productName();
        this.quantity = Util.faker().random().nextInt(1, 50);
        this.category = Util.faker().commerce().department();
    }
}
