package org.course.reactive.task.lesson1;

import org.course.reactive.task.lesson1.assignment.FileService;
import org.course.reactive.util.Util;

public class AssigmentDemo {
    public static void main(String[] args) {

        FileService.read("file03.txt")
                .subscribe(Util.onNext(), Util.onError(),
                        Util.onComplete());

       /* FileService.write("file03.txt", "This is file3")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());*/

        FileService.delete("file03.txt").subscribe(Util.onNext(),
                Util.onError(), Util.onComplete());

    }
}
