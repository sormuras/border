package toolbox;

import java.util.spi.ToolProvider;
import run.duke.Initializer;
import run.duke.Logbook;
import run.duke.Printer;
import run.duke.Tool;
import run.duke.ToolContext;
import run.duke.ToolFinder;
import run.duke.ToolRunner;

public record ToolboxInitializer() implements Initializer {
  @Override
  public ToolRunner newToolRunner(Configuration configuration) {
    var folders = configuration.folders();
    var logbook = Logbook.ofSystem();
    var printer = Printer.ofSystem();
    var context = new ToolContext(folders, logbook, printer);
    var finder =
        ToolFinder.of(
            Tool.of(new BuildToolOperator()),
            Tool.of("JDK", "jar", ToolProvider.findFirst("jar").orElseThrow()),
            Tool.of("JDK", "javac", ToolProvider.findFirst("javac").orElseThrow()),
            Tool.of(ToolProvider.findFirst("jarviz").orElseThrow()));
    return ToolRunner.of(context, finder);
  }
}
