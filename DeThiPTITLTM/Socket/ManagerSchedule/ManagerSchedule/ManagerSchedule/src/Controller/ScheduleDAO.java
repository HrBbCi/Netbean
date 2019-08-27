/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Schedule;
import Model.Room;
import Model.Film;
import Model.Cinema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class ScheduleDAO {
    private Connection dcCon;

    public ScheduleDAO() {
        String dbUrl = "jdbc:mysql://localhost:3306/cnpm";
        String dbClass = "com.mysql.jdbc.Driver";
        try
        {
            Class.forName(dbClass);
            dcCon = DriverManager.getConnection(dbUrl, "root", "coi123457");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public Schedule[] SearchScheduleByFilmName(String name)
    {
        Schedule[] listSchedule1 = null;
        String sql_schedule = "SELECT * FROM tblschedule WHERE tblFilm_ID IN (SELECT ID FROM tblfilm WHERE name = ?)";
        PreparedStatement ps_schedule;
        int dem = 0;
        try {
            ps_schedule = dcCon.prepareStatement(sql_schedule);
            ps_schedule.setString(1, name);
            ResultSet rs_schedule = ps_schedule.executeQuery();
            if(rs_schedule.last())
            {
                listSchedule1 = new Schedule[rs_schedule.getRow()];
                rs_schedule.beforeFirst();
            }
            Room room = null;
            Film film = null;
            while(rs_schedule.next())
            {
                //get room
                int room_id = rs_schedule.getInt("tblRoom_ID");
                String sql_room = "SELECT * FROM tblroom WHERE ID = ?";
                PreparedStatement ps_room;
                ps_room = dcCon.prepareStatement(sql_room);
                ps_room.setInt(1, room_id);
                ResultSet rs_room = ps_room.executeQuery();
                Cinema cinema = null;
                while(rs_room.next())
                {
                    String sql_cinema = "SELECT * FROM tblcinema WHERE ID = ?";
                    PreparedStatement ps_cinema;
                    ps_cinema = dcCon.prepareStatement(sql_cinema);
                    ps_cinema.setInt(1, rs_room.getInt("tblCinema_ID"));
                    ResultSet rs_cinema = ps_cinema.executeQuery();
                    while(rs_cinema.next())
                    {
                        cinema = new Cinema(rs_cinema.getInt("ID"), rs_cinema.getString("name"), rs_cinema.getString("address"));
                    }
                    room = new Room(rs_room.getInt("ID"), rs_room.getString("name"), rs_room.getString("type"), cinema);
                }            
                //get film        
                String sql_film = "SELECT * FROM tblfilm WHERE ID = ?";
                PreparedStatement ps_film;
                ps_film = dcCon.prepareStatement(sql_film);
                ps_film.setInt(1, rs_schedule.getInt("tblFilm_ID"));
                ResultSet rs_film = ps_film.executeQuery();
                while(rs_film.next())
                {
                    film = new Film(rs_film.getInt("ID"), rs_film.getString("name"), rs_film.getString("description"), rs_film.getString("cast"), rs_film.getString("genre"), rs_film.getDate("releaseDate"), rs_film.getTime("runningTime"));
                }
                listSchedule1[dem++] = new Schedule(rs_schedule.getInt("ID"), rs_schedule.getTime("time"), rs_schedule.getDate("date"), rs_schedule.getDouble("price"), room, film);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSchedule1;
    }
    
    public Room[] GetAllRoom()
    {
        Room[] listRoom = null;
        String sql_room = "SELECT * FROM tblroom";
        PreparedStatement ps_room;
        int dem = 0;
        try {
            ps_room = dcCon.prepareStatement(sql_room);
            ResultSet rs_room = ps_room.executeQuery();
            if(rs_room.last())
            {
                listRoom = new Room[rs_room.getRow()];
                rs_room.beforeFirst();
            }
            Cinema cinema = null;
            while(rs_room.next())
            {
                String sql_cinema = "SELECT * FROM tblcinema WHERE ID = ?";
                PreparedStatement ps_cinema;
                ps_cinema = dcCon.prepareStatement(sql_cinema);
                ps_cinema.setInt(1, rs_room.getInt("tblCinema_ID"));
                ResultSet rs_cinema = ps_cinema.executeQuery();
                while(rs_cinema.next())
                {
                    cinema = new Cinema(rs_cinema.getInt("ID"), rs_cinema.getString("name"), rs_cinema.getString("address"));
                }
                listRoom[dem++] = new Room(rs_room.getInt("ID"), rs_room.getString("name"), rs_room.getString("type"), cinema);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  listRoom;
    }

    public boolean UpdateSchedule(Schedule Schedule)
    {
        
        String sql_up = "UPDATE tblschedule SET time=?,date=?,price=?,tblRoom_ID=?,tblFilm_ID=? WHERE ID=?";
        String sql_check = "SELECT * FROM tblschedule WHERE date=? AND tblRoom_ID=? AND ID!=?";
        String sql_film = "SELECT * FROM tblfilm WHERE ID = ?";
        
        Calendar calen = Calendar.getInstance();
        calen.setTime(Schedule.getTime());
        int Hour = calen.get(Calendar.HOUR_OF_DAY);
        int Minute = calen.get(Calendar.MINUTE);
        int Hour_f = 0, Minute_f = 0, Hour_after = 0, Minute_after = 0;
        int check_result = 0;
        PreparedStatement ps_film;
        try {
            ps_film = dcCon.prepareStatement(sql_film);
            ps_film.setInt(1, Schedule.getFilm().getId());
            ResultSet rs_film = ps_film.executeQuery();
            Time time_after = null;
            while(rs_film.next())
            {
                calen.setTime(rs_film.getTime("runningTime"));
                Hour_f = calen.get(Calendar.HOUR_OF_DAY);
                Minute_f = calen.get(Calendar.MINUTE);
                
                if(Hour + Hour_f >= 24)
                {
                    Hour_after = (Hour + Hour_f) % 24;
                }
                else
                {
                    Hour_after = Hour + Hour_f;
                }
                if(Minute + Minute_f >= 60)
                {
                    Minute_after = Minute + Minute_f - 60;
                    Hour_after += 1;
                    if(Hour_after >= 24)
                    {
                        Hour_after -= 24;
                    }
                }
                else
                {
                    Minute_after = Minute + Minute_f;
                }
                
                Minute_after += 15;
                if(Minute_after >= 60)
                {
                    Minute_after = Minute_after - 60;
                    Hour_after += 1;
                    if(Hour_after >= 24)
                    {
                        Hour_after -= 24;
                    }
                }
                
                time_after = new Time(Hour_after, Minute_after, 0); 
                //System.out.println(time_after.toString());
            }
            PreparedStatement ps_check;
            ps_check = dcCon.prepareStatement(sql_check);
            ps_check.setDate(1, Schedule.getDate());
            ps_check.setInt(2, Schedule.getRoom().getId());
            ps_check.setInt(3, Schedule.getId());
            ResultSet rs_check = ps_check.executeQuery();
            
            while(rs_check.next())
            {     
                //System.out.println(rs_check.getTime("time"));
                //System.out.println(Hour + " " + Minute + " : " + Hour_after + " " + Minute_after);
                Calendar check_calen = Calendar.getInstance();
                check_calen.setTime(rs_check.getTime("time"));
                int Hour_c = check_calen.get(Calendar.HOUR_OF_DAY);
                int Minute_c = check_calen.get(Calendar.MINUTE);
                //System.out.println(Hour_c + " " + Minute_c);
                if(Hour < Hour_after)
                {
                    //System.out.println("TH1");
                    if(Hour_c < Hour_after && Hour_c > Hour)
                    {
                        check_result = 1;
                        break;
                    }
                    //System.out.println(check_result);
                    if(Hour_c == Hour_after)
                    {
                        if(Minute_c <= Minute_after)
                        {
                            check_result = 1;
                            break;
                        }
                    }
                    if(Hour_c == Hour)
                    {
                        if(Minute_c >= Minute)
                        {
                            check_result = 1;
                            break;
                        }
                    }
                    //System.out.println(check_result);
                    if(Hour_c < Hour || Hour_c > Hour_after || Hour_c == Hour && Minute_c < Minute)
                    {
                        String sql_checkfilm = "SELECT * FROM tblfilm WHERE ID=?";
                        PreparedStatement ps_checkfilm;
                        ps_checkfilm = dcCon.prepareStatement(sql_checkfilm);
                        ps_checkfilm.setInt(1, rs_check.getInt("tblFilm_ID"));
                        ResultSet rs_checkfilm = ps_checkfilm.executeQuery();
                        int Hour_cf =0, Minute_cf=0;
                        while(rs_checkfilm.next())
                        {
                            check_calen.setTime(rs_checkfilm.getTime("runningTime"));
                            Hour_cf = check_calen.get(Calendar.HOUR_OF_DAY);
                            Minute_cf = check_calen.get(Calendar.MINUTE);
                        }
                        //System.out.println(Hour_cf + " " + Minute_cf);
                        int Hour_last=0, Minute_last=0;
                        if(Hour_c + Hour_cf >= 24)
                        {
                            //Hour_after = (Hour + Hour_f) % 24;
                            Hour_last = (Hour_c + Hour_cf) % 24;
                        }
                        else
                        {
                            Hour_last = Hour_c + Hour_cf;
                        }
                        if(Minute_c + Minute_cf >= 60)
                        {
                            Minute_last = Minute_c + Minute_cf - 60;
                            Hour_last += 1;
                            if(Hour_last >= 24)
                            {
                                Hour_after -= 24;
                                //check_result = 1;
                            }
                        }
                        else
                        {
                            Minute_last = Minute_c + Minute_cf;
                        }

                        Minute_last += 15;
                        if(Minute_last >= 60)
                        {
                            Minute_last = Minute_last - 60;
                            Hour_last += 1;
                            if(Hour_last >= 24)
                            {
                                Hour_after -= 24;
                            }
                        }
                        //System.out.println(Hour_last + " " + Minute_last);
                        if(Hour_last >= Hour && Hour_last < Hour_after)
                        {
                            check_result = 1;
                        }
                        if(Hour_last == Hour_after)
                        {
                            if(Minute_last <= Minute_after)
                            {
                                check_result = 1;
                            }
                        }
                    }
                }
                //System.out.println(check_result);
                if(Hour > Hour_after)
                {
                    
                    if(Hour_c < Hour_after || Hour_c > Hour)
                    {
                        check_result = 1;
                        break;
                    }
                    
                    if(Hour_c == Hour)
                    {
                        if(Minute_c >= Minute)
                        {
                            check_result = 1;
                            break;
                        }
                    }
                    if(Hour_c == Hour_after)
                    {
                        if(Minute_c <= Minute_after)
                        {
                            check_result = 1;
                            break;
                        }
                    }
                    if(Hour_c > Hour || Hour_c < Hour_after || Hour_c == Hour && Minute_c < Minute)
                    {
                        String sql_checkfilm = "SELECT * FROM tblfilm WHERE ID=?";
                        PreparedStatement ps_checkfilm;
                        ps_checkfilm = dcCon.prepareStatement(sql_checkfilm);
                        ps_checkfilm.setInt(1, rs_check.getInt("tblFilm_ID"));
                        ResultSet rs_checkfilm = ps_checkfilm.executeQuery();
                        int Hour_cf =0, Minute_cf=0;
                        while(rs_checkfilm.next())
                        {
                            check_calen.setTime(rs_checkfilm.getTime("runningTime"));
                            Hour_cf = check_calen.get(Calendar.HOUR_OF_DAY);
                            Minute_cf = check_calen.get(Calendar.MINUTE);
                        }

                        int Hour_last=0, Minute_last=0;
                        if(Hour_c + Hour_cf >= 24)
                        {
                            //Hour_after = (Hour + Hour_f) % 24;
                            Hour_last = (Hour_c + Hour_cf) % 24;
                        }
                        else
                        {
                            Hour_last = Hour_c + Hour_cf;
                        }
                        if(Minute_c + Minute_cf >= 60)
                        {
                            Minute_last = Minute_c + Minute_cf - 60;
                            Hour_last += 1;
                            if(Hour_last >= 24)
                            {
                                Hour_after -= 24;
                                //check_result = 1;
                            }
                        }
                        else
                        {
                            Minute_last = Minute_c + Minute_cf;
                        }

                        Minute_last += 15;
                        if(Minute_last >= 60)
                        {
                            Minute_last = Minute_last - 60;
                            Hour_last += 1;
                            if(Hour_last >= 24)
                            {
                                Hour_after -= 24;
                            }
                        }
                        if(Hour_last >= Hour_after && Hour_last < Hour)
                        {
                            check_result = 1;
                        }
                        if(Hour_last == Hour)
                        {
                            if(Minute_last <= Minute)
                            {
                                check_result = 1;
                            }
                        }
                    }
                }
            
            }
            //System.out.println(check_result);
            if(check_result == 1)
            {
                return  false;
            }
            else
            {
                PreparedStatement ps_up;
                ps_up = dcCon.prepareStatement(sql_up);
                ps_up.setTime(1, Schedule.getTime());
                ps_up.setDate(2, Schedule.getDate());
                ps_up.setDouble(3, Schedule.getPrice());
                ps_up.setInt(4, Schedule.getRoom().getId());
                ps_up.setInt(5, Schedule.getFilm().getId());
                ps_up.setInt(6, Schedule.getId());
                ps_up.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
