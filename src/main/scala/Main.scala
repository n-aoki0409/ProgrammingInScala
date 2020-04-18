import org.stairwaybook.scells.SpreadSheet
import scala.swing.{MainFrame, SimpleSwingApplication}

object Main extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "ScalaSheet"
    contents = new SpreadSheet(100, 26)
  }
}
