import scala.annotation.tailrec
import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}

object Main {

  val bakaName: String = "Baka"

  def main(args: Array[String]): Unit = {
    println(bakaName)
    println("Enter your digits")
    calculator()
  }

  @tailrec
  def calculator(): Unit = {
    println("Укажите действие")
    val vvod = readLine()

    if (vvod == "+" || vvod == "-" || vvod == "*" || vvod == "/") {

      println("Введи число 1")
      val x2 = readLine()
      println("Введи число 2")
      val y2 = readLine()

      if (vvod == "/" && y2 == "0") {
        println("чел, на ноль незя")

      } else {
        val x1 = stringToInteger(x2)
        val y1 = stringToInteger(y2)
        val z = {
          for {
            x <- x1
            y <- y1
          } yield {

            if (vvod == "+") {
              summa(x, y)
            } else if (vvod == "-") {
              vychet(x, y)
            } else if (vvod == "*") {
              umnoj(x, y)
            } else if (vvod == "/") {
              delenie(x, y)
            }
          }
        }
        z match {
          case Failure(_) =>
            println("сорян, могу сравнивать ток числа")
            calculator()
          case Success(z: Double) => println(z)
        }
      }
    }
    else {
      println("Ты долбоеб")
      calculator()
    }
  }
  def summa(x: Double, y: Double): Double = {
    x + y
  }

  def vychet(x: Double, y: Double): Double = {
    x - y
  }

  def umnoj(x: Double, y: Double): Double = {
    x * y
  }

  def delenie(x: Double, y: Double): Double = {
    x / y
  }

  def stringToInteger(in: String): Try[Double] = {
    Try(in.toInt)
  }
}

