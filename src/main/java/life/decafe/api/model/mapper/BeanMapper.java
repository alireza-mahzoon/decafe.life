package life.decafe.api.model.mapper;

import life.decafe.api.model.entity.*;
import life.decafe.api.model.rest.*;

import java.util.Optional;

public interface BeanMapper {
  HotelDto map(Hotel hotel);
  Hotel map(HotelDto hotel);

  RoomDto map(Room room);
  Room map(RoomDto room);

  ProfileDto map(Profile profile);
  Profile map(ProfileDto profile);

  RoomAmenityDto map(RoomAmenity roomAmenity);
  RoomAmenity map(RoomAmenityDto roomAmenity);

  BookingDto map(Booking booking);
  Booking map(BookingDto booking);
}
