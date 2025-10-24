//package com.busreservation.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "reservations")
//public class Reservation {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "bus_id")
//    private Bus bus;
//
//    private int seatCount;
//    private LocalDateTime reservationDate = LocalDateTime.now();
//
//    // Getters and Setters
//}

//package com.busreservation.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//
//@Entity
//@Table(name = "reservations")
//public class Reservation {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "bus_id", nullable = false)
//    private Bus bus;
//
//    private int seatCount;
//    private LocalDateTime reservationDate;
//
//    @PrePersist
//    protected void onCreate() {
//        this.reservationDate = LocalDateTime.now();
//    }
//
//    // Getters and setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public Bus getBus() { return bus; }
//    public void setBus(Bus bus) { this.bus = bus; }
//
//    public int getSeatCount() { return seatCount; }
//    public void setSeatCount(int seatCount) { this.seatCount = seatCount; }
//
//    public LocalDateTime getReservationDate() { return reservationDate; }
//    public void setReservationDate(LocalDateTime reservationDate) { this.reservationDate = reservationDate; }
//}


//
//package com.busreservation.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "reservations")
//public class Reservation {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message = "Passenger name is required")
//    private String passengerName;
//
//    @ManyToOne
//    @JoinColumn(name = "bus_id", nullable = false)
//    private Bus bus;
//
//    @Min(value = 1, message = "Seat count must be at least 1")
//    private int seatCount;
//
//    private LocalDateTime reservationDate;
//
//    @PrePersist
//    protected void onCreate() {
//        this.reservationDate = LocalDateTime.now();
//    }
//
//    public Reservation() {}
//
//    public Reservation(String passengerName, Bus bus, int seatCount) {
//        this.passengerName = passengerName;
//        this.bus = bus;
//        this.seatCount = seatCount;
//        this.reservationDate = LocalDateTime.now();
//    }
//
//    // Getters and setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getPassengerName() { return passengerName; }
//    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }
//
//    public Bus getBus() { return bus; }
//    public void setBus(Bus bus) { this.bus = bus; }
//
//    public int getSeatCount() { return seatCount; }
//    public void setSeatCount(int seatCount) { this.seatCount = seatCount; }
//
//    public LocalDateTime getReservationDate() { return reservationDate; }
//    public void setReservationDate(LocalDateTime reservationDate) { this.reservationDate = reservationDate; }
//
//    @Override
//    public String toString() {
//        return "Reservation{" +
//                "id=" + id +
//                ", passengerName='" + passengerName + '\'' +
//                ", bus=" + bus.getBusNumber() +
//                ", seatCount=" + seatCount +
//                ", reservationDate=" + reservationDate +
//                '}';
//    }
//}



package com.busreservation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;


    @NotBlank(message = "Passenger name is required")
    @Column(name = "passenger_name", nullable = false)
    private String passengerName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

    @Min(value = 1, message = "Seat count must be at least 1")
    @Column(name = "seat_count", nullable = false)
    private int seatCount;

    @Column(name = "reservation_date", nullable = false)
    private LocalDateTime reservationDate;

    @PrePersist
    protected void onCreate() {
        this.reservationDate = LocalDateTime.now();
    }

    public Reservation() {}

    public Reservation(String passengerName, Bus bus, int seatCount) {
        this.passengerName = passengerName;
        this.bus = bus;
        this.seatCount = seatCount;
        this.reservationDate = LocalDateTime.now();
    }
    
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }


    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public Bus getBus() { return bus; }
    public void setBus(Bus bus) { this.bus = bus; }

    public int getSeatCount() { return seatCount; }
    public void setSeatCount(int seatCount) { this.seatCount = seatCount; }

    public LocalDateTime getReservationDate() { return reservationDate; }
    public void setReservationDate(LocalDateTime reservationDate) { this.reservationDate = reservationDate; }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", passengerName='" + passengerName + '\'' +
                ", bus=" + (bus != null ? bus.getBusNumber() : "null") +
                ", seatCount=" + seatCount +
                ", reservationDate=" + reservationDate +
                '}';
    }
}

