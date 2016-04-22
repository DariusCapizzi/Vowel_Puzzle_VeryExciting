import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void homeLoads() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("hey");
  }

  @Test
  public void cssLoads() {
    goTo("http://localhost:4567/result");
    assertThat(pageSource()).contains("app.css");
  }

  @Test
  public void resultsLoads() {
    goTo("http://localhost:4567/puzzle");
    assertThat(pageSource()).contains("can");
  }
}
