package org.course.reactive.task.lessons4;

import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class DoCallbacks {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            System.out.println("inside create");
            for (int i = 0; i < 5; i++) {
               fluxSink.next(i);
            }
           //fluxSink.complete();
            fluxSink.error(new RuntimeException("oops"));
            System.out.println("--completed");
        })
                .doOnComplete(()-> System.out.println("doOnComplete"))
                .doFirst(()-> System.out.println("doFirst  "))
                .doOnNext(o -> System.out.println("doOnext : " + o))
                .doOnSubscribe( s -> System.out.println("doOnSubscription  : " + s))
                .doOnRequest( req -> System.out.println("doOnRequest : " + req))
              //  .doFirst(()-> System.out.println("doFirst 2 "))
                .doOnError( err -> System.out.println("doOnError : " + err.getMessage()))
                .doOnTerminate(()-> System.out.println("doOnTerminate"))
                .doOnCancel(()-> System.out.println("doOnCancel"))
              //  .doOnSubscribe( s -> System.out.println("doOnSubscription 2 : " + s))
                .doFinally(signalType -> System.out.println("doFinally : " + signalType))
              //  .doFirst(()-> System.out.println("doFirst 3 "))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard : " + o))
                .take(2)//doOnCancel
                .doFinally(signalType -> System.out.println("doFinally 2: " + signalType))
                .subscribe(Util.subscriber());
    }
}
