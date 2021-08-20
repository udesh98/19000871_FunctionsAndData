object Acc_List extends App{

    	var acc1= new Account("111001v",100010,4512.20);
	var acc2= new Account("111002v",100011,1478.56);
	var acc3= new Account("111003v",100012,-145.23);
	var acc4= new Account("111004v",100013,74582.12);
	var acc5= new Account("111005v",100014,-1500.00);
	var acc6= new Account("111006v",100015,3578.45);
	var acc7= new Account("111007v",100016,1750.20);
	var acc8= new Account("111008v",100017,-1000.50);
	var acc9= new Account("111009v",100018,6314.10);
	var acc10= new Account("111010v",100019,125.60);

    var bank:List[Account] = List(acc1,acc2,acc3,acc4,acc5,acc6,acc7,acc8,acc9,acc10)

    print("Accounts with negative balances : \n");
    val overdraft = (b:List[Account]) => b.filter(x=>x.balance < 0)
    var overdraft_list = overdraft(bank)
    overdraft_list.foreach(x=>println("["+x.acnumber+":"+x.balance+"]"))

    val sum = (b:List[Account]) => b.reduce((x,y)=>new Account("null",111111,x.balance+y.balance))
    var sum_of_balance = sum(bank)
    println("\n" + "Sum of all account balances : "+sum_of_balance.balance)

    print("\nAccount balances with interest : \n")
    val interest = (b:List[Account]) => b.map(x=>new Account(x.nic,x.acnumber,(if(x.balance>=0) x.balance*1.05d else x.balance*1.10d)))
    var interest_list = interest(bank)
    interest_list.foreach(x=>println("["+x.acnumber+":"+x.balance+"]"))

}

class Account(id:String, n:Int, b:Double){

    val nic:String = id
    val acnumber:Int = n
    var balance:Double = b

    def withdraw(x:Double) = this.balance = this.balance - x

    def deposit(x:Double) = this.balance = this.balance + x

    def transfer(ac:Account,amount:Double) = {
        this.withdraw(amount)
        ac.deposit(amount)
    }

    override def toString = "["+nic+":"+acnumber+":"+balance+"]"

}