package model;

import jakarta.persistence.*;

@Entity
@Table(name = "film")
public class film {
    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "film_name")
    private String film_name;
    @ManyToOne
    @JoinColumn(name = "author_id" , referencedColumnName = "id")
    private author author_id;

    public film() {
    }

    public film(String film_name, author author_id) {
        this.film_name = film_name;
        this.author_id = author_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public author getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(author author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "film{" +
                "id=" + id +
                ", film_name='" + film_name + '\'' +
                '}';
    }
}
