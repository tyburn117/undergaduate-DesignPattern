import java.util.LinkedList;
import java.util.Queue;

class Agent{
	private Queue<Order> m_ordersQueue;
	
	public Agent(){
		m_ordersQueue = new LinkedList<Order>();
	}
	public void placeOrder(Order order){
		order.execute();
		m_ordersQueue.add(order);
	}
	public void sell(){
		m_ordersQueue.remove();
	}
}
interface Order{
	public void execute();
}

class StockTrade{
	public void buy(){
		System.out.println("주식을 매수하였습니다");
	}
	public void sell(){
		System.out.println("주식을 매도하였습니다");
	}
}

class BuyStockOrder implements Order{
	private StockTrade stock;
	public BuyStockOrder(StockTrade stock){
		this.stock = stock;
	}
	@Override
	public void execute() {
		stock.buy();
	}
}
class SellStockOrder implements Order{
	private StockTrade stock;
	public SellStockOrder(StockTrade stock){
		this.stock = stock;
	}
	@Override
	public void execute() {
		stock.sell();
	}
}


public class Main {

	public static void main(String[] args) {
		StockTrade stock = new StockTrade();
		BuyStockOrder bso = new BuyStockOrder(stock);
		SellStockOrder sso = new SellStockOrder(stock);
		Agent agent = new Agent();
		agent.placeOrder(bso);
		agent.placeOrder(sso);
	}

}
