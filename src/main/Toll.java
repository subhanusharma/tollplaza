package main;

import java.util.ArrayList;
import java.util.Scanner;
import tollplaza.daos.*;
import tollplaza.pojos.*;

public class Toll {
	public static void clearConsole() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}

	public static int selectBooth() {
		System.out.println("Select the Toll  Booth: ");
		Scanner sc = new Scanner(System.in);
		ArrayList<TollBooth> tb = TollBoothDao.findAll();
		System.out.println("Toll Id	Toll No	Location	Handler	Highway");

		for (int i = 0; i < tb.size(); i++) {
			System.out.println(tb.get(i).getTbId() + "	" + tb.get(i).getTbNo() + "	" + tb.get(i).getTbLocation()
					+ "		" + tb.get(i).getTbHandler() + "	" + tb.get(i).getHighway());
		}

		System.out.println("Enter the Toll ID of selected the Toll Booth: ");
		int tollId = sc.nextInt();
		sc.nextLine();
		return tollId;
	}

	public static void main(String agrs[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			Toll.clearConsole();
			System.out.println("				WELCOME TO TOLL PLAZA SYSTEM						");

			System.out.println("Enter 1 for Vehical Entry/Toll Tax Collection");
			System.out.println("Enter 2 to Show Tax Collection of particular Booth");
			System.out.println("Enter 3 to Calculate Total Tax Collectiob of all booth");
			int sw = sc.nextInt();
			sc.nextLine();

			Toll.clearConsole();

			switch (sw) {
			case 1: {
				int tollId = Toll.selectBooth();
				while (true) {
					Vehical v = new Vehical();
					System.out.println("Select Vehical Type:");
					ArrayList<VehicalType> vtt = VehicalTypeDao.findAll();
					System.out.println("Sr.No." + "	" + "Vehical Type");
					for (int i = 0; i < vtt.size(); i++) {
						System.out.println(vtt.get(i).getVtId() + "	" + vtt.get(i).getVtName());
					}

					System.out.println("Enter Sr.No. of Vehical type.:");
					int vt = sc.nextInt();
					sc.nextLine();
					v.setVtId(vt);
					System.out.println("Enter Vehical Registration No.:");
					String regNo = sc.nextLine();
					v.setRegNo(regNo);
					Toll.clearConsole();
					System.out.print("Tax to be collected:");
					System.out.println(VehicalTypeDao.find(vt).getVtTax());
					v.setTaxCollected(VehicalTypeDao.find(vt).getVtTax());
					v.setTbId(tollId);
					VehicalDao.create(v);
					System.out.println("Entry Added to Database");
					System.out.println("Do you want to exit Main Menu(Y/N):");
					Scanner sc2 = new Scanner(System.in);
					String qwerty = sc2.nextLine();
					if (qwerty.trim().equalsIgnoreCase("y"))
						break;

				}

			}

				break;
			case 2: {
				Toll.clearConsole();
				int tollId = Toll.selectBooth();
				System.out.print("Tax Collected from toll " + tollId + " is: ");
				System.out.println(VehicalDao.findTotalBoothTax(tollId) + " rs");

			}

				break;

			case 3: {
				Toll.clearConsole();
				System.out.println("Enter operator password:(password)");
				String password = (new Scanner(System.in).nextLine());
				if (password.trim().equals("password")) {
					System.out.print("Total Tax Collected from all toll booths:");
					System.out.println(VehicalDao.findGrandTotalTax() + " rs");
				} else {
					System.out.println("Incoorect Password");
				}

			}

				break;

			default:
				System.out.println("Incorrect Input");
				break;
			}
			System.out.println("Do you want to exit Application(Y/N):");
			Scanner sc2 = new Scanner(System.in);
			String qwerty = sc2.nextLine();
			if (qwerty.trim().equalsIgnoreCase("y"))
				break;

		}
	}

}
