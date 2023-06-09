package org.course.reactive.task.lesson1.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import reactor.core.publisher.Mono;

public class FileService {

    private static  final Path PATH = Paths.get("src/main/resources/assignment/lessons1");

    public static Mono<String>  read (String fileame){
        return Mono.fromSupplier(()-> readFile(fileame));
    }
    public static Mono<Void> write (String fileame,String content){
        return Mono.fromRunnable(()-> writeFile(fileame,content));
    }

    public static Mono<Void> delete (String fileame){
        return Mono.fromRunnable(()-> deleteFile(fileame));
    }
    private static String readFile(String fileName){
        try {
            return Files.readString(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(String fileName, String content){
        try {
             Files.writeString(PATH.resolve(fileName),content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void deleteFile(String fileName){
        try {
            Files.delete(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
