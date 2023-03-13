package org.course.reactive.task.lessons12.helper;

import java.util.Map;
import java.util.function.Function;
import reactor.util.context.Context;

public class UserService {




    private static final Map<String,String> MAP = Map.of(
            "sam","std",
            "mike","prime"
            );

    public static Function<Context,Context> userCategoryContext(){
        return context -> {
            String user =context.get("user").toString();
            String category = MAP.get(user);
            return context.put("category", category);
        };
    }
}
