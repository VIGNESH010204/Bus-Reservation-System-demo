//package com.busreservation.model;
//
//import jakarta.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "buses")
//public class Bus implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long busId;
//
//    private String busNumber;
//    private String source;
//    private String destination;
//    private int totalSeats;
//    private double fare;
//
//    // Default constructor (required by JPA)
//    public Bus() {
//    }
//
//    // Parameterized constructor (optional, for convenience)
//    public Bus(String busNumber, String source, String destination, int totalSeats, double fare) {
//        this.busNumber = busNumber;
//        this.source = source;
//        this.destination = destination;
//        this.totalSeats = totalSeats;
//        this.fare = fare;
//    }
//
//    // Getters and setters
//
//    public Long getBusId() {
//        return busId;
//    }
//
//    public void setBusId(Long id) {
//        this.busId = id;
//    }
//
//    public String getBusNumber() {
//        return busNumber;
//    }
//
//    public void setBusNumber(String busNumber) {
//        this.busNumber = busNumber;
//    }
//
//    public String getSource() {
//        return source;
//    }
//
//    public void setSource(String source) {
//        this.source = source;
//    }
//
//    public String getDestination() {
//        return destination;
//    }
//
//    public void setDestination(String destination) {
//        this.destination = destination;
//    }
//
//    public int getTotalSeats() {
//        return totalSeats;
//    }
//
//    public void setTotalSeats(int totalSeats) {
//        this.totalSeats = totalSeats;
//    }
//
//    public double getFare() {
//        return fare;
//    }
//
//    public void setFare(double fare) {
//        this.fare = fare;
//    }
//
//    @Override
//    public String toString() {
//        return "Bus{" +
//                "id=" + busId +
//                ", busNumber='" + busNumber + '\'' +
//                ", source='" + source + '\'' +
//                ", destination='" + destination + '\'' +
//                ", totalSeats=" + totalSeats +
//                ", fare=" + fare +
//                '}';
//    }
//}

//
//
//package com.busreservation.model;
//
//import jakarta.persistence.*;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "buses")
//public class Bus implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long busId;
//
//    private String busNumber;
//    private String route;
//    private String source;
//    private String destination;
//    private LocalDateTime departureTime;
//    private int totalSeats;
//    private int availableSeats;
//    private double fare;
//
//    public Bus() {}
//
//    public Bus(String busNumber, String route, String source, String destination,
//               LocalDateTime departureTime, int totalSeats, int availableSeats, double fare) {
//        this.busNumber = busNumber;
//        this.route = route;
//        this.source = source;
//        this.destination = destination;
//        this.departureTime = departureTime;
//        this.totalSeats = totalSeats;
//        this.availableSeats = availableSeats;
//        this.fare = fare;
//    }
//
//    // Getters and setters
//    public Long getBusId() { return busId; }
//    public void setBusId(Long busId) { this.busId = busId; }
//
//    public String getBusNumber() { return busNumber; }
//    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }
//
//    public String getRoute() { return route; }
//    public void setRoute(String route) { this.route = route; }
//
//    public String getSource() { return source; }
//    public void setSource(String source) { this.source = source; }
//
//    public String getDestination() { return destination; }
//    public void setDestination(String destination) { this.destination = destination; }
//
//    public LocalDateTime getDepartureTime() { return departureTime; }
//    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
//
//    public int getTotalSeats() { return totalSeats; }
//    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }
//
//    public int getAvailableSeats() { return availableSeats; }
//    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
//
//    public double getFare() { return fare; }
//    public void setFare(double fare) { this.fare = fare; }
//
//    @Override
//    public String toString() {
//        return "Bus{" +
//                "busId=" + busId +
//                ", busNumber='" + busNumber + '\'' +
//                ", route='" + route + '\'' +
//                ", source='" + source + '\'' +
//                ", destination='" + destination + '\'' +
//                ", departureTime=" + departureTime +
//                ", totalSeats=" + totalSeats +
//                ", availableSeats=" + availableSeats +
//                ", fare=" + fare +
//                '}';
//    }
//}




package com.busreservation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "buses")
public class Bus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    @NotBlank(message = "Bus number is required")
    private String busNumber;

    @NotBlank(message = "Route is required")
    private String route;

    @NotBlank(message = "Source is required")
    private String source;

    @NotBlank(message = "Destination is required")
    private String destination;

    @NotNull(message = "Departure time is required")
    private LocalDateTime departureTime;

    @Min(value = 1, message = "Total seats must be at least 1")
    private int totalSeats;

    @Min(value = 0, message = "Available seats cannot be negative")
    private int availableSeats;

    @DecimalMin(value = "0.0", inclusive = false, message = "Fare must be greater than 0")
    private double fare;

    // Constructors
    public Bus() {}

    public Bus(String busNumber, String route, String source, String destination,
               LocalDateTime departureTime, int totalSeats, int availableSeats, double fare) {
        this.busNumber = busNumber;
        this.route = route;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.fare = fare;
    }

    // Getters and setters
    public Long getBusId() { return busId; }
    public void setBusId(Long busId) { this.busId = busId; }

    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }

    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }

    public int getTotalSeats() { return totalSeats; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }

    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }

    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }

    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + busId +
                ", busNumber='" + busNumber + '\'' +
                ", route='" + route + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime=" + departureTime +
                ", totalSeats=" + totalSeats +
                ", availableSeats=" + availableSeats +
                ", fare=" + fare +
                '}';
    }
}
