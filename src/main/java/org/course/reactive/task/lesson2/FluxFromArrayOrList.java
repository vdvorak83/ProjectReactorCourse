package org.course.reactive.task.lesson2;

import java.util.Arrays;
import java.util.List;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class FluxFromArrayOrList {
    public static void main(String[] args) {

        //1
       //List<String> arraysString = Arrays.asList("a","b","c");
       /* Flux.fromIterable(arraysString)
                .subscribe(Util.onNext());*/

        //2
        Integer[] arr = {2,5,7,8};

       Flux.fromArray(arr)
               .subscribe(Util.onNext());



    }
}
