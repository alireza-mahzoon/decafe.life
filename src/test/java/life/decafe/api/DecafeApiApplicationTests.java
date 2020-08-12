package life.decafe.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.NotBlank;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DecafeApiApplicationTests {

  @Test
  void contextLoads() {
    @NotBlank
    String nullString = null;
    String emptyString = "";
    String blankString = " ";
  }
}
