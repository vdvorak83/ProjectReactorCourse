package org.course.reactive.task.lessons9.helper;

import com.github.javafaker.Book;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.Getter;
import lombok.ToString;
import org.course.reactive.util.Util;

@Getter
@ToString
public class RevenueReport {

    private LocalDateTime localDateTime = LocalDateTime.now();
    private Map<String,Double> revenue;

    public RevenueReport(Map<String,Double> revenue) {
        this.revenue = revenue;

    }
}
