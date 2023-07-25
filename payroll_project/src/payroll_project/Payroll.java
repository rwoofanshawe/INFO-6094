package payroll_project;
import java.util.*;

public class Payroll {	
	
	/* --- DECLARE VARIABLES --- */
	public static ArrayList<Employee> arrayEmployee = new ArrayList<Employee>(); // Employee class for array type
	public static String name = "";
	public static int empID = 0;
	public static int yearOfBirth = 0;
	public static int employeeType = 0;
	public static double employeeHoursWorked = 0.0;
	public static double employeeBonus = 0.0;
	public static double employeeRate = 0.0;
	
	public static String opt = "";
	
	public static void main(String[] args) {
				
		/* --- SCANNER --- */
		Scanner input = new Scanner(System.in);
		
		/* --- INPUT LOOP --- */
		do {
			System.out.println("==== INPUT ====");
			
			System.out.print("Enter Name: ");
			name = input.nextLine();
			
			System.out.print("Enter Employee ID: ");
			empID = Integer.parseInt(input.nextLine());
			
			System.out.print("Enter Year of Birth: ");
			yearOfBirth = Integer.parseInt(input.nextLine());
			
			System.out.print("Enter Work Type [1 - PartTime / 2 - FullTime]: ");
			employeeType = Integer.parseInt(input.nextLine());
			
			if (employeeType == 1) { // Part Time				
				
				System.out.print("Enter Hours Worked: ");
				employeeHoursWorked = Double.parseDouble(input.nextLine());
				
				System.out.print("Enter Rate of Pay: ");
				employeeRate = Double.parseDouble(input.nextLine());
				
				PartTime empPT1 = new PartTime();
				
				// using constructors
				empPT1.setName(name);
				empPT1.setEmpID(empID);
				empPT1.setWorkType("Part-Time");
				empPT1.setyearOfBirth(yearOfBirth);
				empPT1.setWage(empPT1.caclEarnings(employeeHoursWorked, employeeRate));
				empPT1.setWageAfterTax(empPT1.caclIncomeTax(empPT1.getWage()));
				
				arrayEmployee.add(empPT1);
				
			} else if (employeeType == 2) { // Full Time
				
				System.out.print("Enter Bonus: ");
				employeeBonus = Double.parseDouble(input.nextLine());
				
				FullTime empFT1 = new FullTime();
				
				// using constructors
				empFT1.setName(name);
				empFT1.setEmpID(empID);
				empFT1.setWorkType("Full-Time");
				empFT1.setyearOfBirth(yearOfBirth);
				empFT1.setWage(empFT1.caclEarnings(employeeBonus));
				empFT1.setWageAfterTax(empFT1.caclIncomeTax(empFT1.getWage()));
				
				arrayEmployee.add(empFT1);
				
			} else {
				// If user input is not a valid option, terminate the program
				System.out.print("Invalid option. Program Exited.");
				System.exit(0);
			}
			
			System.out.print("Continue? [N - No / Y - Yes]: ");
			opt = input.nextLine();	
			
		} while (opt.equals("Y"));
		
		/* --- OUTPUT LOOP --- */
		int ctrFullTime = 0, ctrPartTime = 0;
		double totalWages = 0, totalWagesAfterTax = 0;
		System.out.println("==== OUTPUT ====");
		for (int x = 0; x < arrayEmployee.size(); x++) {
			
			System.out.println((x + 1) + ". " + arrayEmployee.get(x).getName() + ", " + arrayEmployee.get(x).getEmpID() + ", " + arrayEmployee.get(x).getWorkType() + ", $" + arrayEmployee.get(x).getWage() + ", $" + arrayEmployee.get(x).getWageAfterTax());
			
			// count total employee by work type
			if(arrayEmployee.get(x).getWorkType().equals("Part-Time"))
				ctrPartTime+=1;
			else
				ctrFullTime+=1;
			
			// count total wages before and after tax by counter
			totalWages+=arrayEmployee.get(x).getWage();
			totalWagesAfterTax+=arrayEmployee.get(x).getWageAfterTax();
		}
		
		/* --- OUTPUT TOTALS --- */
		System.out.println("Total Employees: #" + arrayEmployee.size());
		System.out.println("Work types: (#" + ctrPartTime + ") Part-Time, (#" + ctrFullTime + ") Full-Time");
		System.out.println("Total Wages Before Tax: $" + totalWages);
		System.out.println("Total Wages After Tax: $" + totalWagesAfterTax);

		/* --- CLOSE CONNECTIONS --- */
		input.close(); // close scanner
		System.exit(0); // terminate program
	}
}
