package com.example.unittestdemo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ticket_id")
    private Integer ticketId;

    @Column(name="passenger_name",nullable=false)
    private String passengerName;

    @Column(name="booking_date",nullable=false)
    private Date bookingDate;

    @Column(name="source_station",nullable=false)
    private String sourceStation;

    @Column(name="dest_station",nullable=false)
    private String destStation;

    @Column(name="email",unique=true)
    private String email;

}
