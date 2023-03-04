package org.course.reactive.task.lesson2;

import java.util.List;
import java.util.stream.Stream;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class FluxFromStream {
    public static void main(String[] args) {


        List<Integer> list =  List.of(1,2,3,4);
        Stream<Integer> stream = list.stream();


        //stream.forEach(System.out::println);
        //stream.forEach(System.out::println);

        //Flux<Integer> integerFlux = Flux.fromStream(stream);
        Flux<Integer> integerFlux = Flux.fromStream(()-> list.stream());

        integerFlux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
        integerFlux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}