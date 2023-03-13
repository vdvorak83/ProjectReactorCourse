package com.lessons13.test;

import java.time.Duration;
import org.course.reactive.task.lessons9.helper.BookOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class SVAssertDemoTest {


    @Test
    public void test1(){

       // Mono<BookOrder> bookOrderMono = Mono.just(new BookOrder()); // equals next row
        Mono<BookOrder> bookOrderMono = Mono.fromSupplier(()->new BookOrder());

        StepVerifier.create(bookOrderMono)
                .assertNext(bookOrder -> Assertions.assertNotNull(bookOrder.getAuthor()))
                //or 2 operation without verifyComplete
                /*.expectComplete()
                .verify()*/
                .verifyComplete();




    }


    @Test
    public void test2(){

        // Mono<BookOrder> bookOrderMono = Mono.just(new BookOrder()); // equals next row
        Mono<BookOrder> bookOrderMono = Mono.fromSupplier(()->new BookOrder())
                .delayElement(Duration.ofSeconds(3));

        StepVerifier.create(bookOrderMono)
                .assertNext(bookOrder -> Assertions.assertNotNull(bookOrder.getAuthor()))
                //or 2 operation without verifyComplete
                /*.expectComplete()
                .verify()*/
                .expectComplete()
                .verify(Duration.ofSeconds(4));//2 - error




    }


}
