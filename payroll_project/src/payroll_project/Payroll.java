package payroll_project;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9,-.]+$");

		/* --- INPUT LOOP --- */
		do {
			System.out.println("==== INPUT ====");
			
	        while (true) {
	            System.out.print("Enter Name: ");
	            name = input.nextLine();

	            Matcher matcher = pattern.matcher(name);
	            if (matcher.matches()) {
	                break; // Exit the loop since the input is valid
	            } else {
	                System.out.println("Invalid name. Please enter only alphanumeric characters and special characters - , .");
	                System.out.println("Press enter to continue");
	                input.nextLine();
	            }
	        }
			
	        while (true) {
	            try {
	    			System.out.print("Enter Employee ID: ");
	    			empID = Integer.parseInt(input.nextLine());
	    			
	    	        // Check if the empID already exists in the 'employees' array
	    	        boolean isIDExists = false;
	    	        for (Employee employee : arrayEmployee) {
	    	            if (employee != null && employee.getEmpID() == empID) {
	    	                isIDExists = true;
	    	                break;
	    	            }
	    	        }

	    	        if (isIDExists) {
	    	            System.out.println("Employee ID already exists in the list.");
	    	            int err = Integer.parseInt("X"); //force a NumberFormatException
	    	        }	    			
	
	                break; // If the input is valid, exit the loop
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input! Please enter a valid Employee ID. Press Enter key.");
	                input.nextLine();
	            }
	        }				
			
	        // Get the current year
	        int currentYear = LocalDate.now().getYear();

	        while (true) {
	            try {
	                System.out.print("Enter Year of Birth: ");
	                yearOfBirth = Integer.parseInt(input.nextLine());

	                // Check if the input is valid (between 1900 and the current year)
	                if (yearOfBirth >= 1900 && yearOfBirth <= currentYear) {
	                    // Calculate age based on year of birth and current year
	                    int age = currentYear - yearOfBirth;

	                    if (age >= 16) {
	                        // If the age is 16 years or older, exit the loop
	                        break;
	                    } else {
	                        // Force a NumberFormatException by attempting to parse "X"
	                        int err = Integer.parseInt("X");
	                    }
	                } else {
	                    // The input is not valid; handle accordingly
	                    throw new NumberFormatException();
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input! Please enter a valid Year of Birth between 1900 and the current year (" + currentYear + ") that would make you 16 years or older. Press Enter key.");
	                input.nextLine();
	            }
	        }				
			
	        while (true) {
	            try {
	    			System.out.print("Enter Work Type [1 - PartTime / 2 - FullTime / 3 - Intern]: ");
	    			employeeType = Integer.parseInt(input.nextLine());
	                if (employeeType >= 1 && employeeType <= 3) {
	                    // Valid input, process the employee based on the type
	                	break; // If the input is valid, exit the loop
	                } else {
	                    // Invalid input, prompt the user to try again
	                    System.out.println("Invalid input! Please enter a valid Work Type. Press Enter key.");
	                    input.nextLine();
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input! Please enter a valid Work Type. Press Enter key.");
	                input.nextLine();
	            }
	        }			
			
	        while (true) {
	            System.out.print("Do you have a vehicle? [N - No / Y - Yes]:");
	            hasVehicle = input.nextLine().trim().toUpperCase();

	            if (hasVehicle.equals("Y") || hasVehicle.equals("N")) {
	                break; // If the input is valid ('Y' or 'N'), exit the loop
	            } else {
	                System.out.println("Invalid input! Please enter 'Y' or 'N'. Press Enter key.");
	                input.nextLine();
	            }
	        }
		    
		    if(hasVehicle.equals("Y")) {
			    
		        while (true) {
		            System.out.print("What is the Vehicle Model?:");
		            vehicleModel = input.nextLine();

		            Matcher matcherModel = pattern.matcher(vehicleModel);
		            if (matcherModel.matches()) {
		                break; // Exit the loop since the input is valid
		            } else {
		                System.out.println("Invalid Vehicle Model. Please enter only alphanumeric characters and special characters - , .");
		                System.out.println("Press enter to continue");
		                input.nextLine();
		            }
		        }

		        while (true) {
		            System.out.print("What is the Vehicle Make?:");
		            vehicleMake = input.nextLine();

		            Matcher matcherMake = pattern.matcher(vehicleMake);
		            if (matcherMake.matches()) {
		                break; // Exit the loop since the input is valid
		            } else {
		                System.out.println("Invalid Vehicle Make. Please enter only alphanumeric characters and special characters - , .");
		                System.out.println("Press enter to continue");
		                input.nextLine();
		            }
		        }

			    employeeVehicle = new Vehicle(vehicleModel, vehicleMake);
			    
		    } else {
		    	employeeVehicle = new Vehicle("N/A", "N/A"); //Vehicle entry not applicable (NA)
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
				
			} else if (employeeType == 3) { // Intern

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
				
				
				
				Intern empIN1 = new Intern();
				
				// using constructors
				empIN1.setName(name);
				empIN1.setEmpID(empID);
				empIN1.setWorkType("Intern");
				empIN1.setyearOfBirth(yearOfBirth);
				empIN1.setWage(empIN1.caclEarnings(employeeHoursWorked, employeeRate));
				empIN1.setWageAfterTax(empIN1.caclIncomeTax(empIN1.getWage()));

				empIN1.setEmployeeVehicle(employeeVehicle);
		    	
				arrayEmployee.add(empIN1);
				
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
		int ctrFullTime = 0, ctrPartTime = 0, ctrIntern = 0, ctrVehicle = 0;
		double totalWages = 0, totalWagesAfterTax = 0;
		System.out.println("==== OUTPUT ====");

        // Print column headers with even spacing
        System.out.format("%-4s%-20s%-20s%-12s%-16s%-16s%-15s%-15s%n",
                "No.", "Name", "Employee ID", "Work Type", "Wage", "Wage After Tax", "Vehicle Make", "Vehicle Model");
        
        System.out.format("%-4s%-20s%-20s%-12s%-16s%-16s%-15s%-15s%n",
                "____", "____________________", "____________________", "____________", "________________", "________________", "_______________", "_______________");
        
		for (int x = 0; x < arrayEmployee.size(); x++) {

            System.out.format("%-4s%-20s%-20s%-12s$%-15.2f$%-15.2f%-15s%-15s%n",
                    (x + 1), arrayEmployee.get(x).getName(), 
                    arrayEmployee.get(x).getEmpID(), 
                    arrayEmployee.get(x).getWorkType(),
                    arrayEmployee.get(x).getWage(), 
                    arrayEmployee.get(x).getWageAfterTax(), 
                    arrayEmployee.get(x).getEmployeeVehicle().getMake(), 
                    arrayEmployee.get(x).getEmployeeVehicle().getModel());
			
			// count total employee by work type		
			switch(arrayEmployee.get(x).getWorkType()) {
				case "Full-Time": {ctrFullTime+=1; break;}
				case "Part-Time": {ctrPartTime+=1; break;}
				case "Intern":	  {ctrIntern+=1;   break;}
				default:	break;
			}
			
			if(!arrayEmployee.get(x).getEmployeeVehicle().getMake().equals("N/A") && 
			   !arrayEmployee.get(x).getEmployeeVehicle().getModel().equals("N/A")) {
				ctrVehicle+=1;
			}
			
			
			// count total wages before and after tax by counter
			totalWages+=arrayEmployee.get(x).getWage();
			totalWagesAfterTax+=arrayEmployee.get(x).getWageAfterTax();
		}
		
        System.out.format("%-4s%-20s%-20s%-12s%-16s%-16s%-15s%-15s%n",
                "____", "____________________", "____________________", "____________", "________________", "________________", "_______________", "_______________");
        
		
		/* --- OUTPUT TOTALS --- */
		System.out.println();	
		System.out.println("Total Employees: #" + String.format("%3d", arrayEmployee.size()));
		System.out.println("Work types: (#" + String.format("%2d", ctrPartTime) + ") Part-Time, (#" + String.format("%2d", ctrFullTime) + ") Full-Time, (#" + String.format("%2d", ctrIntern) + ") Intern");
		System.out.println("Total Wages Before Tax: $" + String.format("%,10.2f", totalWages));
		System.out.println("Total Wages After Tax: $" + String.format("%,10.2f", totalWagesAfterTax));
		System.out.println("Total Employees with Vehicles: #" + String.format("%3d", ctrVehicle));
		
		
		
		/* --- CLOSE CONNECTIONS --- */
		input.close(); // close scanner
		System.exit(0); // terminate program
	}
}
