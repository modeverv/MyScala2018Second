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

  def showMessage(args: String*) = for(arg <- args) println(arg)
  showMessage("aaa","bbb","ccc")
  // 教科書どおりに動かぬ。。いらんか。。
  // def showM2(args: _*) = for(arg <- args) println(arg)
  // showM2(Array("xxxx","yyyy"))
  def showM3(a:String = "hello") = println(a)
  showM3()
  showM3("fefdsafewafwdafwafea")
  var func20181127:(Int,Int) => Int = (x:Int,y:Int) => x+ y
  var x20181127 = func20181127(1,2)
  println(x20181127)
  def add1127(x:Int, y:Int):Int = x + y
  var f1127_1 = add1127 _
  var f1127_2 = f1127_1(_:Int,5)
  println(f1127_2(3))

  // クロージャ
  def counter() = {
    var count = 0
    () => {
      count += 1
      count
    }
  }

  var c1127_3 = counter()
  println(c1127_3())
  println(c1127_3())
  println(c1127_3())
  println(c1127_3())
  println(c1127_3())

  def sum(a:Int,b:Int,c:Int) = a + b + c
  var sumObj = sum _
  // 遅延評価
  var c20181128 = 0
  def myWhile(conditional: => Boolean)(f: => Unit) {
    println("myWhile")
    println(f)
    println(c20181128)
    println(c20181128 < 3)
    if(conditional){
      f
      myWhile(conditional)(f)
    }
  }
  var b201821129 = {
    println("c20181128=" + c20181128)
    Hello.c20181128 += 1
    //c20181128 += 1
    println("c20181128=" + c20181128)
  }
  // 無限ループになる。。。 スコープがわからぬ。
  // Scalaコンソールでは行けたのだけれど
  // myWhile(c20181128 < 3)(b201821129)
  var pg = new Programamer
  pg.coding()
  pg.language = "Java"
  pg.coding()

  // Option型
  val m = Map("Scala" -> 1,"Java" -> 2)
  println(m.get("Scala"))
  println(m.get("Scala").get)
  println(m.get("Ruby"))
  println(m.get("Ruby").getOrElse("nothing"))

  def testMatch(opt:Option[Int]) ={
    opt match {
        case Some(n) => println(n)
        case None => println("Nonnnne")
    }
  }
  testMatch(Some(10))
  testMatch(None)
}

trait Greeting {
  lazy val greeting: String = "hello"
}
class Programamer(var language: String = "Scala") {
  println("here is initialize code " + language)

  // var language = "Scala"
  def coding() = println("I'm coding with " + language)
}
class P2(_language: String = "Scala") {
  println("here is initialize code " + language)
  require(_language != null) // 制約
  val language = _language
  def coding() = println("I'm coding with " + language)
}

class Sample {
  def add(x:Int,y:Int) = x + y
  def add(x:Double,y:Double) = x + y
  def add(x:Int,y:Int,z:Int) = x + y + z
}

// シングルトンオプジェクト
object SampleUtil {
  def hello() = println("hellooooo")
}
