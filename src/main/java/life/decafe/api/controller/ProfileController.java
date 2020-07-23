package life.decafe.api.controller;

import life.decafe.api.model.entity.Profile;
import life.decafe.api.repository.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);
  private final ProfileRepository profileRepository;

  @Autowired
  public ProfileController(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Profile>> getAllUsers() {
    LOGGER.info("Retrieving all users");
    List<Profile> users = profileRepository.findAll();
    return ResponseEntity.ok(users);
  }

}
