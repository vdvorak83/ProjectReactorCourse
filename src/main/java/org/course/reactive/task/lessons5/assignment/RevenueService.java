package org.course.reactive.task.lessons5.assignment;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class RevenueService {

    private Map<String,Double> db = new HashMap<>();

    public RevenueService() {
        db.put("Kids",0.0);
        db.put("Automotive",0.0);
    }


    //change price
    public Consumer<PurchaseOrder> subscribeOrderStream(){
        return  purchaseOrder -> db.computeIfPresent(purchaseOrder.getCategory(),
                (k,v)-> v  + purchaseOrder.getPrice());
    }


    public Flux<String> revenueStream(){
        return Flux.interval(Duration.ofSeconds(2))
                .map(i->db.toString());
               // .subscribeOn(Schedulers.boundedElastic());//example how works subsciberOn
    }
}
