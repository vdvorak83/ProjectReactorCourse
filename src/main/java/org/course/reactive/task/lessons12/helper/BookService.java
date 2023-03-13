package org.course.reactive.task.lessons12.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.course.reactive.util.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class BookService {

    private static
    //final
    Map<String,Integer> MAP = new HashMap<>();

    static {
        MAP.put("std",2);
        MAP.put("prime",3);
    }

    public static Mono<String> getBook(){
        return Mono.deferContextual(contextView -> {
            if (contextView.get("allow")){
              return Mono.just(Util.faker().book().title());
            }else {
                return Mono.error(new RuntimeException("not-allowed"));
            }
        })
                .contextWrite(rateLimiterContext());
    }

    private static Function<Context, Context> rateLimiterContext(){
        return context -> {
            if (context.hasKey("category")){
                String category = context.get("category").toString();
                Integer attempts = MAP.get(category);
                if (attempts > 0){
                    MAP.put(category, attempts -1 );
                    return context.put("allow",true);
                }
            }
            return context.put("allow", false);
        };
    }
}
