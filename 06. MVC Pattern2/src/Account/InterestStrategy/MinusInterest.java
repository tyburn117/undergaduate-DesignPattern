package Account.InterestStrategy;

public class MinusInterest implements InterestStrategy{

	@Override
	public int calculateInterest(int money, int afterMonth) {
		// TODO Auto-generated method stub
		return (int) (money*(afterMonth+1)*0.2);
	}

}
