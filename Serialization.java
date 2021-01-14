package com.revature.day03.employee;
import java.io.*;
import java.util.Scanner;

public class Serialization {
	public static void main(String args[]) {
		System.out.println("Serialize...");
		System.out.println("How many employees would you like to add to the system: ");
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		Employee [] emp1 = new Employee[x];
		Employee [] emp2 = new Employee[x];
		//System.out.println(emp1.length + ", " + emp2.length);
		String name = "";
		String role = "";
		
//				Object serialization
		try {
			FileOutputStream fos = new FileOutputStream("serial.dat"); //create a FOS object, byte out transfer
			ObjectOutputStream oos = new ObjectOutputStream(fos); //create OOS object, decorator for FOS, object transfer
			
			for (int i = 0; i < x; i++) {
				System.out.println("Name: ");
				name = scan.next();
				System.out.println("Role: ");
				role = scan.next();
				emp1[i] = new Employee(name, role);
				System.out.println(emp1[i].toString());
				//FileOutputStream fos = new FileOutputStream("serial.dat");
				//ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(emp1[i]); //write the object to the OOS
				oos.flush(); //cleans out the buffer, cleaning up by forcing all bytes to be written out
			}
			oos.close(); // close the stream channel
		}
		catch(Exception e) {
			System.out.println("Exception during serialization: " + e);
			System.exit(0);
		}finally {
			scan.close();
		}
		

		
		// Object deserialization
		System.out.println("\nDeserialize...");
		try {
			FileInputStream fis = new FileInputStream("serial.dat"); //create a FIS object, byte input reader
			ObjectInputStream ois = new ObjectInputStream(fis); //create OIS object, decorator for FIS, object input reader
			for (int i = 0; i < x; i++) {
				emp2[i] = (Employee)ois.readObject();
				System.out.println(emp2[i].toString());
			}
			ois.close(); // close the stream channel
		}
		catch(Exception e) {
			System.out.println("Exception during deserialization: " + e);
			System.exit(0);
		}
	}
}