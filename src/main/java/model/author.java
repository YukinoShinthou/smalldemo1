package model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "author")
public class author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "author_id")
    List<film> filmList;

    public author() {
    }

    public author(String name) {
        this.name = name;
    }

    public author(String name, List<film> filmList) {
        this.name = name;
        this.filmList = filmList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<film> filmList) {
        this.filmList = filmList;
    }

    @Override
    public String toString() {
        return "author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", filmList=" + filmList +
                '}';
    }


}
