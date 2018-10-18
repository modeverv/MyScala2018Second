package example

object Hello extends Greeting with App {
  println(greeting)
  println("aaaaaa")
  // var と val
  var num:Int = 10
  num = 20
  var n1,n2,n3 = 1
  val msg = "日本語でOK"
  // valは再代入を許さない
  // 基本的にvalを使っていくべし
  //配列
  val a1 = new Array[Int](10)
  a1(1) = 2
  // リスト(イミュータブル)
  val list1 = List("Scala")
  println(list1)
  // マップ(イミュータブル)
  val map1 = Map[String,Int]("S"-> 1,"B"->3)
  // タプル
  val t3 = ("S","B",1)
  println(t3._2)

  lazy val lazyX = {println("lazy int val");num + 1}

  var x = 1
  var result = if(x == 0) {
    println("x == 0")
  } else if (x == 1) {
    println("x == 1")
  } else {
    println("x else")
  }

}

trait Greeting {
  lazy val greeting: String = "hello"
}

