package cc.chauncy.hoi4

object HelloWorld {
	def main(args: Array[String]): Unit = {
		val f = GroovyIOTools.readAll("res/states/2-Italy.txt")
		println(f)
	}
}