package payroll_project;

public class PartTime extends Employee{
	
	private double hoursWorked = 0.0;	
	private double rateOfPay = 0.0;
	
	/* --- LEARNING GOALS: ABSTRACTION AND POLYMOSPHISM --- */
	public double caclEarnings(double hoursWorked2, double rateOfPay2) {
		// compute earnings before tax
		this.hoursWorked = hoursWorked2;
		this.rateOfPay = rateOfPay2; 
		
		return (this.hoursWorked * this.rateOfPay);
		
	}
	
	public double caclIncomeTax(double salary) {
		// compute earnings after tax
		double tax = 0.15;
		
		return (salary - (salary * 0.15)); // 15% for part time
		
	}

}
