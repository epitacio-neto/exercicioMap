package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter file full patch: ");
		String filePath = "C:\\Users\\epita\\OneDrive\\Área de Trabalho\\JAVA WS\\S19FixMap\\files\\in.txt";
		
		Map<String, Integer> candidates = new HashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
			
			String lines = br.readLine();
			while (lines != null) {
				String[] fields = lines.split(",");
				String name = fields[0];
				int vote = Integer.parseInt(fields[1]);
				
				if (candidates.containsKey(name)) {
					int votesComputed = candidates.get(name);
					candidates.put(name, vote + votesComputed);
				} else {
					candidates.put(name, vote);
				}
				
				lines = br.readLine();
			}
			
			for (String key : candidates.keySet()) {
				System.out.println(key + ": " + candidates.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}
	
//	static <T extends Comparable<? super T>> T compareToList(T o, List<T> obj) {
//		return o.compareTo(obj);
//	}

}
