import java.util.Date;

public class Account {
	private Date createDate;
	private int money;
	private WithdrawStrategy withdrawstrategy;
	
	public Account(){
		money = 0;
		createDate = new Date();
		withdrawstrategy= null;
	}
	
	public Date getCreateDate(){return createDate;}
	public int getMoney(){return money;}
	public void setMoney(int m){money = m;}
	
	public void deposit(int m){
		System.out.println("Deposit!");
	}
	public int getBalance(){
		return money;
	}
	public void withdraw(int money){
		int rtn = withdrawstrategy.withdraw(this.money, money);
		if(rtn == -1){
			System.out.println("Fail");
		}
		else{
			this.money = rtn;
		}
	}
	public void setWithdrawStrategy(WithdrawStrategy strategy){
		this.withdrawstrategy = strategy;
	}
}
