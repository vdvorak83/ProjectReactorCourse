package org.course.reactive.task.lessons11;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

public class SinkMultiDisableHistory {


    public static void main(String[] args) {


        //handle through wich  publisher we eould push items
        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();
        Sinks.Many<Object> sink1 = Sinks.many().multicast().directAllOrNothing();


        //handle through wich subscribers  will  recieve items
        Flux<Object> flux = sink.asFlux();

        //flux.subscribe(Util.subscriber("sam"));
        //flux.subscribe(Util.subscriber("mike"));


        sink.tryEmitNext("HI");
        sink.tryEmitNext("how are  you?");



        flux.subscribe(Util.subscriber("sam"));
      flux.subscribe(Util.subscriber("mike"));
        sink.tryEmitNext("?");
        flux.subscribe(Util.subscriber("jake"));
        sink.tryEmitNext("new message");
      //  Util.sllepSeconds(3);


    }
}
