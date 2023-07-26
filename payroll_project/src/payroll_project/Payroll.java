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
	public static double employeeSalary = 0.0;
	public static double employeeBonus = 0.0;
	public static double employeeRate = 0.0;
	
	public static String opt = "";
	
	public static Vehicle employeeVehicle;
	public static String vehicleMake = "";
	public static String vehicleModel = "";
	public static String hasVehicle = "";
	
	public static void main(String[] args) {
				
		/* --- SCANNER --- */
		Scanner input = new Scanner(System.in);
		
		/* --- INPUT LOOP --- */
		do {
			System.out.println("==== INPUT ====");
			
			System.out.print("Enter Name: ");
			name = input.nextLine();
			
	        while (true) {
	            try {
	    			System.out.print("Enter Employee ID: ");
	    			empID = Integer.parseInt(input.nextLine());
	                break; // If the input is valid, exit the loop
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input! Please enter a valid Employee ID. Press Enter key.");
	                input.nextLine();
	            }
	        }				
			
	        while (true) {
	            try {
	                System.out.print("Enter Year of Birth: ");
	                yearOfBirth = Integer.parseInt(input.nextLine());
	                break; // If the input is valid, exit the loop
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input! Please enter a valid Year of Birth. Press Enter key.");
	                input.nextLine();
	            }
	        }					
			
	        while (true) {
	            try {
	    			System.out.print("Enter Work Type [1 - PartTime / 2 - FullTime]: ");
	    			employeeType = Integer.parseInt(input.nextLine());
	                break; // If the input is valid, exit the loop
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input! Please enter a valid Work Type. Press Enter key.");
	                input.nextLine();
	            }
	        }			
			
	        while (true) {
	            System.out.println("Do you have a vehicle? [N - No / Y - Yes]:");
	            hasVehicle = input.nextLine().trim().toUpperCase();

	            if (hasVehicle.equals("Y") || hasVehicle.equals("N")) {
	                break; // If the input is valid ('Y' or 'N'), exit the loop
	            } else {
	                System.out.println("Invalid input! Please enter 'Y' or 'N'. Press Enter key.");
	                input.nextLine();
	            }
	        }
		    
		    if(hasVehicle.equals("Y")) {
			    System.out.println("What is the Vehicle Model?:");
			    vehicleModel = input.nextLine(); //read employee model

			    System.out.println("What is the Vehicle Make?:");
			    vehicleMake = input.nextLine(); //read employee model
			    
			    employeeVehicle = new Vehicle(vehicleModel, vehicleMake);
			    
		    } else {
		    	employeeVehicle = new Vehicle("NA", "NA"); //Vehicle entry not applicable (NA)
		    }
			
			
			if (employeeType == 1) { // Part Time				
				
		        while (true) {
		            try {
		                System.out.print("Enter Hours Worked: ");
		                employeeHoursWorked = Double.parseDouble(input.nextLine());

		                System.out.print("Enter Rate of Pay: ");
		                employeeRate = Double.parseDouble(input.nextLine());

		                // If both inputs are valid, exit the loop
		                break;
		            } catch (NumberFormatException e) {
		                System.out.println("Invalid input! Please enter a valid number. Press Enter.");
		                input.nextLine();
		            }
		        }
				
				PartTime empPT1 = new PartTime();
				
				// using constructors
				empPT1.setName(name);
				empPT1.setEmpID(empID);
				empPT1.setWorkType("Part-Time");
				empPT1.setyearOfBirth(yearOfBirth);
				empPT1.setWage(empPT1.caclEarnings(employeeHoursWorked, employeeRate));
				empPT1.setWageAfterTax(empPT1.caclIncomeTax(empPT1.getWage()));
				
	    		empPT1.setEmployeeVehicle(employeeVehicle);
				
				arrayEmployee.add(empPT1);
				
			} else if (employeeType == 2) { // Full Time

		        while (true) {
		            try {
						System.out.print("Enter Salary: ");
						employeeSalary = Double.parseDouble(input.nextLine());				
						
						System.out.print("Enter Bonus: ");
						employeeBonus = Double.parseDouble(input.nextLine());

		                // If both inputs are valid, exit the loop
		                break;
		            } catch (NumberFormatException e) {
		                System.out.println("Invalid input! Please enter a valid number. Press Enter.");
		                input.nextLine();
		            }
		        }
				
				
				
				FullTime empFT1 = new FullTime();
				
				// using constructors
				empFT1.setName(name);
				empFT1.setEmpID(empID);
				empFT1.setWorkType("Full-Time");
				empFT1.setyearOfBirth(yearOfBirth);
				empFT1.setWage(empFT1.caclEarnings(employeeSalary, employeeBonus));
				empFT1.setWageAfterTax(empFT1.caclIncomeTax(empFT1.getWage()));

		    	empFT1.setEmployeeVehicle(employeeVehicle);
		    	
				arrayEmployee.add(empFT1);
				
			} else {
				// If user input is not a valid option, terminate the program
				System.out.print("Invalid option. Program Exited.");
				System.exit(0);
			}
			
	
			
	        while (true) {
				System.out.print("Continue? [N - No / Y - Yes]: ");
				opt = input.nextLine().toUpperCase();

	            if (opt.equals("Y") || opt.equals("N")) {
	                break; // If the input is valid ('Y' or 'N'), exit the loop
	            } else {
	                System.out.println("Invalid input! Please enter 'Y' or 'N'. Press Enter key.");
	                input.nextLine();
	            }
	        }			
			
			
		} while (opt.equals("Y"));
		
		/* --- OUTPUT LOOP --- */
		int ctrFullTime = 0, ctrPartTime = 0;
		double totalWages = 0, totalWagesAfterTax = 0;
		System.out.println("==== OUTPUT ====");
		for (int x = 0; x < arrayEmployee.size(); x++) {
			
			System.out.println((x + 1) + ". " + arrayEmployee.get(x).getName() + ", " 
											  + arrayEmployee.get(x).getEmpID() + ", " 
					                          + arrayEmployee.get(x).getWorkType() + ", $" + arrayEmployee.get(x).getWage() + ", $" 
											  + arrayEmployee.get(x).getWageAfterTax() + ", "
											  + arrayEmployee.get(x).getEmployeeVehicle().getMake() + ", "
											  + arrayEmployee.get(x).getEmployeeVehicle().getModel());
			
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
