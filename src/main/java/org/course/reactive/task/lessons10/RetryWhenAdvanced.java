package org.course.reactive.task.lessons10;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

public class RetryWhenAdvanced {


    public static void main(String[] args) {


        orderService(Util.faker().business().creditCardNumber())
                .doOnError(err -> System.out.println(err.getMessage())) // erorr
                 //.retry(5) //basic
                //with logic
                .retryWhen(Retry.from(
                        retrySignalFlux -> retrySignalFlux
                                .doOnNext(retrySignal ->
                                {
                                    System.out.println("Total retrie :" + retrySignal.totalRetries());
                                    System.out.println("Failre retrie : " + retrySignal.failure());
                                })
                                .handle(((retrySignal, synchronousSink) -> {
                                    if(retrySignal.failure().getMessage().equals("500"))
                                        synchronousSink.next(1);
                                    else
                                        synchronousSink.error(retrySignal.failure());
                                }))
                                .delayElements(Duration.ofSeconds(1))
                ))
                .subscribe(Util.subscriber());

Util.sllepSeconds(60);
    }


    //order service
    private static Mono<String> orderService(String cccNumber) {
        return Mono.fromSupplier(()->{
            processPayment(cccNumber);
            return Util.faker().idNumber().valid();
        });
    }

//payment service

    private static void processPayment(String ccNumber){
        int random = Util.faker().random().nextInt(1, 10);
        if(random < 8)
            throw new RuntimeException("500");
        else if (random < 10)
            throw new RuntimeException("404");
    }

}
