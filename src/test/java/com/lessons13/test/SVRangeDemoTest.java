package com.lessons13.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class SVRangeDemoTest {


    @Test
    public void test1(){

        Flux<Integer> range = Flux.range(1,50);

        StepVerifier.create(range)
                .expectNextCount(50)
               // .expectNext(1,2,3,4)
                .verifyComplete();


    }


    @Test
    public void test2(){

        Flux<Integer> range = Flux.range(1,50)
              //  .map(i -> i*2) error of  more than 100
                ;

        StepVerifier.create(range)
                .thenConsumeWhile(i -> i <100)
                // .expectNext(1,2,3,4)
                .verifyComplete();


    }



}
