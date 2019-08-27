/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Room;
import Model.Film;
import java.sql.Time;
import java.sql.Date;
/**
 *
 * @author nguye
 */
public class Schedule {
    private int id;
    private Time time;
    private Date date;
    private double price;
    private Room room;
    private Film film;

    public Schedule() {
    }

    public Schedule(int id, Time time, Date date, double price, Room room, Film film) {
        this.id = id;
        this.time = time;
        this.date = date;
        this.price = price;
        this.room = room;
        this.film = film;
    }

    public int getId() {
        return id;
    }

    public Time getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public Room getRoom() {
        return room;
    }

    public Film getFilm() {
        return film;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    
    
}
