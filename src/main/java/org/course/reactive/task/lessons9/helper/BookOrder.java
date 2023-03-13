package org.course.reactive.task.lessons9.helper;

import com.github.javafaker.Book;
import lombok.Getter;
import lombok.ToString;
import org.course.reactive.util.Util;

@Getter
@ToString
public class BookOrder {

    private String titile;
    private String author;
    private String category;
    private Double price;

    public BookOrder() {
        Book book = Util.faker().book();
        this.titile = book.title();
        this.author = book.author();
        this.category = book.genre();
        this.price = Double.parseDouble(Util.faker().commerce().price());
    }
}
