package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Equipment;
import domain.Notebook;
import domain.PC;
import domain.Printer;
import domain.Programmer;

/**
 * 
 * @author Lily
 * @version 1.0
 */
public class NameListService {
	private Employee[] employees;
	public NameListService() {
		employees=new Employee[Data.EMPLOYEES.length];
		
		for(int i=0;i<Data.EMPLOYEES.length;i++) {
			int id=Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name=Data.EMPLOYEES[i][2];
			int age=Integer.parseInt(Data.EMPLOYEES[i][3]);
			double salary=Double.parseDouble(Data.EMPLOYEES[i][4]);
			int type=Integer.parseInt(Data.EMPLOYEES[i][0]);//String转化成int
			Equipment equipment;//先声明，根据实际情况获取。
			double bonus;
			int stock;
			switch(type) {
			case Data.EMPLOYEE:
				employees[i]=new Employee(id,salary,name,age);
				break;
			case Data.PROGRAMMER:
				equipment=createEquipment(i);
				employees[i]=new Programmer(id, salary, name, age, equipment);
				break;
			case Data.DESIGNER:
				equipment=createEquipment(i);
				bonus=Double.parseDouble(Data.EMPLOYEES[i][5]);
				employees[i]=new Designer(id, salary, name, age, equipment, bonus);
				break;
			case Data.ARCHITECT:
				equipment=createEquipment(i);
				bonus=Double.parseDouble(Data.EMPLOYEES[i][5]);
				stock=Integer.parseInt(Data.EMPLOYEES[i][6]);
				employees[i]=new Architect(id, salary, name, age, equipment, bonus,stock);
				break;
				
			}
		}
	}
	/**
	 * @description 获取第i个索引的员工设备
	 * @param i
	 * @return
	 */
	private Equipment createEquipment(int i) {
		int number=Integer.parseInt(Data.EQUIPMENTS[i][0]);
		switch(number) {
		case Data.PC://21
			return new PC(Data.EQUIPMENTS[i][1],Data.EQUIPMENTS[i][2]);
		case Data.NOTEBOOK://22
			double price=Double.parseDouble(Data.EQUIPMENTS[i][2]);
			return new Notebook(Data.EQUIPMENTS[i][1],price);
		case Data.PRINTER://23
			return new Printer(Data.EQUIPMENTS[i][1],Data.EQUIPMENTS[i][2]);
			
		}
		return null;
	}
	public Employee[] getAllEmployees() {
		return employees;
	}
	public Employee getEmployee(int id) throws TeamException {
		for(int i=0;i<employees.length;i++) {
			if(employees[i].getId()==id) //如果是Integer类型，需要用equals
			{
				return employees[i];
			}
		}
		throw new TeamException("没有找到指定员工");
	}
}
