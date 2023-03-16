module toolbox {
  requires org.kordamp.jarviz.tool;
  requires run.duke;

  provides java.util.spi.ToolProvider with
      toolbox.BuildToolOperator;
}
