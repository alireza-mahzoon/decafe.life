package life.decafe.api.model.rest;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RoomDto {
  @EqualsAndHashCode.Include
  @Schema(description = "Unique Id of this room", example = "123456", accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;
  @Schema(description = "Unique Id of this hotel", example = "1223456")
  @NotNull
  private Long hotelId;
  @Schema(description = "Room Number", example = "12345")
  private Integer number;
  @Schema(description = "Room phone number", example = "3214")
  @NotBlank(message = "Phone number can not be blank")
//  @Pattern(regexp = "^(\\d{3}[- .]?){2}\\d{4}$ + ^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Phone number is not valid")
  private String phoneNumber;
  @Schema(description = "Room floor", example = "23")
  @PositiveOrZero
  private Integer floor;
  @Schema(description = "Unique Id of this roomType", example = "123456")
  @NotNull
  private Long roomTypeId;
  @Schema(description = "Registered time and date of data", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime registered;
  @Schema(description = "Updated time and date", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime updated;
}
