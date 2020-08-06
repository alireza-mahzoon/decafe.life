package life.decafe.api.model.rest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HotelDto {
  @EqualsAndHashCode.Include
  @Schema(description = "Unique Id of this hotel", example = "1234567", accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;
  @Schema(description = "Hotel name", example = "Scandic")
  @NotBlank(message = "Name cannot be blank")
  private String name;
  @Schema(description = "Address of hotel", example = "Oxford street number 20")
  @NotBlank(message = "Address cannot be blank")
  private String address;
  @Schema(description = "City that hotel is located in", example = "Stockholm")
  @NotBlank(message = "City cannot be blank")
  private String city;
  @Schema(description = "Country that the hotel located", example = "Sweden")
  @NotBlank(message = "Country cannot be blank")
  private String country;
  @Schema(description = "Registered time and date of data", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime registered;
  @Schema(description = "Updated time and date", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime updated;
}
