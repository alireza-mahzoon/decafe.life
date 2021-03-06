package life.decafe.api.model.rest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RoomAmenityDto {
  @EqualsAndHashCode.Include
  @Schema(description = "Unique Id of this room amenity", example = "123456", accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;
  @Schema(description = "Unique Id of this room type", example = "1233445")
  @NotNull
  private Long roomTypeId;
  @Schema(description = "Name of room type", example = "Type one")
  @NotBlank(message = "Name cannot be blank")
  private String name;
  @Schema(description = "Description of room type", example = "Mini bar")
  @NotBlank(message = "Description cannot be blank")
  private String description;
  @Schema(description = "Price of this amenity", example = "100 SEK")
  @NotBlank(message = "Pricing cannot be blank")
  private String pricing;
  @Schema(description = "Registered time and date of data", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime registered;
  @Schema(description = "Updated time and date", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime updated;
}
