package life.decafe.api.model.mapper;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.entity.Profile;
import life.decafe.api.model.entity.Room;
import life.decafe.api.model.rest.HotelDto;
import life.decafe.api.model.rest.ProfileDto;
import life.decafe.api.model.rest.RoomDto;

import java.util.Optional;

public interface BeanMapper {
  HotelDto map(Hotel hotel);
  Hotel map(HotelDto hotel);

  RoomDto map(Room room);
  Room map(RoomDto room);

  ProfileDto map(Profile profile);
  Profile map(ProfileDto profile);
}
