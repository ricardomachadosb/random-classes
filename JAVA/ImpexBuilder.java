package testee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ImpexBuilder {
	public static void main(String[] args) throws IOException {
		
		//updateUsers();
		createDiscounts();
		createDiscountsRows();
	}
	
	private static void createDiscountsRows() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/ramachado/Desktop/private2/private2/discountRow.txt"));
		File fileToWrite = new File("C:/Users/ramachado/Desktop/private2/private2/discountRow.impex");
		
		if (!fileToWrite.exists()) {
			fileToWrite.createNewFile();
		}
		
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    
		    sb.append("INSERT_UPDATE DiscountRow;starttime[dateformat=dd.MM.yyyy HH:mm:ss];endtime[dateformat=dd.MM.yyyy HH:mm:ss];ug(code)[unique=true];$product[unique=true];discount(code)");
	        sb.append(System.lineSeparator());
		    
		    while (line != null) {
		    	//line = line+",00";
		    	line = line.replace(",", ".");
		    	String[] text = line.split("-");
		    	while(text[1].length() < 7){
		    		text[1] = "0"+text[1];
		    	}
		        sb.append(";22.06.2016 17:00:00;25.06.2016 09:00:00;privatediscountgroup;"+text[0].replace("A", "")+"U;discount4P-"+text[1]+"BRL");
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    
			FileWriter fw = new FileWriter(fileToWrite.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(everything);
			bw.close();
		} finally {
		    br.close();
		}
	}
	
	private static void createDiscounts() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/ramachado/Desktop/private2/private2/discount.txt"));
		File fileToWrite = new File("C:/Users/ramachado/Desktop/private2/private2/discount.impex");
		
		if (!fileToWrite.exists()) {
			fileToWrite.createNewFile();
		}
		
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    
		    sb.append("INSERT_UPDATE Discount;code[unique=true];currency(isocode);global;priority;value");
	        sb.append(System.lineSeparator());
		    
		    while (line != null) {
		    	//line = line+",00";
		    	String text = line.replace(",", ".");
		    	while(text.length() < 7){
		    		text = "0"+text;
		    	}
		        sb.append(";discount4P-"+text+"BRL;$defaultCurrency;false;1;"+line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    
			FileWriter fw = new FileWriter(fileToWrite.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(everything);
			bw.close();
		} finally {
		    br.close();
		}
	}
	
	/**
	 * @throws IOException
	 */
	private static void updateUsers() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/ramachado/Desktop/private2/private2/email.txt"));
		File fileToWrite = new File("C:/Users/ramachado/Desktop/private2/private2/email.impex");
		
		if (!fileToWrite.exists()) {
			fileToWrite.createNewFile();
		}
		
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();
		    
		    sb.append("UPDATE Customer;uid[unique=true];groups(uid)[mode=replace]");
	        sb.append(System.lineSeparator());
		    
		    while (line != null) {
		        sb.append(";#arzbr_"+line+";customergroup,arezzoprivategroup");
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    
			FileWriter fw = new FileWriter(fileToWrite.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(everything);
			bw.close();
		} finally {
		    br.close();
		}
	}
}
