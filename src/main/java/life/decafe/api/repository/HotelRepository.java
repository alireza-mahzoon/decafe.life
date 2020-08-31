package life.decafe.api.repository;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.entity.HotelRoomType;
import life.decafe.api.model.entity.Room;
import life.decafe.api.model.rest.HotelDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
  Optional<Hotel> findByAddress(String address);
  Optional<Hotel> findByAddressAndPhoneNumber(String address, String phoneNumber);

  @Query(nativeQuery = true, value = "SELECT hotel.id FROM HOTEL join roomtype ON hotel.id = roomtype.hotelid")
  List<Object[]> findAllTypeKinds();
  @Query(nativeQuery = true, value = "SELECT hotel.name From booking join hotel ON booking.hotelid = hotel.id where country = 'Germany'")
  List<Object[]> findAllHotelBookedGermany();



  //@Query("SELECT h,t.*, COUNT(r.id) as roomCount FROM roomtype t INNER JOIN hotel h ON h.id = t.hid INNER JOIN room r ON t.id= r.roomtypeid GROUP BY h.id, t.id")
  //List<HotelRoomType> findAllRoomTypes();
}
