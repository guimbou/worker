package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Worker worker = new Worker();
		
		System.out.print("Enter department's name: ");
		worker.setDepartment(new Department(in.nextLine()));
		
		System.out.println("Enter worker date: ");
		
		System.out.print("Name: ");
		worker.setName(in.nextLine());
		
		System.out.print("Level: ");
		worker.setLevel(WorkerLevel.valueOf(in.nextLine()));
		
		System.out.print("Base Salary: ");
		worker.setBaseSalary(in.nextDouble());
		
		System.out.println("How many contracts to this worker?");
		int n = in.nextInt();
		
		for(int i=0; i<n; i++) {
			HourContract hourContract = new HourContract();
			
			System.out.println("Enter contract #" + (i+1) + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			hourContract.setDate(sdf.parse(in.next()));
			
			System.out.print("Value per hour: ");
			hourContract.setValuePerHour(in.nextDouble());
			
			System.out.print("Duration (hours): ");
			hourContract.setHours(in.nextInt());
			
			worker.addContract(hourContract);
		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = in.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3, 7));
		System.out.println("\nName: "
							+ worker.getName()
							+ "\nDepartment: "
							+ worker.getDepartment().getName()
							+ "\nIncome for "
							+ monthAndYear
							+ ": "
							+ String.format("%.2f", worker.income(year, month)));
		
		in.close();
	}

}
