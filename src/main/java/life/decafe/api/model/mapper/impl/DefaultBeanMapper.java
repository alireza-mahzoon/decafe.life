package life.decafe.api.model.mapper.impl;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.HotelDto;
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
}
