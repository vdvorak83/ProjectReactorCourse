package com.lessons13.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class StepVerifiedDemoTest {


    @Test
    public void test1(){
        Flux<Integer> just = Flux.just(1,2,3,4);

        StepVerifier.create(just)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(5)
                //or 2 operation without verifyComplete
                /*.expectComplete()
                .verify()*/
                .verifyComplete();




    }

    @Test
    public void test2(){
        Flux<Integer> just = Flux.just(1,2,3,4);

        StepVerifier.create(just)
                .expectNext(1,2,3,4)
                //or 2 operation without verifyComplete
                /*.expectComplete()
                .verify()*/
                .verifyComplete();




    }
}
