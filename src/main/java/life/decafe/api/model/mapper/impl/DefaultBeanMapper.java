package life.decafe.api.model.mapper.impl;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.entity.Profile;
import life.decafe.api.model.entity.Room;
import life.decafe.api.model.entity.RoomAmenity;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.HotelDto;
import life.decafe.api.model.rest.ProfileDto;
import life.decafe.api.model.rest.RoomAmenityDto;
import life.decafe.api.model.rest.RoomDto;
import org.springframework.stereotype.Component;

@Component
public class DefaultBeanMapper implements BeanMapper {
  @Override
  public HotelDto map(Hotel hotel) {
    HotelDto hotelDto = new HotelDto();
    hotelDto.setId(hotel.getId());
    hotelDto.setName(hotel.getName());
    hotelDto.setAddress(hotel.getAddress());
    hotelDto.setCity(hotel.getCity());
    hotelDto.setCountry(hotel.getCountry());
    hotelDto.setRegistered(hotel.getRegistered());
    hotelDto.setUpdated(hotel.getUpdated());
    return hotelDto;
  }

  @Override
  public Hotel map(HotelDto hotelDto) {
    Hotel hotel = new Hotel();
    hotel.setId(hotelDto.getId());
    hotel.setName(hotelDto.getName());
    hotel.setAddress(hotelDto.getAddress());
    hotel.setCity(hotelDto.getCity());
    hotel.setCountry(hotelDto.getCountry());
    hotel.setRegistered(hotelDto.getRegistered());
    hotel.setUpdated(hotelDto.getUpdated());
    return hotel;
  }

  @Override
  public RoomDto map(Room room) {
    RoomDto roomDto = new RoomDto();
    roomDto.setId(room.getId());
    roomDto.setHotelId(room.getHotelId());
    roomDto.setNumber(room.getNumber());
    roomDto.setPhoneNumber(room.getPhoneNumber());
    roomDto.setFloor(room.getFloor());
    roomDto.setRoomTypeId(room.getRoomTypeId());
    roomDto.setRegistered(room.getRegistered());
    roomDto.setUpdated(room.getUpdated());
    return roomDto;
  }

  @Override
  public Room map(RoomDto roomDto) {
    Room room = new Room();
    room.setId(roomDto.getId());
    room.setHotelId(roomDto.getHotelId());
    room.setNumber(roomDto.getNumber());
    room.setPhoneNumber(roomDto.getPhoneNumber());
    room.setFloor(roomDto.getFloor());
    room.setRoomTypeId(roomDto.getRoomTypeId());
    room.setRegistered(roomDto.getRegistered());
    room.setUpdated(roomDto.getUpdated());
    return room; 
  }

  @Override
  public ProfileDto map(Profile profile) {
    ProfileDto profileDto = new ProfileDto();
    profileDto.setId(profile.getId());
    profileDto.setFirstName(profile.getFirstName());
    profileDto.setLastName(profile.getLastName());
    profileDto.setEmail(profile.getEmail());
    profileDto.setRegistered(profile.getRegistered());
    profileDto.setUpdated(profile.getUpdated());
    return profileDto;
  }

  @Override
  public Profile map(ProfileDto profileDto) {
    Profile profile = new Profile();
    profile.setId(profileDto.getId());
    profile.setFirstName(profileDto.getFirstName());
    profile.setLastName(profileDto.getLastName());
    profile.setBirthday(profileDto.getBirthday());
    profile.setEmail(profileDto.getEmail());
    profile.setRegistered(profileDto.getRegistered());
    profile.setUpdated(profileDto.getUpdated());
    return profile;
  }

  @Override
  public RoomAmenityDto map(RoomAmenity roomAmenity) {
    RoomAmenityDto roomAmenityDto = new RoomAmenityDto();
    roomAmenityDto.setId(roomAmenity.getId());
    roomAmenityDto.setRoomTypeId(roomAmenity.getRoomTypeId());
    roomAmenityDto.setName(roomAmenity.getName());
    roomAmenityDto.setDescription(roomAmenity.getDescription());
    roomAmenityDto.setPricing(roomAmenity.getPricing());
    roomAmenityDto.setUpdated(roomAmenity.getUpdated());
    roomAmenityDto.setRegistered(roomAmenity.getRegistered());
    return roomAmenityDto;
  }

  @Override
  public RoomAmenity map(RoomAmenityDto roomAmenityDto) {
    RoomAmenity roomAmenity = new RoomAmenity();
    roomAmenity.setId(roomAmenityDto.getId());
    roomAmenity.setName(roomAmenityDto.getName());
    roomAmenity.setRoomTypeId(roomAmenityDto.getRoomTypeId());
    roomAmenity.setDescription(roomAmenityDto.getDescription());
    roomAmenity.setPricing(roomAmenityDto.getPricing());
    roomAmenity.setUpdated(roomAmenityDto.getUpdated());
    roomAmenity.setRegistered(roomAmenityDto.getRegistered());
    return roomAmenity;
  }
}
