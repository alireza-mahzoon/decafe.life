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
public class RoomType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  @Schema(description = "Unique Id of this room type", example = "1233456", accessMode = Schema.AccessMode.READ_ONLY)
  private Long id;
  @Schema(description = "Unique Id for hotel", example = "123456")
  private Long hotelId;
  @Schema(description = "Name of this room type", example = "Type one")
  private String name;
  @Schema(description = "Description of this room type", example = "Single bed")
  private String description;
  @Schema(description = "Capacity of this room type", example = "1")
  private int capacity;
  @Schema(description = "Registered time and date of data", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime Registered;
  @Schema(description = "Updated time and date", example = "2020-03-03 19:20:20.994", accessMode = Schema.AccessMode.READ_ONLY)
  private LocalDateTime Updated;
}
