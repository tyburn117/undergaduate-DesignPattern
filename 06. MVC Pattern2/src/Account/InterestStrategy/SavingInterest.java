package Account.InterestStrategy;

public class SavingInterest implements InterestStrategy{

	@Override
	public int calculateInterest(int money, int afterMonth) {
		// TODO Auto-generated method stub
		return money*(afterMonth+1);
	}
}
