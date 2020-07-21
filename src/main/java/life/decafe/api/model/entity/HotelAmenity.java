package life.decafe.api.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class HotelAmenity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  @Schema(description = "Unique Id of this hotel amenity", example = "1234567", accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;
  @Schema(description = "Unique Id of this hotel", example = "1234567", accessMode = Schema.AccessMode.READ_ONLY)
  private Long hotelId;
  @Schema(description = "Hotel amenity name", example = "Swimming pool")
  private String name;
  @Schema(description = "More information about hotel amenity", example = "Swimming pool is open every day 10AM-8PM")
  private String description;
  @Schema(description = "Pricing of hotel amenity", example = "300 SEK")
  private String pricing;
  @Schema(description = "Registered time and date of data", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime registered;
  @Schema(description = "Updated time and date", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime updated;
}
