/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Cinema;

/**
 *
 * @author nguye
 */
public class Room {
    private int id;
    private String name;
    private String type;
    private Cinema cinema;

    public Room() {
    }

    public Room(int id, String name, String type, Cinema cinema) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cinema = cinema;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    
    
    
}
