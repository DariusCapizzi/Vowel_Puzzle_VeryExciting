
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
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/puzzle.vtl");
      String inPuzzle = req.queryParams("inPuzzle");
      String outPuzzle = VowelReplace.vowelsToDash(inPuzzle);
      model.put("puzzleOut", outPuzzle);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
