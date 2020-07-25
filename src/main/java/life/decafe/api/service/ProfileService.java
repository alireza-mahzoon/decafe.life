package life.decafe.api.service;

import life.decafe.api.model.entity.Profile;

import java.util.List;

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
}
