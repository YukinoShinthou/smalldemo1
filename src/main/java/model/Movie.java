package model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "movie_name")
    private String movie_name;

    @Column(name = "movie_date")
    private int movie_date;

    @ManyToMany(mappedBy = "movieList")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    List<Actor> actorList;

    public Movie() {
    }

    public Movie(String movie_name, int movie_date) {
        this.movie_name = movie_name;
        this.movie_date = movie_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getMovie_date() {
        return movie_date;
    }

    public void setMovie_date(int movie_date) {
        this.movie_date = movie_date;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movie_name='" + movie_name + '\'' +
                ", movie_date=" + movie_date +
                '}';
    }
}
