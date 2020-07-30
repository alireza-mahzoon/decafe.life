package life.decafe.api.service.impl;

import life.decafe.api.model.entity.Booking;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.BookingDto;
import life.decafe.api.repository.BookingRepository;
import life.decafe.api.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DefaultBookingService implements BookingService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultBookingService.class);
  private final BookingRepository bookingRepository;
  private final BeanMapper beanMapper;

  public DefaultBookingService(BookingRepository bookingRepository, BeanMapper beanMapper) {
    this.bookingRepository = bookingRepository;
    this.beanMapper = beanMapper;
  }

  @Override
  public BookingDto createBooking(BookingDto booking) {
    LOGGER.debug("Create a booking");
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
  public Void deleteBooking(Long bookingId) {
    LOGGER.debug("Delete a booking");
    bookingRepository.deleteById(bookingId);
    return null;
  }
}
