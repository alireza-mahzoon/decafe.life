package life.decafe.api.model.rest;

import life.decafe.api.model.entity.HotelAmenity;
import lombok.Data;


import java.util.List;

@Data
public class HotelOfferDetails {
  private HotelDto hotel;
  private List<HotelAmenityDto> amenities;
  private List<RoomTypeDto> roomTypes;
}
