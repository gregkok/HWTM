package com.example.HWTM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventRepository {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserRepository userRepository;

    public EventRepository() {

    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM EVENTS")) {
            while (rs.next()) {
                events.add(rsEvent(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public List<Event> getEventsByUserId(long users_id) {    //Gets all events hosted by user
        List<Event> events = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Events" +
                             " WHERE users_id =" + users_id)) {
            while (rs.next()) {
                events.add(rsEvent(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public List<Event> getEventsAsGuestByUserId(long users_id){  //Gets all events attended by user

        List<Event> eventList = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT * FROM ATTENDEES INNER JOIN EVENTS ON events.id = attendees.event_id WHERE attendees.users_id="+ users_id);

            while(rs.next()){
                eventList.add(rsEvent(rs));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return eventList;
    }

    public void saveEvent(Event event){

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO events (USERS_ID, EVENT_HOST, EVENT_TYPE, EVENT_TIME, EVENT_DATE, EVENT_ADDRESS, DESCRIPTION, NR_OF_GUESTS, PRICE, URL) VALUES(?,?,?,?,?,?,?,?,?,?)")){

            ps.setLong(1, event.getUser_id());
            ps.setString(2,event.getHost_name());
            ps.setString(3, event.getType());
            ps.setString(4, event.getEvent_time());
            ps.setString(5, event.getEvent_date());
            ps.setString(6, event.getEvent_address());
            ps.setString(7, event.getDescription());
            ps.setInt(8, event.getNumOfGuests());
            ps.setInt(9, event.getPrice());
            ps.setString(10, event.getUrl());

            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<User> getAttendeesByEventId(Long event_id){
        List<User> attendees = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();){

              ResultSet rs = stmt.executeQuery("SELECT *\n" +
                      "        FROM users\n" +
                      "        INNER JOIN attendees\n" +
                      "        ON users.id = attendees.users_id\n" +
                      "        WHERE event_id = " + event_id);


              while(rs.next()){
                  attendees.add(userRepository.rsUser(rs));

              }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return attendees;
    }

    public void saveAttendeeToEvent(Long event_id, Long user_id){

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO attendees (EVENT_ID, USERS_ID) VALUES(?,?)")){

            ps.setLong(1, event_id);
            ps.setLong(2, user_id);

            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Event getEventDetails(long id){

        List<Event> allEvents = getAllEvents();

        for(Event e : allEvents){
            if(e.getEvent_id() == id){
                return e;
            }
        }
        return null;
    }

    private Event rsEvent(ResultSet rs) throws SQLException {
        return new Event(rs.getLong("id"),
                rs.getLong("users_id"),
                rs.getString("event_host"),
                rs.getString("event_type"),
                rs.getString("event_time"),
                rs.getString("event_date"),
                rs.getString("event_address"),
                rs.getString("description"),
                rs.getInt("nr_of_guests"),
                rs.getInt("price"),
                rs.getString("url"));
    }



}



