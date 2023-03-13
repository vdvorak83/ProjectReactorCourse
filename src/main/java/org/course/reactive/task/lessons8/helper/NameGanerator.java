package org.course.reactive.task.lessons8.helper;

import java.util.ArrayList;
import java.util.List;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class NameGanerator {
    private List<String> list = new ArrayList<>();
    public Flux<String> genereteNames(){
        return Flux.generate(stringSynchronousSink -> {
            System.out.println("Generated fresh");
            Util.sllepSeconds(1);
            String name = Util.faker().name().firstName();
            list.add(name);
            stringSynchronousSink.next(name);
        })
                .cast(String.class)
                .startWith(getFromCache());
    }

    private Flux<String>  getFromCache() {
        return Flux.fromIterable(list);
    }
}
