package org.course.reactive.task.lessons11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SinkMulti {


    public static void main(String[] args) {

        //handle through wich  publisher we eould push items
        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();


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
