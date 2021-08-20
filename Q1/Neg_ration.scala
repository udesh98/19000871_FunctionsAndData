object Neg_ration extends App{
	val r1= new Rational(2,3)
	val x=r1.neg(r1)
	println(x)
}

class Rational(m:Int,d:Int){
	def numer = m
	def denom = d

	def neg(r:Rational)=new Rational(-this.numer,this.denom){

	}

	override def toString= numer+"/"+denom
}