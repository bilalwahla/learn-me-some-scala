import java.awt._

val rect = new Rectangle(5, 10, 20, 30)
rect.translate(10, 20)
rect

trait RectangleLike  {
  def setFrame(x: Double, y: Double, w: Double, h: Double): Unit
  def getX: Double
  def getY: Double
  def getWidth: Double
  def getHeight: Double
  def translate(dx: Double, dy: Double): Unit = {
    setFrame(getX + dx, getY + dy, getWidth, getHeight)
  }
}

val egg = new geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
egg.translate(10, 20) // translates isn't available out of the box so we mixed it in
egg.x;
egg.y;