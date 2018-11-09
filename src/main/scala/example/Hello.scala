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

  val listItems = List("Scala","Java","Ruby")
  for(item <- listItems) println("item = " + item)
  for(item <- listItems if item.length > 4) println("item = " + item)
  val resultList = for(item <- listItems) yield "I use " + item
  println(resultList)
  // def 関数名[方パラメーター](引数名:型):戻り値 = 関数本体
  def add(x:Int,y:Int) :Int = x+ y
  println(add(1,2))
  def p(x:Any) = println(x)
  p("aaaaa")

  val func = (x:Int,y:Int) => x + y
  val func2 :(Int,Int) => Int = (x:Int,y:Int) => x + y
  func(1,3)
  // 関数を引数にとる
  def calc(f:(Int,Int) => Int,num:Int) :Int = f(num,num)
  var fxy = calc((x,y) => x+ y,10)
  p(fxy)
  p(calc(add,10))
  // 高階関数/メソッド
  def getFunc(str:String) : (Int,Int) => String = (x:Int,y:Int) => str + (x + y)
  var f = getFunc("results") // 関数をもらう
  p(f(1,2))
  p(getFunc("hoge")(2,3))
}

trait Greeting {
  lazy val greeting: String = "hello"
}

