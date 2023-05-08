package view;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

public class TeamView {
	private static NameListService namelist=new NameListService();
	private TeamService teamlist=new TeamService();
	char menu;
	public void EnterMenu() {
		boolean flag=true;
		while(flag) {
			if(menu!='1') {
		listAllEmployees();}
		System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：");
		menu=TSUtility.readMenuSelection();
		switch(menu) {
		case('1'):
			getTeam();
			break;
		case('2'):
			addMember();
			break;
		case('3'):
			deleteMember();
			break;
		case('4'):
			System.out.println("是否确认退出？(Y/N):");
			char isExit=TSUtility.readConfirmSelection();
			if(isExit=='Y') {
				flag=false;
			}
			break;
		}
	}
	}
	private static void listAllEmployees() {
		System.out.println("----------------------------------开发团队调度软件-------------------------");
		Employee[] emp=namelist.getAllEmployees();
		if(emp==null||emp.length==0) {
			System.out.println("团队中没有任何成员");
		}else {
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t设备");
			for(int i=0;i<emp.length;i++) {
				System.out.println(emp[i]);
			}
		}
		System.out.println("----------------------------------------------------------------------");
	}
	private void getTeam() {
		System.out.println("----------------------------------团队成员列表-------------------------");
		Programmer[] prog=teamlist.getTeam();
		if(prog==null||prog.length==0) {
			System.out.println("开发团队目前没有任何成员");
		}else {
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
			for(int j=0;j<prog.length;j++) {
				System.out.println(prog[j].toStringForTeam());
			}
		}
		System.out.println("--------------------------------------------------------------------");
	}
	private void addMember()  {
		//System.out.println("添加团队成员");
		System.out.println("----------------------------------添加团队成员-------------------------");
		System.out.println("请输入要添加的员工ID:");
		int id=TSUtility.readInt();
		try {
			Employee emp=namelist.getEmployee(id);
			teamlist.addMember(emp);
			System.out.println("添加成功！");
		
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("添加失败,原因："+e.getMessage());
		}
		TSUtility.readReturn();
	}
	private void deleteMember() {
		//System.out.println("删除团队成员");
		System.out.println("----------------------------------删除团队成员-------------------------");
		Programmer[] prog=teamlist.getTeam();
		if(prog==null||prog.length==0) {
			System.out.println("无法删除！该团队目前没有成员!");
			return;
		}
		System.out.println("请输入要删除员工的TID：");
		int id=TSUtility.readInt();
		System.out.println("是否确认删除？(Y/N):");
		char isDeleted=TSUtility.readConfirmSelection();
		if(isDeleted=='N') {
			return;
		}
		try {
			teamlist.removeMember(id);
			System.out.println("删除成功！");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("删除失败,原因："+e.getMessage());
		}
		TSUtility.readReturn();
	}
	public static void main(String[] args) {
		TeamView tv=new TeamView();
		tv.EnterMenu();
	}
}
