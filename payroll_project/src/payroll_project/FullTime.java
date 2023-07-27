package payroll_project;

public class FullTime extends Employee {
	
	private double salary = 0.0; 
	private double bonus = 0.0;
	
	/* --- LEARNING GOALS: ABSTRACTION AND POLYMOSPHISM --- */
	public double caclEarnings(double salary2, double bonus2) {
		// compute earnings before tax
		this.salary = salary2;
		this.bonus = bonus2;
		
		return (this.salary + this.bonus);
		
	}
	
	public double caclIncomeTax(double salary) {
		// compute earnings after tax
		double tax = 0.15;
		
		return (salary - (salary * 0.18)); // 18% for full time
		
	}

}
