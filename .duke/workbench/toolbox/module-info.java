module toolbox {
  requires org.kordamp.jarviz.tool;
  requires run.duke;

  provides run.duke.Initializer with
      toolbox.ToolboxInitializer;
}
