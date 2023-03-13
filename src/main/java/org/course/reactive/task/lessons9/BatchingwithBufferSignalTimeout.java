package org.course.reactive.task.lessons9;

import java.time.Duration;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class BatchingwithBufferSignalTimeout {
    public static void main(String[] args) {

        eventStream()
               // .buffer(Duration.ofSeconds(2))
                .bufferTimeout(5,Duration.ofSeconds(2))
                .subscribe(
                Util.subscriber()
        );

     //   Util.sllepSeconds(60);

    }


    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(10))
                .map(i->"event : " + i);
    }
}
