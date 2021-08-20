object Sub_ration extends App{
	val r1= new Rational(3,4)
	val r2= new Rational(5,8)
	val r3= new Rational(2,7)
	val x=r1.sub(r2).sub(r3)
	println (x)
}

class Rational(m:Int,d:Int){
	def numer=m
	def denom = d

	def sub(r:Rational)=new Rational((this.numer*r.denom) -(this.denom*r.numer),(this.denom*r.denom)){

	}

	override def toString= numer+"/"+denom
}