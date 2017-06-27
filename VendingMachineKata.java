import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VendingMachineKata {
	private static double coinTotal = 0;
	private static String input;
	private final static double nickel = 0.05;
	private final static double dime = 0.10;
	private final static double quarter = 0.25;
	private final static double colaPrice = 1.00;
	private final static double chipsPrice = 0.50;
	private final static double candyPrice = 0.65;
		
	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		while(true)
		{
			System.out.print("INSERT COIN ");
			try {
				input = bufferedReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			switch (input)
			{
				case "nickel": acceptCoins(nickel);
				break;
				case "dime": acceptCoins(dime);
				break;
				case "quarter": acceptCoins(quarter);
				break;
				case "cola": selectProduct("cola");
				break;
				case "chips": selectProduct("chips");
				break;
				case "candy": selectProduct("candy");
				break;
				case "return": returnCoins();
				break;
			}
		}

	}

	private static void acceptCoins(double coin)
	{
		coinTotal += coin;
	}
	
	private static void selectProduct(String product)
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
	
	private static void returnCoins()
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
