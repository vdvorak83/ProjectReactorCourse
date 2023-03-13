package org.course.reactive.task.lessons12;

import org.course.reactive.util.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class ContextAuthHeders {
    public static void main(String[] args) {

   getWelomeMessage()
           .subscribe(Util.subscriber());

   getWelomeMessageDeferContext()
           .contextWrite(ctx -> ctx.put("user", ctx.get("user").toString().toUpperCase()))
           .contextWrite(Context.of("users","jake"))
           .contextWrite(Context.of("user","jake"))
            .contextWrite(Context.of("user","sam"))

           .subscribe(Util.subscriber());

    }


    private static Mono<String> getWelomeMessage(){
        //return Mono.just("Welcome");
        //use just or fromSupplier equals
        return Mono.fromSupplier(() -> "Welcome by default ");
    }

    private static Mono<String> getWelomeMessageDeferContext(){
        return Mono.deferContextual(contextView -> {
            if (contextView.hasKey("user")) {
                return Mono.just("Welcome : " + contextView.get("user"));
            }
            else {
                return Mono.error(new RuntimeException("authenticated"));
            }
        });
    }
}
