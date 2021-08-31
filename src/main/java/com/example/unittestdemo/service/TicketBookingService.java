package com.example.unittestdemo.service;

import com.example.unittestdemo.dao.TicketBookingDao;
import com.example.unittestdemo.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingService {

    @Autowired
    private TicketBookingDao ticketBookingDao;

    public Ticket createTicket(Ticket ticket) {
        return ticketBookingDao.save(ticket);
    }
    public Ticket getTicketById(Integer ticketId) {
        return ticketBookingDao.findOne(ticketId);
    }
    public Iterable<Ticket> getAllBookedTickets() {
        return ticketBookingDao.findAll();
    }
   /* public Ticket deletedTicket(Integer ticketId) {
       Ticket ticketToDelete =  ticketBookingDao.findOne(ticketId);
       Ticket deletedTicket = ticketBookingDao.delete(ticketToDelete);
       return deletedTicket;

    }*/
    public Ticket updateTicket(Integer ticketId, String newEmail) {
        Ticket ticketFromDb = ticketBookingDao.findOne(ticketId);
        ticketFromDb.setEmail(newEmail);
        Ticket updatedTicket = ticketBookingDao.save(ticketFromDb);
        return updatedTicket;
    }
    public Ticket getTicketByEmail(String email) {
        return ticketBookingDao.findByEmail(email);
    }

}
