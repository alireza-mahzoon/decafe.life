package life.decafe.api.model.mapper.impl;

import life.decafe.api.model.entity.*;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.*;
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

  @Override
  public BookingDto map(Booking booking) {
    BookingDto bookingDto = new BookingDto();
    bookingDto.setId(booking.getId());
    bookingDto.setProfileId(booking.getProfileId());
    bookingDto.setCheckInDate(booking.getCheckInDate());
    bookingDto.setCheckOutDate(booking.getCheckOutDate());
    bookingDto.setHotelId(booking.getHotelId());
    bookingDto.setRoomId(booking.getRoomId());
    bookingDto.setRegistered(booking.getRegistered());
    bookingDto.setUpdated(booking.getUpdated());
    return bookingDto;
  }

  @Override
  public Booking map(BookingDto bookingDto) {
    Booking booking = new Booking();
    booking.setId(bookingDto.getId());
    booking.setProfileId(bookingDto.getProfileId());
    booking.setCheckInDate(bookingDto.getCheckInDate());
    booking.setCheckOutDate(bookingDto.getCheckOutDate());
    booking.setRegistered(bookingDto.getRegistered());
    booking.setUpdated(bookingDto.getUpdated());
    return booking;
  }

  @Override
  public RoomTypeDto map(RoomType roomType) {
    RoomTypeDto roomTypeDto = new RoomTypeDto();
    roomTypeDto.setId(roomType.getId());
    roomTypeDto.setHotelId(roomType.getHotelId());
    roomTypeDto.setName(roomType.getDescription());
    roomTypeDto.setDescription(roomType.getDescription());
    roomTypeDto.setCapacity(roomType.getCapacity());
    roomTypeDto.setRegistered(roomType.getRegistered());
    roomTypeDto.setUpdated(roomType.getUpdated());
    return roomTypeDto;
  }

  @Override
  public RoomType map(RoomTypeDto roomTypeDto) {
    RoomType roomType = new RoomType();
    roomType.setId(roomTypeDto.getId());
    roomType.setHotelId(roomTypeDto.getHotelId());
    roomType.setName(roomTypeDto.getName());
    roomType.setDescription(roomTypeDto.getDescription());
    roomType.setCapacity(roomTypeDto.getCapacity());
    roomType.setRegistered(roomTypeDto.getRegistered());
    roomType.setUpdated(roomTypeDto.getUpdated());
    return roomType;
  }

  @Override
  public HotelAmenityDto map(HotelAmenity hotelAmenity) {
    HotelAmenityDto hotelAmenityDto = new HotelAmenityDto();
    hotelAmenityDto.setId(hotelAmenity.getId());
    hotelAmenityDto.setHotelId(hotelAmenity.getHotelId());
    hotelAmenityDto.setName(hotelAmenity.getName());
    hotelAmenityDto.setDescription(hotelAmenity.getDescription());
    hotelAmenityDto.setPricing(hotelAmenity.getPricing());
    hotelAmenityDto.setRegistered(hotelAmenity.getRegistered());
    hotelAmenityDto.setUpdated(hotelAmenity.getUpdated());
    return hotelAmenityDto;
  }

  @Override
  public HotelAmenity map(HotelAmenityDto hotelAmenityDto) {
    HotelAmenity hotelAmenity = new HotelAmenity();
    hotelAmenity.setId(hotelAmenityDto.getId());
    hotelAmenity.setHotelId(hotelAmenityDto.getHotelId());
    hotelAmenity.setName(hotelAmenityDto.getName());
    hotelAmenity.setDescription(hotelAmenityDto.getDescription());
    hotelAmenity.setPricing(hotelAmenityDto.getPricing());
    hotelAmenity.setRegistered(hotelAmenityDto.getRegistered());
    hotelAmenity.setUpdated(hotelAmenityDto.getUpdated());
    return hotelAmenity;
  }
}
