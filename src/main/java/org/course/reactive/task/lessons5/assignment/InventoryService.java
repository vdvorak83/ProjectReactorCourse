package org.course.reactive.task.lessons5.assignment;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import reactor.core.publisher.Flux;

public class InventoryService {

    private Map<String,Integer> db = new HashMap<>();

    public InventoryService() {
        db.put("Kids", 100);
        db.put("Automotive", 100);
    }


    //change price
    public Consumer<PurchaseOrder> subscribeInventoryStream(){
        return  purchaseOrder -> db.computeIfPresent(purchaseOrder.getCategory(),
                (k,v)-> v - purchaseOrder.getQuantity());
    }


    public Flux<String> inventoryStream(){
        return Flux.interval(Duration.ofSeconds(2))
                .map(i->db.toString());
    }
}
