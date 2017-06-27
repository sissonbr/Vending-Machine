
public class VendingMachine {
	private static double coinTotal = 0;
	final static double nickel = 0.05;
	final static double dime = 0.10;
	final static double quarter = 0.25;
	private final static double colaPrice = 1.00;
	private final static double chipsPrice = 0.50;
	private final static double candyPrice = 0.65;

	void VendingMachine(){}
	
	static void acceptCoins(double coin)
	{
		coinTotal += coin;
	}
	
	static void selectProduct(String product)
	{
		switch(product)
		{
			case "cola":
				dispenseProduct(colaPrice, "cola");			
				break;
			case "chips":
				dispenseProduct(chipsPrice, "chips");			
				break;				
			case "candy":
				dispenseProduct(candyPrice, "candy");			
				break;
		}
	}
	
	private static void dispenseProduct(double price, String productName)
	{
		if (coinTotal >= price)
		{
			coinTotal -= price;
			System.out.println(productName + " dispensed, THANK YOU");
			makeChange();
		}	
		else
			System.out.println("$"+price);			
	}
	
		private static void makeChange()
	{
		if (coinTotal > 0)
		{
			System.out.println("Coin return amount: " + coinTotal);
			coinTotal = 0;
		}
	}
	
	static void returnCoins()
	{
		System.out.println("Coin return amount: " + coinTotal);
		coinTotal = 0;
	}
	
	private void soldOut()
	{
		System.out.println("SOLD OUT");
		System.out.println(coinTotal);
	}
	
	private void exactChangeOnly()
	{
		System.out.println("EXACT CHANGE ONLY");
	}

}
