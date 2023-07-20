package com.stackroot.ust;

import com.stackroot.ust.domain.Actor;
import com.stackroot.ust.domain.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//        Actor actor = context.getBean("actor",Actor.class);
//        System.out.println(actor);

        Movie movie1 = context.getBean("Movie", Movie.class);

        Movie movie2 = context.getBean("Movie", Movie.class);

        System.out.println(movie1 == movie2);

        Movie bean1 = context.getBean("movieA", Movie.class);
        Movie bean2 = context.getBean("movieB", Movie.class);

        System.out.println(bean1 == bean2);

    }
}