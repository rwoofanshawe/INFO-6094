package payroll_project;

public class Vehicle {

	private String model;
	private String make;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String model, String make) {
		super();
		this.model = model;
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}

	@Override
	public String toString() {
		return "Vehicle [model=" + model + ", make=" + make + "]";
	}
	
}
