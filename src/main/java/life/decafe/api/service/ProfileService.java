package life.decafe.api.service;

import life.decafe.api.model.entity.Profile;

public interface ProfileService {

  /**
   * Create new profile
   * @param profile
   * @return newly created profile
   */
  Profile createProfile(Profile profile);
}
