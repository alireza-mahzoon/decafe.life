package life.decafe.api.repository;

import life.decafe.api.model.entity.HotelAmenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelAmenityRepository extends JpaRepository<HotelAmenity, Long> {
  List<HotelAmenity> findAllByHotelId(Long hotelId);
  Optional<HotelAmenity> findByHotelIdAndName(Long hotelId, String name);
}
