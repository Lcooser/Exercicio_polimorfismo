package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: " );
			System.out.print("Common, used, or imported (c/u/i)?");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name =  sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Customs fee: ");
				Double customsfee = sc.nextDouble();
				Product pdct = new ImportedProduct(name, price, customsfee);
				list.add(pdct);
			}
			
			if (ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				Product pdct = new UsedProduct(name, price, date);
				list.add(pdct);
			}
			
			if(ch == 'c'){
				Product pdct = new Product(name, price);
				list.add(pdct);
			}
			
		}
		
		System.out.println("Price Tags:");
		for(Product x : list) {
			System.out.println(x.priceTag());
		}
		

	}

}
