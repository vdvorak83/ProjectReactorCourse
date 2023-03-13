package org.course.reactive.task.lessons5.assignment;


import java.time.Duration;
import java.util.Objects;
import reactor.core.publisher.Flux;

//database mock
public class OrderService {

    private  Flux<PurchaseOrder> purchaseOrderFlux;


    public  Flux<PurchaseOrder> orderStream(){
        if (Objects.isNull(purchaseOrderFlux) ) {
            purchaseOrderFlux = getOrdersStream();
        }
        return purchaseOrderFlux;
    }

    private   Flux<PurchaseOrder> getOrdersStream(){
        return Flux.interval(Duration.ofMillis(1000))
                .map(i->new PurchaseOrder())
                .publish()
                .refCount(2);
    }


}
