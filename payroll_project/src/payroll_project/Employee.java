package payroll_project;

abstract class Employee {	
	
	public abstract double caclEarnings(double parameter1, double parameter2);
	public abstract double caclIncomeTax(double parameter1);
	
	private int yearOfBirth = 0;	
	
	private String name = "";
	private int empID = 0;
	private String empType = "";
	private double wage = 0.0;
	private double wageAfterTax = 0.0;
	
	/* --- GETTER AND SETTER --- */
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public int getEmpID() {
		return empID;
	}
	
	public void setEmpID(int newEmpID) {
		this.empID = newEmpID;
	}
	
	public String getWorkType() {
		return empType;
	}
	
	public void setWorkType(String newWorkType) {
		this.empType = newWorkType;
	}
	
	public int getyearOfBirth() {
		return yearOfBirth;
	}
	
	public void setyearOfBirth(int newyearOfBirth) {
		this.yearOfBirth = newyearOfBirth;
	}
	
	public double getWage() {
		return wage;
	}
	
	public void setWage(double newWage) {
		this.wage = newWage;
	}
	
	public double getWageAfterTax() {
		return wageAfterTax;
	}
	
	public void setWageAfterTax(double newWageAfterTax) {
		this.wageAfterTax = newWageAfterTax;
	}

}
