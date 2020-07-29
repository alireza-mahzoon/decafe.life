package life.decafe.api.service.impl;

import life.decafe.api.model.entity.Profile;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.ProfileDto;
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
  private final BeanMapper beanMapper;

  public DefaultProfileService(ProfileRepository profileRepository, BeanMapper beanMapper) {
    this.profileRepository = profileRepository;
    this.beanMapper = beanMapper;
  }

  @Override
  public ProfileDto createProfile(ProfileDto profile) {
    LOGGER.debug("Create a profile");
    Profile profileCreated = profileRepository.save(beanMapper.map(profile));
    return beanMapper.map(profileCreated);
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

  @Override
  public Profile updateProfile(Profile profile) {
    LOGGER.debug("Update profile information");
    return profileRepository.save(profile);
  }
}
