package life.decafe.api.model.rest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProfileDto {
  @EqualsAndHashCode.Include
  @Schema(description = "Unique id of this profile", example = "123456", accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;
  @Schema(description = "First name of this profile", example = "Peter")
  @NotBlank(message = "FirstName cannot be blank")
  private String firstName;
  @Schema(description = "Last name of this profile", example = "Andersson")
  @NotBlank(message ="LastName can not be blank")
  private String lastName;
  @Schema(description = "Birthday of this profile", example = "2000-03-03")
  @NotNull
  @Past
  private LocalDate birthday;
  @Schema(description = "Email of this profile", example = "peter@gmail.com")
  @Email(message = "Email cannot be blank")
  @NotNull(message = "The email is not entered")
  private String email;
  @Schema(description = "Registered time and date of data", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime Registered;
  @Schema(description = "Updated time and date", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime updated;
}

