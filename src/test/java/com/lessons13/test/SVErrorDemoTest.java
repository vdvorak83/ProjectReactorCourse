package com.lessons13.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class SVErrorDemoTest {




    @Test
    public void test1(){
        Flux<Integer> just = Flux.just(1,2,3,4);
        Flux<Integer> error = Flux.error(new RuntimeException("oops"));
        Flux<Integer> concat = Flux.concat(just, error);

        StepVerifier.create(concat)
                .expectNext(1,2,3,4)
                .verifyError();




    }

    @Test
    public void test2(){
        Flux<Integer> just = Flux.just(1,2,3,4);
        Flux<Integer> error = Flux.error(new RuntimeException("oops"));
        Flux<Integer> concat = Flux.concat(just, error);

        StepVerifier.create(concat)
                .expectNext(1,2,3,4)
                .verifyError(IllegalStateException.class);




    }

    @Test
    public void test3(){
        Flux<Integer> just = Flux.just(1,2,3,4);
        Flux<Integer> error = Flux.error(new RuntimeException("oops"));
        Flux<Integer> concat = Flux.concat(just, error);

        StepVerifier.create(concat)
                .expectNext(1,2,3,4)
                .verifyError(RuntimeException.class);




    }

@Test
    public void test4(){
        Flux<Integer> just = Flux.just(1,2,3,4);
        Flux<Integer> error = Flux.error(new RuntimeException("oops"));
        Flux<Integer> concat = Flux.concat(just, error);

        StepVerifier.create(concat)
                .expectNext(1,2,3,4)
                .verifyErrorMessage("oops");




    }

}
