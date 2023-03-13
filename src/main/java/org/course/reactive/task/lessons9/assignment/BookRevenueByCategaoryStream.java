package org.course.reactive.task.lessons9.assignment;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.course.reactive.task.lessons9.helper.BookOrder;
import org.course.reactive.task.lessons9.helper.RevenueReport;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class BookRevenueByCategaoryStream {



    public static void main(String[] args) {


        Set<String> allowedCategories = Set.of(
                "Science fiction",
                "Fantasy",
                "Susspense/Thriller");

        booksStream()
                .filter(book -> allowedCategories.contains(book.getCategory()))
                .buffer(Duration.ofSeconds(5))
                .map(list -> revenueCalculatator(list))
                .subscribe(Util.subscriber());

        Util.sllepSeconds(10);

    }


    private static RevenueReport revenueCalculatator(List<BookOrder> books){
       Map<String,Double> map =  books.stream().collect(Collectors.groupingBy(
                BookOrder::getCategory,
                Collectors.summingDouble(BookOrder::getPrice)
        ));

       return new RevenueReport(map);
    }


    private static Flux<BookOrder> booksStream(){
       return Flux.interval(Duration.ofMillis(200))
                .map( i -> new BookOrder());
    }
}
