import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (req,res) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/puzzle", (req,res) -> {
      String inPuzzle = req.queryParams("inPuzzle");
      String outPuzzle = VowelReplace.vowelsToDash(inPuzzle);
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("answer", inPuzzle);
      model.put("puzzleOut", outPuzzle);
      model.put("template", "templates/puzzle.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/result", (req,res) -> {
      System.out.println(req.queryParams());
      String userGuess = req.queryParams("guess");
      String answer = req.queryParams("answer");
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/result.vtl");
      if ( userGuess.equals(answer) ){
        model.put("testWin", "Won");
      } else {
        model.put("testWin", "lost");
        model.put("answer", answer);
      }
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

}
