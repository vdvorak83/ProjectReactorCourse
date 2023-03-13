package org.course.reactive.task.lessons11.assignment;

import org.course.reactive.util.Util;

public class SlackDemo {

    public static void main(String[] args) {


        SlackRoom slackRoom =new SlackRoom("reactor");


        SlackMember sam = new SlackMember("sam");
        SlackMember jake = new SlackMember("jake");
        SlackMember mike = new SlackMember("mike");


        slackRoom.joinRoom(sam);
        slackRoom.joinRoom(jake);


        sam.says("Hi all ...");
        Util.sllepSeconds(4);

        jake.says("Hey!");
        sam.says("I simply wanted to say hi..");
        Util.sllepSeconds(4);

        slackRoom.joinRoom(mike);
        mike.says("Hey guys ... glad to be here...");


    }
}
