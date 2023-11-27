package model;

import jakarta.persistence.*;

@Entity
@Table(name = "School")
public class School {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "school_number")
    private String school_number;

    @OneToOne
    @JoinColumn(name = "director_id",referencedColumnName = "id")
    private Director director;

    public School() {
    }

    public School(String school_number, Director director) {
        this.school_number = school_number;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool_number() {
        return school_number;
    }

    public void setSchool_number(String school_number) {
        this.school_number = school_number;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                " school_number='" + school_number + '\'' +
                '}';
    }
}
