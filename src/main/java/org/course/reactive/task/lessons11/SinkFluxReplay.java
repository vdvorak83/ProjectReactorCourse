package org.course.reactive.task.lessons11;

import java.time.Duration;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SinkFluxReplay {


    public static void main(String[] args) {

        Sinks.Many<Object> sink = Sinks.many().replay().all();

        Flux<Object> flux = sink.asFlux();
        sink.tryEmitNext("Hi");
        sink.tryEmitNext("how are you");

        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));

        sink.tryEmitNext("?");

        flux.subscribe(Util.subscriber("jake"));


        sink.tryEmitNext("new msg");

        Util.sllepSeconds(10);


    }
}
