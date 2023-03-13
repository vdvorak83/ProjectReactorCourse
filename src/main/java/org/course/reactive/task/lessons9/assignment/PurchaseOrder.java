package org.course.reactive.task.lessons9.assignment;

import lombok.Data;
import lombok.ToString;
import org.course.reactive.util.Util;


@Data
@ToString
public class PurchaseOrder {
    private String item;
    private double price;
    private String category;

    public PurchaseOrder() {
        this.price = Double.parseDouble(Util.faker().commerce().price());
        this.item = Util.faker().commerce().productName();
        this.category = Util.faker().commerce().department();
    }
}
