package life.decafe.api.repository;

import life.decafe.api.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
  List<Room> findAllByHotelId(Long hotelId);
}
