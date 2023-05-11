package collection.baseClasses;

import collection.baseClasses.Coordinates;
import collection.baseClasses.MusicGenre;
import collection.baseClasses.Person;

import java.time.LocalDateTime;

public class MusicBand {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long numberOfParticipants; //Поле может быть null, Значение поля должно быть больше 0
    private MusicGenre genre; //Поле может быть null
    private Person frontMan; //Поле не может быть null

    /**
     * as soon as an object is created, the creation time is remembered
     */
    public MusicBand(){
        creationDate = LocalDateTime.now();
        coordinates = new Coordinates();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates.setX(coordinates.getX());
        this.coordinates.setY(coordinates.getY());
    }

    public Long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(Long numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public Person getFrontMan() {
        return frontMan;
    }

    public void setFrontMan(Person frontMan) {
        this.frontMan = frontMan;
    }
}