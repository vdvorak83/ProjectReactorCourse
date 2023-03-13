package org.course.reactive.task.lessons4;

import org.course.reactive.task.lessons4.helper.OrderService;
import org.course.reactive.task.lessons4.helper.UserService;
import org.course.reactive.util.Util;

public class ConcatMapOperator {

    public static void main(String[] args) {

        UserService.getUsers()
                // returm Flux not Date
                //.map(user -> OrderService.getOrders(user.getUserId()))
                .concatMap(user -> OrderService.getOrders(user.getUserId()))

                .subscribe(Util.subscriber());

        Util.sllepSeconds(10);

       /* UserService.getUsers()
                // returm Flux not Date
                //.map(user -> OrderService.getOrders(user.getUserId()))
                .concatMap(user -> OrderService.getOrdersObjets(user.getUserId()))

                .subscribe(Util.subscriber());*/
    }
}
