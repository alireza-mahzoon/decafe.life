package life.decafe.api.service.impl;

import life.decafe.api.exception.BadRequestException;
import life.decafe.api.exception.NotFoundException;
import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.HotelDto;
import life.decafe.api.repository.HotelRepository;
import life.decafe.api.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultHotelService implements HotelService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHotelService.class);
  private final HotelRepository hotelRepository;
  private final BeanMapper beanMapper;

  @Autowired
  public DefaultHotelService(HotelRepository hotelRepository, BeanMapper beanMapper){
    this.hotelRepository = hotelRepository;
    this.beanMapper = beanMapper;
  }

  @Override
  public HotelDto createHotel(HotelDto hotel) {
    LOGGER.debug("Create a hotel");
    hotel.setId(null);
    hotel.setRegistered(LocalDateTime.now());
    hotel.setUpdated(hotel.getRegistered());
    if (hotelRepository.findByAddress(hotel.getAddress()).isPresent()) {
      throw new BadRequestException("The hotel already created");
    }
    Hotel hotelCreated = hotelRepository.save(beanMapper.map(hotel));
    return beanMapper.map(hotelCreated);
  }

  @Override
  public Optional<HotelDto> findHotelById(Long hotelId) {
    LOGGER.debug("Find a hotel by Id={}", hotelId);
    return hotelRepository.findById(hotelId).map(beanMapper::map);
  }

  @Override
  public List<HotelDto> findAllHotels() {
    LOGGER.debug("Find all hotels");
    List<Hotel> hotels = hotelRepository.findAll();
    return hotels.stream().map(beanMapper::map).collect(Collectors.toList());
  }

  @Override
  public Long countHotels() {
    LOGGER.debug("Count all hotels");
    return hotelRepository.count();
  }

  @Override
  public Void deleteById(Long hotelId) {
    LOGGER.debug("Delete hotel by Id");
    hotelRepository.deleteById(hotelId);
    return null;
  }

  @Override
  public HotelDto updateHotel(HotelDto hotelDto) {
    LOGGER.debug("Update hotel");
    Hotel currentHotel = hotelRepository.findById(hotelDto.getId()).orElseThrow(()-> new NotFoundException("Hotel does not existed"));
    Hotel hotelToUpdate = hotelRepository.save(beanMapper.map(hotelDto));
    currentHotel.setName(hotelToUpdate.getName());
    currentHotel.setAddress(hotelToUpdate.getAddress());
    currentHotel.setCity(hotelToUpdate.getCity());
    currentHotel.setCountry(hotelToUpdate.getCountry());
    currentHotel.setUpdated(LocalDateTime.now());
    return beanMapper.map(currentHotel);
  }
}
