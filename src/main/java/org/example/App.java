package org.example;


import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);
//                .addAnnotatedClass(Director.class)
//                .addAnnotatedClass(School.class);
//                .addAnnotatedClass(author.class)
//                .addAnnotatedClass(film.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try (sessionFactory) {

            session.beginTransaction();

//            author author = session.get(author.class,1);
//            System.out.println(author);

//            film film = session.get(film.class,3);
//
//            System.out.println(film.getAuthor_id());

//            author author = session.get(author.class,1);
//            film film = new film("tom7",author);
//
//            author.getFilmList().add(film);
//
//            session.save(film);
//
//            System.out.println(author);

//            author author = new author("tom7");
//
//            film film = new film("tom8",author);
//
//            author.setFilmList(new ArrayList<>(Collections.singletonList(film)));
//
//            session.save(author);
//
//            session.save(film);
//
//            System.out.println(author);
//            author author = session.get(author.class, 2);
//            session.remove(author);

//            Director director = session.get(Director.class, 4);
//
//            System.out.println(director.getId() + "|" + director.getName()  + "|" + director.getAge()  + "|" + director.getSchool());

//            School school = session.get(School.class,4);
//
//            System.out.println(school.getId() + "|" + school.getSchool_number() + "|" + school.getDirector());
        Actor actor1 = new Actor("Kennedy", 30);
            Movie movie1 = new Movie("Who killed Kennedy", 2010);
        Actor actor2 = new Actor("Jessy", 25);
            Movie movie2 = new Movie("Nobody is like Jessy", 2000);

        actor1.setMovieList(new ArrayList<>(Collections.singletonList(movie1)));
        movie1.setActorList(new ArrayList<>(Collections.singletonList(actor1)));
        actor2.setMovieList(new ArrayList<>(Collections.singletonList(movie2)));
        movie2.setActorList(new ArrayList<>(Collections.singletonList(actor2)));


        Actor actor3 = new Actor("Marine", 20);

        Actor actor4 = new Actor("Monro", 21);

        Movie movie3 = new Movie("Marine-Monro", 2005);

        Movie movie4 = new Movie("Marine-Monro", 2001);


        actor3.setMovieList(new ArrayList<>(List.of(movie3,movie4)));
        movie3.setActorList(new ArrayList<>(List.of(actor3,actor4)));
        actor4.setMovieList(new ArrayList<>(List.of(movie3,movie4)));
        movie4.setActorList(new ArrayList<>(List.of(actor3,actor4)));

        session.save(actor1);
        session.save(actor2);
        session.save(actor3);
        session.save(actor4);
        session.save(movie1);
        session.save(movie2);
        session.save(movie3);
        session.save(movie4);


            session.getTransaction().commit();
        }
    }
}
