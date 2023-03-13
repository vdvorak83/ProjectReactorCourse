package com.lessons13.test;

import java.time.Duration;
import org.course.reactive.task.lessons9.helper.BookOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class VirtualTimeTest {

    @Test
    public void test1(){

        // Mono<BookOrder> bookOrderMono = Mono.just(new BookOrder()); // equals next row
       // Mono<BookOrder> bookOrderMono = Mono.fromSupplier(()->new BookOrder());

        StepVerifier.withVirtualTime(()->timeConsumingFlux())
                .thenAwait(Duration.ofSeconds(30))
                .expectNext("1a","2a","3a","4a")
                //or 2 operation without verifyComplete
                /*.expectComplete()
                .verify()*/
                .verifyComplete();
    }


    @Test
    public void test2(){

        // Mono<BookOrder> bookOrderMono = Mono.just(new BookOrder()); // equals next row
        // Mono<BookOrder> bookOrderMono = Mono.fromSupplier(()->new BookOrder());

        StepVerifier.withVirtualTime(()->timeConsumingFlux())
               // .expectSubscription() //sub is an event
                .expectSubscription() //sub is an event
                .expectNoEvent(Duration.ofSeconds(4))//6 error
                .thenAwait(Duration.ofSeconds(20))
                .expectNext("1a","2a","3a","4a")
                //or 2 operation without verifyComplete
                /*.expectComplete()
                .verify()*/
                .verifyComplete();
    }


    //publisher
    private Flux<String> timeConsumingFlux(){
        return Flux.range(1, 4)
                .delayElements(Duration.ofSeconds(5))
                .map((i->i+"a"));
    }
}
