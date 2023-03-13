package org.course.reactive.task.lessons11;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinkUnicast {


    public static void main(String[] args) {


        //Flux 1 value /empty/error 1 subscribe
        //handle through wich  publisher we eould push items
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();


        //handle through wich subscribers  will  recieve items
        Flux<Object> flux = sink.asFlux();


        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike")); //multi //unicast 1 subscriber

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");
        sink.tryEmitNext("?");


    }
}
