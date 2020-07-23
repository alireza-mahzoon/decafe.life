package life.decafe.api.controller;

import life.decafe.api.model.entity.User;
import life.decafe.api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

//  @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
//  public ResponseEntity<List<User>> getAllUsers() {
//    LOGGER.info("Retrieving all users");
//    List<User> users = userRepository.findAll();
//    return ResponseEntity.ok(users);
//  }

  @DeleteMapping(value = "/{userId}")
  public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
    LOGGER.info("Deleting a user with Id={}", userId);
    userRepository.deleteById(userId);
    return ResponseEntity.noContent().build();
  }
}
