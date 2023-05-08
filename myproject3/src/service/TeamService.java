package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

public class TeamService {
	private static int id=1;//给memberId赋值，自增1
	private final int Max_MEMBER=5;
	private Programmer[] pro=new Programmer[Max_MEMBER];//保存开发团队成员，最多5人
	private int total;//开发团队中实际的人数
	public TeamService() {
		super();
	}
	//返回实际的成员，而非Max_MEMBER数组
	public Programmer[] getTeam() {
		Programmer[] team=new Programmer[total];
		for(int i=0;i<total;i++) {
			team[i]=pro[i];
		}
		return team;
	}
	/**
	 * 将指定员工添加到团队成员中
	 * @param e
	 */
	public void addMember(Employee e) throws TeamException{
		// 成员已满，无法添加
		 if(total>=Max_MEMBER) {
			 throw new TeamException("成员已满，无法添加");
		 }
		 //该成员不是开发人员，无法添加——保证成员e一定是Programmer的子类
		 if(!(e instanceof Programmer)) {
			 throw new TeamException("该成员不是开发人员，无法添加");
		 }
		 //该员工已在开发团队中
		 if(isExist(e)) {
			 throw new TeamException("该员工已经在开发团队中，无法添加！");
		 }
		 //该员工已经是某团队成员
		 //该员工正在休假，无法添加
		 Programmer p=(Programmer)e;
		 if(p.getStatus().getName().equalsIgnoreCase("BUSY")) {
			 throw new TeamException("该员工已经是某团队成员，无法添加！");
		 }else if(p.getStatus().getName().equalsIgnoreCase("VOCATION")) {
			 throw new TeamException("该员工正在休假中，无法添加！");
		 }
		 //团队中最多一名架构师/两名设计师/三名程序员
		 //获取已有的架构师、设计师、程序员的数量
		 int numofarch=0;
		 int numofpro=0;
		 int numofdes=0;
		 for(int j=0;j<total;j++) {//architect——designer——programmer 注意先后顺序
			 if(pro[j] instanceof Architect) {
				 numofarch++;
			 }else if(pro[j] instanceof Designer) {
				 numofdes++;
			 }else if(pro[j] instanceof Programmer) {
				 numofpro++;
			 }
		 }
		 //以下的内容必须用if分开写，不能写成&&
		 if(p instanceof Architect) {
			 if(numofarch>=1) {
				 throw new TeamException("团队中最多一名架构师，无法添加！");
			 }
		 }else if(p instanceof Designer) {
			 if(numofdes>=2) {
				 throw new TeamException("团队中最多两名设计师，无法添加！");
			 }
		 }else if(p instanceof Programmer) {
			 if(numofpro>=3) {
				 throw new TeamException("团队中最多三名程序员，无法添加！");
			 }
		 }
		 //正式添加
		 pro[total++]=p;
		 //p属性赋值
		 p.setStatus(Status.busy);
		 p.setMemberID(id++);
		 
	}
	private boolean isExist(Employee e) {
		for(int i=0;i<total;i++) {
			if(pro[i].getId()==e.getId()){
				return true;
			}
		}
		return false;
	}
	public void removeMember(int memberId) throws TeamException {
		int o=0;
		boolean flag=true;
		for(;o<total;o++) {
			if(pro[o].getMemberID()==memberId) {
				pro[o].setStatus(Status.free);
				//删除操作：后一个元素覆盖前一个元素，最后一个元素置空，数组长度减一
				for(int q=o;q<total-1;q++) {
					pro[q]=pro[q+1];
				}
				pro[total-1]=null;
				total--;
				flag=false;
				break;
			}
		}
		if(flag) {
			 throw new TeamException("未找到指定ID的成员，无法移除！");
		}
		
	}
}
