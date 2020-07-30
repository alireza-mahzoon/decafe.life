package life.decafe.api.model.rest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BookingDto {
  @EqualsAndHashCode.Include
  @Schema(description = "Unique Id of this booking", example = "123456", accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;
  @Schema(description = "Unique ID of this profile", example = "123456")
  @NotBlank(message = "ProfileId cannot be blank")
  private Long profileId;
  @Schema(description = "Check in date", example = "2020-09-19")
  @NotBlank(message = "CheckIn date cannot be blank")
  private LocalDate checkInDate;
  @Schema(description = "Check out date", example = "2020-10-19")
  @NotBlank(message = "Check out date can not be blank")
  private LocalDate checkOutDate;
  @Schema(description = "Unique Id for this hotel", example = "123456")
  @NotBlank(message = "Hotel Id cannot be blank")
  private Long hotelId;
  @Schema(description = "Unique Id for this room", example = "123456")
  @NotBlank(message = "Room Id cannot be blank")
  private Long roomId;
  @Schema(description = "Registered time and date of data", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime Registered;
  @Schema(description = "Updated time and date of data", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime Updated;
}
