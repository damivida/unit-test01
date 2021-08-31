package com.example.unittestdemo.dao;

import com.example.unittestdemo.entities.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {
    Ticket findByEmail(String email);

    Ticket findOne(Integer ticketId);


}
