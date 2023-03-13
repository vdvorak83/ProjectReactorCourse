package org.course.reactive.task.lessons9.assignment;

import java.util.function.Function;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OrderProcessor {



    public static Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> automotiveProcessing(){
        return flux -> flux
                .doOnNext(p-> p.setPrice(1.1 * p.getPrice()))
                .doOnNext(p-> p.setItem("{{ " + p.getItem() + " }}"));
    }


    public static Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> kidsProcessing(){
        return flux -> flux
                .doOnNext(p-> p.setPrice(0.1 * p.getPrice()))
                 //.doOnNext(p-> p.setItem("{{ " + p.getItem() + " }}"));
                // .flatMap(p-> p,getFreekidsOrder());
               //  .flatMap(p-> Flux.just(p,getFreekidsOrder()));
                 .flatMap(p ->
                       Flux.concat(
                               Flux.concat(Mono.just(p)),
                               getFreekidsOrderMono()
                       )
                 );
    }


    private static PurchaseOrder getFreekidsOrder(){
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setItem("FREE - " + purchaseOrder.getItem());
        purchaseOrder.setPrice(0);
        purchaseOrder.setCategory("Kids");
        return purchaseOrder;
    }


    private static Mono<PurchaseOrder> getFreekidsOrderMono(){

        return Mono.fromSupplier(()-> {
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setItem("FREE - " + purchaseOrder.getItem());
            purchaseOrder.setPrice(0);
            purchaseOrder.setCategory("Kids");
            return purchaseOrder;
        });
    }

}
