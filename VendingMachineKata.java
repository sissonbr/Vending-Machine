import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VendingMachineKata {
	private static String input;
		
	public static void main(String[] args) {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		VendingMachine vm = new VendingMachine();
		
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
				case "nickel": vm.acceptCoins(vm.nickel);
				break;
				case "dime": vm.acceptCoins(vm.dime);
				break;
				case "quarter": vm.acceptCoins(vm.quarter);
				break;
				case "cola": vm.selectProduct("cola");
				break;
				case "chips": vm.selectProduct("chips");
				break;
				case "candy": vm.selectProduct("candy");
				break;
				case "return": vm.returnCoins();
				break;
			}
		}

	}


}
