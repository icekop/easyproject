package domain;

import service.Status;

public class Designer extends Programmer {
	private double bonus;
	Designer(){
		super();
	}
	public Designer(int id, double salary, String name, int age, Equipment equipment, double bonus) {
		super(id, salary, name, age, equipment);
		this.bonus = bonus;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return getDetails()+"\t设计师\t"+getStatus()+"\t"+bonus+"\t\t"+getEquipment().getDescription();
	}
	public String toStringForTeam() {
		return getMemberID()+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t设计师\t"+getBonus();
	}
}
