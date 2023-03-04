package org.course.reactive.task.lesson2.helper;

import java.util.ArrayList;
import java.util.List;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class NameGenerator {


    //wait for 5 seonds and print
    public static List<String> getNames(int count){
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(getName());
        }
        return list;
    }

   //don't wait second sleep
    public static Flux<String> getNamesFlux(int counnt)
    {
    return     Flux.range(0, counnt)
                .map(i->getName());
    }

    private static String getName(){
        Util.sllepSeconds(1);
        return Util.faker().name().fullName();
    }
}

