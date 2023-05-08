package domain;

import service.Status;

public class Architect extends Designer{
	private int block;

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}
	Architect(){
		super();
	}

	public Architect(int id, double salary, String name, int age, Equipment equipment, double bonus, int block) {
		super(id, salary, name, age,equipment, bonus);
		this.block = block;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return getDetails()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+getBlock()+"\t"+getEquipment().getDescription();
	}
	public String toStringForTeam() {
		return getMemberID()+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t架构师\t"+getBonus()+"\t"+getBlock();
	}
}
