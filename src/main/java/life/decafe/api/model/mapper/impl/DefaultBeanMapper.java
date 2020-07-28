package life.decafe.api.model.mapper.impl;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.entity.Room;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.HotelDto;
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
}
