package org.course.reactive.task.lessons8;

import org.course.reactive.task.lessons8.helper.NameGanerator;
import org.course.reactive.util.Util;

public class StartWithDemo2pub {




    public static void main(String[] args) {


        NameGanerator nameGanerator = new NameGanerator();
        nameGanerator.genereteNames()
                .take(2)
                .subscribe(Util.subscriber("mike"));
        nameGanerator.genereteNames()
                .take(2)
                .subscribe(Util.subscriber("sam"));
        nameGanerator.genereteNames()
                .take(3)
                .subscribe(Util.subscriber("jake"));
        nameGanerator.genereteNames()
                .filter(n->n.startsWith("A"))
                .take(4)
                .subscribe(Util.subscriber("Marshal"));

        /*nameGanerator.genereteNames()
                .filter(n->n.startsWith("A"))
                .take(2)
                .subscribe(Util.subscriber("Marshal"));*/




    }
}
