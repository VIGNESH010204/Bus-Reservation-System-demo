//package com.busreservation.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.busreservation.model.Bus;
//
//public interface BusRepository extends JpaRepository<Bus, Long> {
//}

package com.busreservation.repository;

import com.busreservation.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
}
