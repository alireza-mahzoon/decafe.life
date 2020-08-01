package life.decafe.api.controller;

import life.decafe.api.model.rest.ProfileDto;
import life.decafe.api.repository.ProfileRepository;
import life.decafe.api.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);
  private final ProfileService profileService;

  @Autowired
  public ProfileController(ProfileService profileService) {
    this.profileService = profileService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<ProfileDto>> getAllUsers() {
    LOGGER.info("Retrieving all users");
    List<ProfileDto> users = profileService.findAllProfiles();
    return ResponseEntity.ok(users);
  }

  @GetMapping(value = "/{profileId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProfileDto> findProfile(@PathVariable Long profileId) {
    LOGGER.info("Retrieving profile by Id={}", profileId);
    Optional<ProfileDto> profile = profileService.findProfileById(profileId);
    if (profile.isPresent()) {
      return ResponseEntity.ok(profile.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProfileDto> createProfile(@Validated @RequestBody ProfileDto profile) {
    LOGGER.info("Creating a profile");
    ProfileDto userProfile = profileService.createProfile(profile);
    return ResponseEntity.ok(userProfile);
  }

  @PutMapping(value = "/{profileId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProfileDto> updateProfile(@RequestBody ProfileDto profile, @PathVariable Long profileId) {
    LOGGER.info("Update a profile with Id ={}", profileId);
    ProfileDto updatedProfile = profileService.updateProfile(profile);
    return ResponseEntity.ok(updatedProfile);
  }

  @DeleteMapping(value = "/{profileId}")
  public ResponseEntity<Void> deleteUserById(@PathVariable Long profileId) {
    LOGGER.info("Deleting a user with Id={}", profileId);
    profileService.deleteProfileById(profileId);
    return ResponseEntity.noContent().build();
  }
}
