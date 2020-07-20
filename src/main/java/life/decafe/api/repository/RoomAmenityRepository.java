package life.decafe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomAmenityRepository extends JpaRepository<RoomAmenityRepository, Long> {
}
