package org.course.reactive.task.lessons4;

import java.time.Duration;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class Delay {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.x", "9");
        Flux.range(1, 100) //32
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());
        Util.sllepSeconds(60);
    }
}
