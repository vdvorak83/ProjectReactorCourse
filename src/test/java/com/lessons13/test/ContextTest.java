package com.lessons13.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;
import reactor.util.context.Context;

public class ContextTest {





    @Test
    public void test1(){

        StepVerifier.create(getWelomeMessageDeferContext())
                .expectNext("Welcome")
                .verifyComplete();

    }


    @Test
    public void test2(){

        StepVerifier.create(getWelomeMessageDeferContext())
                .verifyError(RuntimeException.class);

    }

    @Test
    public void test3(){

        StepVerifierOptions stepVerifierOptions = StepVerifierOptions.create().withInitialContext(Context.of("user", "sam"));

        StepVerifier.create(getWelomeMessageDeferContext(),stepVerifierOptions)
                .expectNext("Welcome sam")
                .verifyComplete()
                ;

    }

    private static Mono<String> getWelomeMessageDeferContext(){
        return Mono.deferContextual(contextView -> {
            if (contextView.hasKey("user")) {
                return Mono.just("Welcome " + contextView.get("user"));
            }
            else {
                return Mono.error(new RuntimeException("authenticated"));
            }
        });
    }
}
