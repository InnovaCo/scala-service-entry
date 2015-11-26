package eu.inn.servicecontrol

import scala.io.StdIn

class ConsoleIO extends api.ConsoleIO {
  def inputIterator(): Iterator[Option[String]] = new Iterator[Option[String]] {
    var eof = false
    override def hasNext: Boolean = !eof
    override def next(): Option[String] = {
      val s = StdIn.readLine()
      if (s == null) {
        eof = true
        None
      } else {
        Some(s.trim)
      }
    }
  }

  def write(o: Any) = print(o)
  def writeln(o: Any) = println(o)
  def writeln() = println()
}

trait ConsoleIOComponent extends api.ConsoleIOComponent {
  val consoleIO = new ConsoleIO
}
