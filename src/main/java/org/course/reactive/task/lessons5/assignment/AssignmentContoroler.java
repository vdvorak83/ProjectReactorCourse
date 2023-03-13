package org.course.reactive.task.lessons5.assignment;

import org.course.reactive.util.Util;
import reactor.core.scheduler.Schedulers;

public class AssignmentContoroler {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();



        //revenue and inv - observer the order stream
        orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeInventoryStream());

        inventoryService.inventoryStream()
                //.subscribeOn(Schedulers.newParallel("different schuduer"))
                .subscribe(Util.subscriber("inventory"));
        revenueService.revenueStream().subscribe(Util.subscriber("revenue"));

        Util.sllepSeconds(60);
    }
}
