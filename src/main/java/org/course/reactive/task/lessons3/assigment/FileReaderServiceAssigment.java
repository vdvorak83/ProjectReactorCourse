package org.course.reactive.task.lessons3.assigment;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.course.reactive.util.Util;
import reactor.core.publisher.Flux;

public class FileReaderServiceAssigment {
    public static void main(String[] args) {


        FileReadService fileReadService = new FileReadService();

        Path path  = Paths.get("src/main/resources/assignment/lessons3/file01.txt");
        fileReadService.read(path)
                .map(s -> {
                    Integer integer = Util.faker().random().nextInt(0, 10);
                    if(integer > 8)
                        throw new RuntimeException("oops");
                    return s;
                })
                .take(20)
                .subscribe(Util.subscriber());
    }
}
