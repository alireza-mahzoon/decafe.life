package life.decafe.api.service.impl;

import life.decafe.api.model.entity.Profile;
import life.decafe.api.repository.ProfileRepository;
import life.decafe.api.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultProfileService implements ProfileService {
  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultProfileService.class);
  private final ProfileRepository profileRepository;

  public DefaultProfileService(ProfileRepository profileRepository) {
    this.profileRepository = profileRepository;
  }

  @Override
  public Profile createProfile(Profile profile) {
    LOGGER.debug("Create a profile");
    Profile profileCreated = profileRepository.save(profile);
    return profileCreated;
  }

  @Override
  public List<Profile> findAllProfiles() {
    LOGGER.debug("Find all profiles");
    return profileRepository.findAll();
  }

  @Override
  public Optional<Profile> findProfileById(Long profileId) {
    LOGGER.debug("Find profile by Id={}", profileId);
    return profileRepository.findById(profileId);
  }

  @Override
  public Void deleteProfileById(Long profileId) {
    LOGGER.debug("Delete profile by Id={}", profileId);
    profileRepository.deleteById(profileId);
    return null;
  }
}
