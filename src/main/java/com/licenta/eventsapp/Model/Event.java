package com.licenta.eventsapp.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
@Table(name="event")
public class Event {
    @Getter @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Getter @Setter @Column(name = "name")
    private String name;
    @Getter @Setter @Column(name = "date") //auto mapping to Temporal TIMESTAMP
    private LocalDateTime date;
    @Getter @Setter @Column(name = "address")
    private String address;
    @Getter @Setter @Column(name = "city")
    private String city;
    @Getter @Setter @Column(name = "country")
    private String country;
    @Getter @Setter @Column(name = "latitude")
    private String latitude;
    @Getter @Setter @Column(name = "longitude")
    private String longitude;
    @Getter @Setter @Column(name = "description")
    private String description;

    public Event() {}

    public Event(String name, LocalDateTime date, String address, String city, String country, String latitude, String longitude, String description) {
        super();
        this.name = name;
        this.date = date;
        this.address = address;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date.format(DateTimeFormatter.ofPattern("d MMMM y hh:mm")) +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
