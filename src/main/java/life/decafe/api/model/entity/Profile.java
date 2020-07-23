package life.decafe.api.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Profile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  @Schema(description = "Unique id of this user", example = "123456")
  private Long id;
  @Schema(description = "First name of this user", example = "Peter")
  private String firstName;
  @Schema(description = "Last name of this user", example = "Andersson")
  private String lastName;
  @Schema(description = "Birthday of this user", example = "2000-03-03")
  private LocalDate birthday;
  @Schema(description = "Email of this user", example = "peter@gmail.com")
  private String email;
  @Schema(description = "Registered time and date of data", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime Registered;
  @Schema(description = "Updated time and date", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime updated;
}
