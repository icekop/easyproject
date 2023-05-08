package domain;

import service.Status;

public class Programmer extends Employee {
	private int memberID;//开发团队中的id
	private Status status=Status.free;
	private Equipment equipment;
	public Programmer() {
		super();
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public Programmer(int id, double salary, String name, int age, Equipment equipment) {
		super(id, salary, name, age);
		
		this.equipment = equipment;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"\t程序员\t"+status+"\t\t\t"+equipment.getDescription();
	}
	public String toStringForTeam() {
		return memberID+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t程序员";
	}
}
