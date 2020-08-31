package life.decafe.api.controller;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.entity.HotelRoomType;
import life.decafe.api.model.rest.HotelDto;
import life.decafe.api.repository.HotelRepository;
import life.decafe.api.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/join")
public class JoinController {
  private static final Logger LOGGER = LoggerFactory.getLogger(JoinController.class);
  private final HotelRepository hotelRepository;
  private final RoomTypeService roomTypeService;

  @Autowired
  public JoinController(HotelRepository hotelRepository, RoomTypeService roomTypeService) {
    this.hotelRepository = hotelRepository;
    this.roomTypeService = roomTypeService;
  }
  @GetMapping
  public ResponseEntity<Void> get() {

    List<Object[]> result = hotelRepository.findAllTypeKinds();
    List<Object[]> resultHotelGermany = hotelRepository.findAllHotelBookedGermany();
    //List<HotelRoomType> hotelRoomTypes = hotelRepository.findAllRoomTypes();

    //for (HotelRoomType hotelRoomType : hotelRoomTypes) {
     // System.out.println(hotelRoomType);
    //}

    for (Object[] objects : result) {
      for (Object object : objects) {
        System.out.print(object);
        System.out.print(",");
      }
      System.out.println();
    }
    for (Object[] objects : result) {
      System.out.println(Arrays.toString(objects));
    }
    for (Object[] object : resultHotelGermany) {
      System.out.println(Arrays.toString(object));
    }
    return ResponseEntity.noContent().build();
  }


}
