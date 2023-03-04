package org.course.reactive.task.lesson1;

import java.util.concurrent.CompletableFuture;
import org.course.reactive.util.Util;
import reactor.core.publisher.Mono;

public class MonoFromFuture {
    public static void main(String[] args) {


        Mono.fromFuture(getName())
                .subscribe(Util.onNext());


        Util.sllepSeconds(1);

    }


    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}
