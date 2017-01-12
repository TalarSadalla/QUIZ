package sda.pl.OperacjeNaPlikach;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileOperations {

	public static void main(String[] args) throws IOException {
		// File file = new File("test.txt");
		File file1 = new File("obiekty.txt");
		File file2 = new File("obiekty2.txt");

		// writeToFile(file, "Talarek");
		// readFromFile(file);

		// List<String> names = namesFromFile(file);
		// readNames(namesFromFile(file));

		// String someText = "Talar Sadalla";
		// String[] split = someText.split(" ");
		// System.out.println("My name is: " + split[0]);
		// System.out.println("My lastname is: " + split[1]);
		// Map<String, String> map = new HashMap<>();
		// map.put(split[0], split[1]);
		// System.out.println(map.get("Talar"));

		// Map<String, Integer> map1 = dataFromFileToMap(file);
		// readDataFromMap(dataFromFileToMap(file));
		// readUsersfromMap(usersFromFileToMap(file1));

		Map<String, User> UserMap = userListFromFileToMap(Arrays.asList(file1, file2));
		readUsersfromMap(UserMap);
	}

	public static List<String> namesFromFile(File file) throws FileNotFoundException {
		ArrayList<String> listaImion = new ArrayList();
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			listaImion.add(scanner.nextLine());
		}
		scanner.close();
		return listaImion;
	}

	public static Map<String, Integer> dataFromFileToMap(File file) throws FileNotFoundException {
		Map<String, Integer> map1 = new HashMap<>();

		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			String someText = scanner.nextLine();
			String[] split = someText.split(" ", 2);
			map1.put(split[0], new Integer(split[1]));
		}
		scanner.close();
		return map1;
	}

	public static Map<String, User> userListFromFileToMap(List<File> files) throws FileNotFoundException {
		Map<String, User> mapAll = new HashMap<>();
		files.forEach(e -> {
			try {
				mapAll.putAll(usersFromFileToMap(e));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		return mapAll;
	}

	public static Map<String, User> usersFromFileToMap(File file) throws FileNotFoundException {
		Map<String, User> map1 = new HashMap<>();
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			User user = new User();
			String someText = scanner.nextLine();
			String[] split = someText.split(" ");
			user.setFirstName(split[1]);
			user.setLastName(split[2]);
			user.setPhoneNumber(split[3]);
			map1.put(split[0], user);
		}
		scanner.close();
		return map1;
	}

	public static void readNames(List<String> names) {
		names.forEach(e -> System.out.println(e));
	}

	public static void readDataFromMap(Map<String, Integer> map) {
		map.forEach((k, v) -> {
			System.out.println("Key: " + k + ", value: " + v);
		});
	}

	public static void readUsersfromMap(Map<String, User> map) {
		map.forEach((k, user) -> {
			System.out.println("Key: " + k + user);
		});
	}

	public static void readFromFile(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	}

	public static void writeToFile(File file, String message) throws IOException {
		try (FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(message);
		}
	}

}
