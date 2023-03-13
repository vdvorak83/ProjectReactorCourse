package org.course.reactive.task.lessons9;

import java.time.Duration;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class BatchingwithBuffer {
    public static void main(String[] args) {

        eventStream()
                .buffer(5)
                .subscribe(
                Util.subscriber()
        );

        Util.sllepSeconds(60);

    }


    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(300))
                .map(i->"event : " + i);
    }
}
