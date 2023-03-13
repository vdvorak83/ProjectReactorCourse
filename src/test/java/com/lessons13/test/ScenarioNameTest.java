package com.lessons13.test;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class ScenarioNameTest {

    @Test
    public void test1() {
        Flux<String> just = Flux.just("a", "b", "c");


        StepVerifierOptions stepVerifierOptions = StepVerifierOptions.create().scenarioName("alphabets-test"); //test name

        StepVerifier.create(just,stepVerifierOptions)
                .expectNextCount(12)
                .verifyComplete();
    }


    @Test
    public void test2() {
        Flux<String> just = Flux.just("a", "b1", "c");



        StepVerifier.create(just)
                .expectNext("a")
                .as("a-test")
                .expectNext("b")
                .as("b-test")
                .expectNext("c")
                .as("b-test")
                .verifyComplete();
    }
}
