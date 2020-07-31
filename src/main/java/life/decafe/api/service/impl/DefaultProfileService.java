package life.decafe.api.service.impl;

import life.decafe.api.exception.ResourceConflictException;
import life.decafe.api.model.entity.Profile;
import life.decafe.api.model.mapper.BeanMapper;
import life.decafe.api.model.rest.ProfileDto;
import life.decafe.api.repository.ProfileRepository;
import life.decafe.api.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    profile.setEmail(profile.getEmail().toLowerCase());
    String profileEmail = profile.getEmail();
    Optional<Profile> existedProfile = profileRepository.findByEmail(profileEmail);
    if (existedProfile.isPresent()) {
      throw new ResourceConflictException("The email already exists");
    }
    Profile profileCreated = profileRepository.save(beanMapper.map(profile));
    return beanMapper.map(profileCreated);
  }

  @Override
  public List<ProfileDto> findAllProfiles() {
    LOGGER.debug("Find all profiles");
    List<Profile> profiles = profileRepository.findAll();
    return profiles.stream().map(beanMapper::map).collect(Collectors.toList());
  }

  @Override
  public Optional<ProfileDto> findProfileById(Long profileId) {
    LOGGER.debug("Find profile by Id={}", profileId);
    return profileRepository.findById(profileId).map(beanMapper::map);
  }

  @Override
  public Void deleteProfileById(Long profileId) {
    LOGGER.debug("Delete profile by Id={}", profileId);
    profileRepository.deleteById(profileId);
    return null;
  }

  @Override
  public ProfileDto updateProfile(ProfileDto profile) {
    LOGGER.debug("Update profile information");
    Profile profileUpdated = profileRepository.save(beanMapper.map(profile));
    return beanMapper.map(profileUpdated);
  }
}
