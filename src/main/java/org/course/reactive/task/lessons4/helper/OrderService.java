package org.course.reactive.task.lessons4.helper;


import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

//database mock
public class OrderService {
    private static Map<Integer, List<PurchaseOrder>> db = new HashMap<>();

    static {
        List<PurchaseOrder> list1 = Arrays.asList(
                new PurchaseOrder(1),
                new PurchaseOrder(1),
                new PurchaseOrder(1)
        );

        List<PurchaseOrder>  list2 = Arrays.asList(
          new PurchaseOrder(2),
          new PurchaseOrder(2)
        );

        db.put(1, list1);
        db.put(2, list2);

    }

   //get from DB
    //public static Flux<Object> getOrders(int userId){ use Flux
    //FluxSink<PurchaseOrder> use if return Flux<PurchaseOrder>
    public static Flux<PurchaseOrder> getOrders(int userId){
        return Flux.create((FluxSink<PurchaseOrder> purchaseOrderFluxSink ) -> {
            db.get(userId).forEach(purchaseOrderFluxSink::next);
            purchaseOrderFluxSink.complete();
        })
                .delayElements(Duration.ofMillis(1000));
    }


    public static Flux<Object> getOrdersObjets(int userId){
        return Flux.create((purchaseOrderFluxSink ) -> {
            db.get(userId).forEach(purchaseOrderFluxSink::next);
            purchaseOrderFluxSink.complete();
        })
         .delayElements(Duration.ofMillis(1000));//+ change return to Objects
    }

}
