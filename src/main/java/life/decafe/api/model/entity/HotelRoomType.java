package life.decafe.api.model.entity;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.entity.RoomType;
import lombok.Data;

import javax.persistence.Embedded;

@Data
public class HotelRoomType {
  @Embedded
  private Hotel hotel;
  @Embedded
  private RoomType roomType;

}
