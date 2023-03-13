package org.course.reactive.task.lessons11;

import org.course.reactive.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinkOneMulyileSub {


    public static void main(String[] args) {


        //mono 1 value /empty/error N subscribe
        Sinks.One<Object> sink = Sinks.one();

        Mono<Object> objectMono = sink.asMono();
        //sink.tryEmitValue("TRRR");
        objectMono.subscribe(Util.subscriber("sam"));
        objectMono.subscribe(Util.subscriber("mike"));


       // sink.tryEmitValue("HI");

      //  sink.tryEmitEmpty();
       // sink.tryEmitError(new RuntimeException("errr"));

       /* sink.emitValue("hi", ((signalType, emitResult) -> {
            System.out.println("EmitValueSignalType : " + signalType.name());
            System.out.println("EmitValueResult : " + emitResult.name());
            return false;
        }));*/
//Util.sllepSeconds(10);
        //wrong
        /*sink.emitValue("hello", ((signalType, emitResult) -> {
            System.out.println("EmitValueSignalType : " + signalType.name());
            System.out.println("EmitValueResult : " + emitResult.name());
            return true;//wrong while
        }));*/

        sink.tryEmitValue("HELLO");
    }
}
