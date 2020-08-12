package life.decafe.api.repository;

import life.decafe.api.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
  List<LocalDate> findAllCheckInDatesByRoomId(Long roomId);
  List<LocalDate> findAllCheckOutDatesByRoomId(Long roomId);
}
