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
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("app.css");
  }

  @Test
  public void puzzleLoadsSuccess() {
    goTo("http://localhost:4567/");
    fill("#originalString").with("testword");
    submit("#originalSubmit");
    assertThat(pageSource()).contains("Guess");
  }

  @Test
  public void puzzleLoadsFailure() {
    goTo("http://localhost:4567/");
    fill("#originalString").with("");
    submit("#originalSubmit");
    assertThat(pageSource()).contains("Invalid");
  }


  @Test
  public void resultLoadsWin() {
    goTo("http://localhost:4567/");
    fill("#originalString").with("testword");
    submit("#originalSubmit");

    fill("#guessInput").with("testword");
    submit("#guessSubmit");

    assertThat(pageSource()).contains("play again");
  }

  @Test
  public void resultLoadsFail() {
    goTo("http://localhost:4567/");
    fill("#originalString").with("testword");
    submit("#originalSubmit");

    fill("#guessInput").with("anything else");
    submit("#guessSubmit");
    assertThat(pageSource()).contains("try again");
  }



}
