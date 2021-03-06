package life.decafe.api.repository;

import life.decafe.api.model.entity.Profile;
import life.decafe.api.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
  List<Room> findAllByHotelId(Long hotelId);
  Optional<Room> findByHotelIdAndNumber(Long hotelId, Integer number);
}
