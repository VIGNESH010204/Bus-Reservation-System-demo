package com.busreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.busreservation.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
