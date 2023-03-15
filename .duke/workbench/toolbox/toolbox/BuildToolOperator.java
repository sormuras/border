package toolbox;

import java.io.PrintWriter;
import run.duke.ToolOperator;
import run.duke.ToolRunner;

public record BuildToolOperator(String name) implements ToolOperator {
  public BuildToolOperator() {
    this("build");
  }

  @Override
  public int run(ToolRunner runner, PrintWriter out, PrintWriter err, String... args) {
    var module = "com.github.sormuras.border";
    var sources = "src/*/main/java";
    var classes = ".duke/cache/toolbox/build/classes";
    var main = "--main-class=" + module + ".BorderToolProvider";
    var archive = module + ".jar";

    runner.run("javac", "--module=" + module, "--module-source-path=" + sources, "-d", classes);
    runner.run("jar", "--create", "--file=" + archive, main, "-C", classes + "/" + module, ".");
    runner.run("jarviz", "--version");
    // runner.run("jarviz", "module", "descriptor", "--file", archive);
    return 0;
  }
}
