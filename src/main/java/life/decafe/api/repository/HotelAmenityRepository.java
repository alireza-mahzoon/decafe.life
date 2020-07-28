package life.decafe.api.repository;

import life.decafe.api.model.entity.HotelAmenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelAmenityRepository extends JpaRepository<HotelAmenity, Long> {
  List<HotelAmenity> findAllByHotelId(Long hotelId);
}
