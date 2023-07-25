package payroll_project;

public class Person {

	private String name = "Jane Doe";
	private String email = "jdoe@gmail.com";
	private String address = "London, ON, Canada";
	
	public static void main(String[] args) {
		
		Person p1 = new Person();
		
		p1.PrintMyData();
		
		System.out.println("Email: " + p1.getEmail());
		System.out.println("Address: " + p1.getAddress());
		
		//System.out.println("Name: " + name);
		//Error: Cannot reference non-static variable in a static method
		
		MyStaticMethod();
		
	}
	
	public void PrintMyData() {		
		
		System.out.println("Hello! I am PrintMyData()");
		
	}
	
	static void MyStaticMethod() {
		
		System.out.println("Hello! I am MyStaticMethod()");
		
	}
	
	// GET SET Codes
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}
	
}
