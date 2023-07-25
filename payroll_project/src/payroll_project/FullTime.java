package payroll_project;

public class FullTime extends Employee {
	
	private double salary = 4000.0; // salary of fulltime employees are fixed
	private double bonus = 0.0;
	
	public double caclEarnings(double bonus2) {
		// compute earnings before tax
		this.bonus = bonus2;
		
		return (this.salary + this.bonus);
		
	}
	
	public double caclIncomeTax(double salary) {
		// compute earnings after tax
		double tax = 0.15;
		
		return (salary - (salary * 0.18)); // 18% for fulltime
		
	}

}
