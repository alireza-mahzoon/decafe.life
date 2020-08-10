package life.decafe.api.repository;

import life.decafe.api.model.entity.Room;
import life.decafe.api.model.entity.RoomAmenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomAmenityRepository extends JpaRepository<RoomAmenity, Long> {
  List<RoomAmenity> findAllByRoomTypeId(Long RoomTypeId);
  Optional<RoomAmenity> findByRoomTypeIdAndName(Long RoomTypeId, String name);
}
