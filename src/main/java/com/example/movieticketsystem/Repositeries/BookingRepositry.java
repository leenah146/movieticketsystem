package com.example.movieticketsystem.Repositeries;
import com.example.movieticketsystem.Entites.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepositry extends JpaRepository<Booking,Integer> {
   Booking findByUserid(Integer id);
}
