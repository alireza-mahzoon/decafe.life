package life.decafe.api.service.impl;

import life.decafe.api.model.entity.Hotel;
import life.decafe.api.repository.HotelRepository;
import life.decafe.api.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultHotelService implements HotelService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHotelService.class);
  private final HotelRepository hotelRepository;

  @Autowired
  public DefaultHotelService(HotelRepository hotelRepository){
    this.hotelRepository = hotelRepository;
  }

  @Override
  public Hotel createHotel(Hotel hotel) {
    LOGGER.debug("Create a hotel");
    Hotel hotelCreated = hotelRepository.save(hotel);
    return hotelCreated;
  }

  @Override
  public Optional<Hotel> findHotelById(Long hotelId) {
    LOGGER.debug("Find a hotel by Id={}", hotelId);
    return hotelRepository.findById(hotelId);
  }
}
