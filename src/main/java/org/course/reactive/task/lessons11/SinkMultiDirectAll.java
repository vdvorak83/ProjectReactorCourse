package org.course.reactive.task.lessons11;

import java.time.Duration;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SinkMultiDirectAll {


    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small", "256");
        //handle through wich  publisher we eould push items
        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();
      //  Sinks.Many<Object> sink = Sinks.many().multicast().directBestEffort();


        //handle through wich subscribers  will  recieve items
        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Util.subscriber("sam"));

        flux
                .delayElements(Duration.ofMillis(200))
                .subscribe(Util.subscriber("mike"));


        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);
        }
        Util.sllepSeconds(10);


    }
}
