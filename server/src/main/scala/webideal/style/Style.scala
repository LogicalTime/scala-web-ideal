package webideal
package style

import scalacss.mutable.StyleSheet
import scalacss.Attr
import scalacss.Transform
import scalacss.CanIUse
import scalacss.CanIUse2
import scalacss.Literal

trait Style { this: StyleSheet.Base =>
  def name: String
  
  def path: String = Style.baseDir + '/' + name + ".css"
  
  // Fills for things not in ScalaCSS
  val appearance = Attr.real("appearance", Transform keys CanIUse.appearance)
  val fontSmooth = Attr.real("font-smoothing", Transform keys Style.fontSmoothUse)
  object antialiased extends Literal("antialiased")
}
object Style {
  // TODO: make this a config please
  val baseDir = "stylesheets"
  
  val fontSmoothUse: CanIUse.Subject = {
    import CanIUse.Agent._
    import CanIUse.Support._
    Map(
      AndroidBrowser    -> Set(Unsupported),
      AndroidChrome     -> Set(Unsupported),
      AndroidFirefox    -> Set(Unsupported),
      AndroidUC         -> Set(Unsupported),
      BlackberryBrowser -> Set(Unsupported),
      Chrome            -> Set(FullX),
      Firefox           -> Set(FullX),
      IE                -> Set(Unsupported),
      IEMobile          -> Set(Unsupported),
      IOSSafari         -> Set(Unsupported),
      Opera             -> Set(FullX),
      OperaMini         -> Set(Unsupported),
      OperaMobile       -> Set(Unsupported),
      Safari            -> Set(FullX)
    )
  }
}