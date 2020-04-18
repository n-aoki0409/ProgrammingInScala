package org.stairwaybook.scells

import scala.swing.event.TableUpdated
import scala.swing.{
  Alignment,
  Color,
  Component,
  Label,
  ListView,
  ScrollPane,
  Table,
  TextField
}

class SpreadSheet(val height: Int, val width: Int) extends ScrollPane {
  val cellModel = new Model(height, width)
  import cellModel._
  val table = new Table(height, width) {
    rowHeight = 25
    autoResizeMode = Table.AutoResizeMode.Off
    showGrid = true
    gridColor = new Color(150, 150, 150)
    override def rendererComponent(isSelected: Boolean,
                                   hasFocus: Boolean,
                                   row: Int,
                                   column: Int): Component =
      if (hasFocus) new TextField(userData(row, column))
      else
        new Label(cells(row)(column).toString) {
          xAlignment = Alignment.Right
        }

    def userData(row: Int, column: Int): String = {
      val v = this(row, column)
      if (v == null) "" else v.toString
    }

    reactions += {
      case TableUpdated(_, rows, column) =>
        for (row <- rows)
          cells(row)(column).formula =
            FormulaParsers.parse(userData(row, column))

      case ValueChanged(cell) => updateCell(cell.row, cell.column)
    }
    for (row <- cells; cell <- row) listenTo(cell)
  }
  val rowHeader = new ListView((0 until height) map (_.toString)) {
    fixedCellWidth = 30
    fixedCellHeight = table.rowHeight
  }
  viewportView = table
  rowHeaderView = rowHeader
}
