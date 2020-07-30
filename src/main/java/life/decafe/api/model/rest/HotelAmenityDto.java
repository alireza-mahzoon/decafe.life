package life.decafe.api.model.rest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HotelAmenityDto {
  @EqualsAndHashCode.Include
  @Schema(description = "Unique Id of this hotel amenity", example = "1234567", accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;
  @Schema(description = "Unique Id of this hotel", example = "1234567", accessMode = Schema.AccessMode.READ_ONLY)
  @NotBlank(message = "HotelId cannot be blank")
  private Long hotelId;
  @Schema(description = "Hotel amenity name", example = "Swimming pool")
  @NotBlank(message = "Name can not be blank")
  private String name;
  @Schema(description = "More information about hotel amenity", example = "Swimming pool is open every day 10AM-8PM")
  @NotBlank(message = "Description can not be blank")
  private String description;
  @Schema(description = "Pricing of hotel amenity", example = "300 SEK")
  @NotBlank(message = "Pricing can not be blank")
  private String pricing;
  @Schema(description = "Registered time and date of data", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime registered;
  @Schema(description = "Updated time and date", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime updated;
}
