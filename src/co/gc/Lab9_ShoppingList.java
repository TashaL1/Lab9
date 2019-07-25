package co.gc;
import java.util.ArrayList;
/*
 *  @author Natasha Langston
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab9_ShoppingList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> itemsOrdered = new ArrayList<>();
		ArrayList<Double> itemsPrices = new ArrayList<>();

		
		System.out.println("Welcome to Natasha's Natural Hair Boutique!");
		System.out.println();
		String cont = "yes";
		while (cont.equalsIgnoreCase("yes")) {
			System.out.println("Items\t\t\tPrice ");
			System.out.println("===============================");
			//Display of items and prices
			Map<String, Double> items = new HashMap<>();
			items.put("Leave-In", 13.99);
			items.put("Shampoo", 15.99);
			items.put("Deep Conditioner", 14.59);
			items.put("Satin Pillowcase", 12.99);
			items.put("Wide-Tooth Comb", 3.79);
			items.put("Detangler", 14.09);
			items.put("Hair Gel", 12.99);
			items.put("Diffuser", 6.49);
			System.out.println(displayMenu(items));

			//get user input
			System.out.println();
			System.out.println("Add items to your shopping cart:");
			String userInput = scan.nextLine();
			System.out.println();
			itemsOrdered.add(userInput);
			itemsPrices.add(items.get(userInput));
			System.out.println("Added " + userInput + " to your shopping cart at " + items.get(userInput) + ".");
			System.out.println();
			System.out.println(displayMenu(items));
		
		
			System.out.println("Do you want to add more items? (yes/no)");
			cont = scan.nextLine();
		
			
		}
		System.out.println();
		System.out.println("Here's what you ordered: ");
		System.out.println(displayCart(itemsOrdered, itemsPrices) +"\t");
		System.out.println("The average price per items ordered was $ " + avgPrice(itemsPrices));
		
	
	scan.close();
	System.out.println("Thank you for your purchase!");
	String userInput2 = Validator.getString(scan, "That item doesn't exist.");
	System.out.println(userInput2);
		
	}
	
	public static Double avgPrice(ArrayList <Double> itemsPrices) {
	double sum = 0;//the total price of all items
	int count = 0; //the number of individual items
	for (int i = 0; i < itemsPrices.size(); i++) {
			
			sum += itemsPrices.get(count);
		count++;
		}
		
		System.out.println();

			return sum/count;
	}

	public static String displayCart(ArrayList<String> itemsOrdered, ArrayList<Double> itemsPrices) {
		StringBuilder result = new StringBuilder();
		double price = 0.0;
		int count = 0; //the number of individual items
		
		for (String orderedItem : itemsOrdered) {
			price = itemsPrices.get(count);
			count++;
			result.append((orderedItem)+ "\t$" + price + "\n");
		}		return result.toString();
	}

	public static String displayMenu(Map<String, Double> items) {
		StringBuilder result = new StringBuilder();
		
		for (String key : items.keySet()) {
			result.append(key + " $" + items.get(key) + "\n");
		}
		return result.toString();
		
	}

}
