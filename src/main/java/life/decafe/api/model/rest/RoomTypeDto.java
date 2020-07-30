package life.decafe.api.model.rest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RoomTypeDto {
  @EqualsAndHashCode.Include
  @Schema(description = "Unique Id of this room type", example = "1233456", accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;
  @Schema(description = "Unique Id for hotel", example = "123456")
  @NotBlank(message = "HotelId cannot be blank")
  private Long hotelId;
  @Schema(description = "Name of this room type", example = "Type one")
  @NotBlank(message = "Name cannot be blank")
  private String name;
  @Schema(description = "Description of this room type", example = "Single bed")
  @NotBlank(message = "Description can not be blank")
  private String description;
  @Schema(description = "Capacity of this room type", example = "1")
  @NotBlank(message = "Capacity can not be blank")
  private int capacity;
  @Schema(description = "Registered time and date of data", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime Registered;
  @Schema(description = "Updated time and date", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime Updated;
}
