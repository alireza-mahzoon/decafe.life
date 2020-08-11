package life.decafe.api.service.impl;

import life.decafe.api.exception.BadRequestException;
import life.decafe.api.exception.NotFoundException;
import life.decafe.api.exception.ResourceConflictException;
import life.decafe.api.model.entity.Booking;
import life.decafe.api.model.entity.Hotel;
import life.decafe.api.model.entity.Room;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.BookingDto;
import life.decafe.api.repository.BookingRepository;
import life.decafe.api.repository.HotelRepository;
import life.decafe.api.repository.ProfileRepository;
import life.decafe.api.repository.RoomRepository;
import life.decafe.api.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DefaultBookingService implements BookingService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultBookingService.class);
  private final BookingRepository bookingRepository;
  private final ProfileRepository profileRepository;
  private final HotelRepository hotelRepository;
  private final RoomRepository roomRepository;

  private final BeanMapper beanMapper;

  public DefaultBookingService(BookingRepository bookingRepository, ProfileRepository profileRepository, HotelRepository hotelRepository, RoomRepository roomRepository, BeanMapper beanMapper) {
    this.bookingRepository = bookingRepository;
    this.profileRepository = profileRepository;
    this.hotelRepository = hotelRepository;
    this.roomRepository = roomRepository;
    this.beanMapper = beanMapper;
  }

  @Override
  public BookingDto createBooking(BookingDto booking) {
    LOGGER.debug("Create a booking");
    booking.setId(null);
    booking.setRegistered(LocalDateTime.now());
    booking.setUpdated(booking.getRegistered());
    if (!profileRepository.existsById(booking.getProfileId())) {
      throw new NotFoundException("The profile is not existed");
    }
    if (!hotelRepository.existsById(booking.getHotelId())) {
      throw new NotFoundException("The hotel is not existed");
    }
    if (!roomRepository.existsById(booking.getRoomId())) {
      throw new NotFoundException("The room is not existed");
    }
    Room existedRoom = roomRepository.getOne(booking.getRoomId());
    if (!existedRoom.getHotelId().equals(booking.getHotelId())) {
      throw new ResourceConflictException("The room is not located in the hotel");
    }

//    LocalDate MinTime = Collections.min(bookingRepository.findAllCheckInDatesByRoomId(booking.getRoomId()));
//    LocalDate MaxTime = Collections.max(bookingRepository.findAllCheckOutDatesByRoomId(booking.getRoomId()));
//
//    if (booking.getCheckInDate().compareTo(MaxTime)<0) {
//      throw new ResourceConflictException("Room is not available in the check in date");
//    }
//    if (booking.getCheckOutDate().compareTo(MinTime)>0) {
//      throw new ResourceConflictException("Room is not available in the check in date");
//    }
    Booking createdBooking = bookingRepository.save(beanMapper.map(booking));
    return beanMapper.map(createdBooking);
  }

  @Override
  public Optional<BookingDto> findBookingById(Long bookingId) {
    LOGGER.debug("Find a booking by Id={}", bookingId);
    return bookingRepository.findById(bookingId).map(beanMapper::map);
  }

  @Override
  public List<BookingDto> findAllBooking() {
    LOGGER.debug("Find all bookings");
    List<Booking> bookings = bookingRepository.findAll();
    return bookings.stream().map(beanMapper::map).collect(Collectors.toList());
  }

  @Override
  public BookingDto updateBooking(BookingDto booking) {
    LOGGER.debug("Update a booking");
    Booking bookingUpdated = bookingRepository.save(beanMapper.map(booking));
    return beanMapper.map(bookingUpdated);
  }

  @Override
  public void deleteBooking(Long bookingId) {
    LOGGER.debug("Delete a booking");
    Optional<Booking> bookingToDelete = bookingRepository.findById(bookingId);
    if (bookingToDelete.isPresent()) {
      bookingRepository.deleteById(bookingId);
    } else {
      throw new NotFoundException("The booking does not exist");
    }
  }
}
