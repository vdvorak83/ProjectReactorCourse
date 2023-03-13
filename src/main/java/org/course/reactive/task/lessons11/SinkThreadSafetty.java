package org.course.reactive.task.lessons11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SinkThreadSafetty {


    public static void main(String[] args) {



        //handle through wich  publisher we eould push items
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();


        //handle through wich subscribers  will  recieve items
        Flux<Object> flux = sink.asFlux();
        List<Object> list = new ArrayList<>();

        flux.subscribe(list::add);

        /*for (int i = 0; i < 1000; i++) {
            final int j =i;
            CompletableFuture.runAsync(()->{
               // Sinks.EmitResult emitResult = sink.tryEmitNext(j);
                sink.tryEmitNext(j);
            });
        }*/

        for (int i = 0; i < 1000; i++) {
            final int j =i;
            CompletableFuture.runAsync(()->{
                sink.emitNext(j,(s,e)->true);
            });
        }

        Util.sllepSeconds(3);
        System.out.println("list size  is " + list.size());

    }
}
