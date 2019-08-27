/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author nguye
 */
public class Film {
    private int id;
    private String name;
    private String description;
    private String cast;
    private String genre;
    private Date seleaseDate;
    private Time runningTime;

    public Film() {
    }

    public Film(int id, String name, String description, String cast, String genre, Date seleaseDate, Time runningTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cast = cast;
        this.genre = genre;
        this.seleaseDate = seleaseDate;
        this.runningTime = runningTime;
    }

   

    
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCast() {
        return cast;
    }

    public String getGenre() {
        return genre;
    }

    public Date getSeleaseDate() {
        return seleaseDate;
    }

    public Time getRunningTime() {
        return runningTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSeleaseDate(Date seleaseDate) {
        this.seleaseDate = seleaseDate;
    }

    public void setRunningTime(Time runningTime) {
        this.runningTime = runningTime;
    }
    
}
