package life.decafe.api.service;

import life.decafe.api.model.entity.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {

  /**
   * Create new profile
   * @param profile
   * @return newly created profile
   */
  Profile createProfile(Profile profile);

  /**
   * Find all profiles
   * @param
   * @return List<
   */

  List<Profile> findAllProfiles();

  /**
   * Find profile by its Id
   * @param profileId profile Id
   * @return profile if exists, empty optional otherwise
   */
  Optional<Profile> findProfileById(Long profileId);






}
