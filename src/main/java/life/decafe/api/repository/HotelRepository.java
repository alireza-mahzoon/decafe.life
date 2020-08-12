package life.decafe.api.repository;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.entity.Room;
import life.decafe.api.model.rest.HotelDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
  Optional<Hotel> findByAddress(String address);
  Optional<Hotel> findByAddressAndPhoneNumber(String address, String phoneNumber);
}
