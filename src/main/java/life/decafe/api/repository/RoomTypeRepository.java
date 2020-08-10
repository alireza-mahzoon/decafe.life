package life.decafe.api.repository;

import life.decafe.api.model.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
  List<RoomType> findAllByHotelId(Long hotelId);
  boolean existsByIdAndHotelId(Long id, Long hotelId);
  Optional<RoomType> findByHotelIdAndName(Long hotelId, String name);
}
