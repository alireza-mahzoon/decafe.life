package life.decafe.api.model.mapper;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.rest.HotelDto;

public interface BeanMapper {
  HotelDto map(Hotel hotel);
  Hotel map(HotelDto hotel);
}
