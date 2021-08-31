package com.example.unittestdemo.service;

import com.example.unittestdemo.dao.TicketBookingDao;
import com.example.unittestdemo.entities.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
class TicketBookingServiceTest {

    @Autowired
    private TicketBookingService ticketBookingService;

    @MockBean
    private TicketBookingDao ticketBookingDao;

    @Test
    void createTicket() {

        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setPassengerName("Vidix Offnzix");
        ticket.setSourceStation("Osijek");
        ticket.setDestStation("Prague");
        ticket.setBookingDate(new Date());
        ticket.setEmail("dami.vida@gmail.com");

        Mockito.when(ticketBookingDao.save(ticket)).thenReturn(ticket);
        assertThat(ticketBookingService.createTicket(ticket)).isEqualTo(ticket);

    }

    @Test
    void getTicketById() {

        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setPassengerName("VidixOffnzix");
        ticket.setSourceStation("Osijek");
        ticket.setDestStation("Prague");
        ticket.setBookingDate(new Date());
        ticket.setEmail("dami.vida@gmail.com");


        Mockito.when(ticketBookingDao.findOne(ticket.getTicketId())).thenReturn(ticket);
        assertThat(ticketBookingService.getTicketById(1)).isEqualTo(ticket);
    }

/*    @Test
    void deleteTicket() {
        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setPassengerName("VidixOffnzix");
        ticket.setSourceStation("Osijek");
        ticket.setDestStation("Prague");
        ticket.setBookingDate(new Date());
        ticket.setEmail("dami.vida@gmail.com");

        Mockito.when(ticketBookingDao.deleteById(1));
    }*/

    @Test
    void getAllBookedTickets() {

        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setPassengerName("VidixOffnzix");
        ticket.setSourceStation("Osijek");
        ticket.setDestStation("Prague");
        ticket.setBookingDate(new Date());
        ticket.setEmail("dami.vida@gmail.com");

        Ticket ticket2 = new Ticket();
        ticket2.setTicketId(2);
        ticket2.setPassengerName("VidixDefanzix");
        ticket2.setSourceStation("Osijek");
        ticket2.setDestStation("Prague");
        ticket2.setBookingDate(new Date());
        ticket2.setEmail("dami.vida@gmail.com");

        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket);
        ticketList.add(ticket2);

        Mockito.when(ticketBookingDao.findAll()).thenReturn(ticketList);
        assertThat(ticketBookingService.getAllBookedTickets()).isEqualTo(ticketList);


    }

    @Test
    void updateTicket() {

        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setPassengerName("VidixOffnzix");
        ticket.setSourceStation("Osijek");
        ticket.setDestStation("Prague");
        ticket.setBookingDate(new Date());
        ticket.setEmail("dami.vida@gmail.com");

        Mockito.when(ticketBookingDao.findOne(ticket.getTicketId())).thenReturn(ticket);

        ticket.setEmail("vida.damir@gmail.com");

        Mockito.when(ticketBookingDao.save(ticket)).thenReturn(ticket);

        assertThat(ticketBookingService.updateTicket(ticket.getTicketId(), "damir.vida@gmail.com")).isEqualTo(ticket);

    }

    @Test
    void getTicketByEmail() {

        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setPassengerName("VidixOffnzix");
        ticket.setSourceStation("Osijek");
        ticket.setDestStation("Prague");
        ticket.setBookingDate(new Date());
        ticket.setEmail("dami.vida@gmail.com");

        Mockito.when(ticketBookingDao.findByEmail(ticket.getEmail())).thenReturn(ticket);
        assertThat(ticketBookingService.getTicketByEmail(ticket.getEmail())).isEqualTo(ticket);
    }
}