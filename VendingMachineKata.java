import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VendingMachineKata {
	static double coinTotal = 0;
	static String input;
		
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
				case "nickel": acceptCoins(0.05);
				break;
				case "dime": acceptCoins(0.10);
				break;
				case "quarter": acceptCoins(0.25);
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
	
	static void selectProduct(String product)
	{
		switch(product)
		{
			case "cola":
				if (coinTotal >= 1.00)
				{
					coinTotal -= 1.00;
					System.out.println("cola dispensed, THANK YOU");
					makeChange();
				}	
				else
					System.out.println("$1.00");			
				break;
			case "chips":
				if (coinTotal >= 0.50)
				{
					coinTotal -= 0.50;
					System.out.println("chips dispensed, THANK YOU");
					makeChange();
				}	
				else
					System.out.println("$0.50");			
				break;				
			case "candy":
				if (coinTotal >= 0.65)
				{
					coinTotal -= 0.65;
					System.out.println("candy dispensed, THANK YOU");
					makeChange();
				}	
				else
					System.out.println("$0.65");			
				break;
		}
	}
	
	static void makeChange()
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
	
	void soldOut()
	{
		System.out.println("SOLD OUT");
		System.out.println(coinTotal);
	}
	
	void exactChangeOnly()
	{
		System.out.println("EXACT CHANGE ONLY");
	}

}
