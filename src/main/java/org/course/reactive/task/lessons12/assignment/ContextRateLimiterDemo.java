package org.course.reactive.task.lessons12.assignment;

import org.course.reactive.task.lessons12.helper.BookService;
import org.course.reactive.task.lessons12.helper.UserService;
import org.course.reactive.util.Util;
import reactor.util.context.Context;

public class ContextRateLimiterDemo {

    public static void main(String[] args) {
        BookService.getBook()
                .repeat(3)//reapt 3 times
                .contextWrite(UserService.userCategoryContext()) //up stream subs
              // .contextWrite(Context.of("user","sam")) //down stream pub
               .contextWrite(Context.of("user","mike")) //down stream pub
                .subscribe(Util.subscriber());
    }
}
