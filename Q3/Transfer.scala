object Transfer extends App{

    var acc1= new Account("111001v",100012,1700.29);
    var acc2= new Account("111002v",100013,1878.56);
    var acc3= new Account("111003v",100014,7000.36);

    var bank:List[Account] = List(acc1,acc2,acc3)

    acc1.transfer(acc3,500)
	
	println("___Money Transfer___");
	println(acc1);
	println(acc3);

}

class Account(id:String, n:Int, b:Double){

    val nic:String = id
    val acnumber:Int = n
    var balance:Double = b

    def withdraw(x:Double) = if(x<=balance)this.balance = this.balance - x else println("Insufficent balance to withdraw money!!")

    def deposit(x:Double) = this.balance = this.balance + x

    def transfer(ac:Account,amount:Double) = {
        this.withdraw(amount)
        ac.deposit(amount)
    }

    override def toString = "["+nic+":"+acnumber+":"+balance+"]"

}