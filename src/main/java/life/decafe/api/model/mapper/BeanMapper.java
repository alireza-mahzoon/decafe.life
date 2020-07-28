package life.decafe.api.model.mapper;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.entity.Room;
import life.decafe.api.model.rest.HotelDto;
import life.decafe.api.model.rest.RoomDto;

public interface BeanMapper {
  HotelDto map(Hotel hotel);
  Hotel map(HotelDto hotel);
  RoomDto map(Room room);
  Room map(RoomDto room);
}
