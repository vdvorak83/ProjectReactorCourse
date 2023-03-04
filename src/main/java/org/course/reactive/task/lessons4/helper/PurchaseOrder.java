package org.course.reactive.task.lessons4.helper;

import lombok.Data;
import lombok.ToString;
import org.course.reactive.util.Util;


@Data
@ToString
public class PurchaseOrder {
    private String item;
    private String price;
    private int userId;

    public PurchaseOrder(int userId) {
        this.price = Util.faker().commerce().price();
        this.item = Util.faker().commerce().productName();
        this.userId = userId;
    }
}
