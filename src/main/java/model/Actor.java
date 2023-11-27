package model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "Actor")
public class Actor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "actor_name")
    private String actor_name;

    @Column(name = "actor_age")
    private int actor_age;

    @ManyToMany
            @JoinTable(name = "Actor_Movie",
            joinColumns = @JoinColumn(name = "Actor_id"),
            inverseJoinColumns = @JoinColumn(name = "Movie_id"))
            @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    List<Movie> movieList;

    public Actor() {
    }

    public Actor(String actor_name, int actor_age) {
        this.actor_name = actor_name;
        this.actor_age = actor_age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActor_name() {
        return actor_name;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public int getActor_age() {
        return actor_age;
    }

    public void setActor_age(int actor_age) {
        this.actor_age = actor_age;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", actor_name='" + actor_name + '\'' +
                ", actor_age=" + actor_age +
                ", movieList=" + movieList +
                '}';
    }
}
