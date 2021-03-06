package life.decafe.api.service.impl;

import life.decafe.api.exception.BadRequestException;
import life.decafe.api.exception.NotFoundException;
import life.decafe.api.exception.ResourceConflictException;
import life.decafe.api.model.entity.HotelAmenity;
import life.decafe.api.model.entity.RoomAmenity;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.HotelAmenityDto;
import life.decafe.api.repository.HotelAmenityRepository;
import life.decafe.api.repository.HotelRepository;
import life.decafe.api.service.HotelAmenityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultHotelAmenityService implements HotelAmenityService {
  private final Logger LOGGER = LoggerFactory.getLogger(DefaultHotelAmenityService.class);
  private final HotelAmenityRepository hotelAmenityRepository;
  private final HotelRepository hotelRepository;
  private final BeanMapper beanMapper;

  public DefaultHotelAmenityService(HotelAmenityRepository hotelAmenityRepository, HotelRepository hotelRepository, BeanMapper beanMapper) {
    this.hotelAmenityRepository = hotelAmenityRepository;
    this.hotelRepository = hotelRepository;
    this.beanMapper = beanMapper;
  }

  @Override
  public HotelAmenityDto createHotelAmenity(HotelAmenityDto hotelAmenity) {
    LOGGER.debug("Create a hotel amenity");
    hotelAmenity.setId(null);
    hotelAmenity.setRegistered(LocalDateTime.now());
    hotelAmenity.setUpdated(hotelAmenity.getRegistered());
    if (!hotelRepository.existsById(hotelAmenity.getHotelId())) {
      throw new NotFoundException("This hotel id is not existed");
    }
    Optional<HotelAmenity> existedHotelAmenity = hotelAmenityRepository.findByHotelIdAndName(hotelAmenity.getHotelId(), hotelAmenity.getName());
    if (existedHotelAmenity.isPresent()) {
      throw new ResourceConflictException("This amenity is already exists");
    }
    HotelAmenity hotelAmenityCreated = hotelAmenityRepository.save(beanMapper.map(hotelAmenity));
    return beanMapper.map(hotelAmenityCreated);
  }

  @Override
  public Optional<HotelAmenityDto> findHotelAmenityById(Long hotelAmenityId) {
    LOGGER.debug("Find a hotel amenity by Id={}", hotelAmenityId);
    return hotelAmenityRepository.findById(hotelAmenityId).map(beanMapper::map);
  }

  @Override
  public HotelAmenityDto updateHotelAmenity(HotelAmenityDto hotelAmenityDto) {
    LOGGER.debug("Update hotel amenity");
    HotelAmenity currentHotelAmenity = hotelAmenityRepository.findById(hotelAmenityDto.getId()).orElseThrow(()-> new NotFoundException("Hotel Amenity does not exist"));
    HotelAmenity toUpdate = beanMapper.map(hotelAmenityDto);
    if (!currentHotelAmenity.getHotelId().equals(toUpdate.getHotelId())) {
      throw new BadRequestException("Hotel Id can not be changed");
    }
    if (!currentHotelAmenity.getName().equals(toUpdate.getName())) {
      Optional<HotelAmenity> existedHotelAmenity = hotelAmenityRepository.findByHotelIdAndName(hotelAmenityDto.getHotelId(), hotelAmenityDto.getName());
      if (existedHotelAmenity.isPresent()) {
        throw new ResourceConflictException("The hotel amenity already exists");
      }
    }
    currentHotelAmenity.setName(toUpdate.getName());
    currentHotelAmenity.setDescription(toUpdate.getDescription());
    currentHotelAmenity.setPricing(toUpdate.getPricing());
    currentHotelAmenity.setUpdated(LocalDateTime.now());
    return beanMapper.map(hotelAmenityRepository.save(currentHotelAmenity));
  }

  @Override
  public List<HotelAmenityDto> findAllHotelAmenities(Long hotelId) {
    LOGGER.debug("find all hotel amenities with hotel Id={}", hotelId);
    List<HotelAmenity> hotelAmenities = hotelAmenityRepository.findAll();
    return hotelAmenities.stream().map(beanMapper::map).collect(Collectors.toList());
  }

  @Override
  public void deleteHotelAmenityById(Long hotelAmenityId) {
    LOGGER.debug("Delete hotel amenity with Id={}", hotelAmenityId);
    Optional<HotelAmenity> hotelAmenityToBeDeleted = hotelAmenityRepository.findById(hotelAmenityId);
    if (hotelAmenityToBeDeleted.isPresent()) {
      hotelAmenityRepository.deleteById(hotelAmenityId);
    } else {
      throw new NotFoundException("The hotel amenity does not exist");
    }
  }
}
