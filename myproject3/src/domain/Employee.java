package domain;
//JavaBean
public class Employee {
	private int id;
	private double salary;
	private String name;
	private int age;
	Employee(){
		super();
	}
	public Employee(int id, double salary, String name, int age) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getDetails() {
		return id+"\t"+name+"\t"+age+"\t"+salary;
	}
	public String toString() {
		
		return getDetails();
	}
}
