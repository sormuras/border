module toolbox {
  requires run.duke;

  provides java.util.spi.ToolProvider with
      toolbox.BuildToolOperator;
}
