package junit;

import org.junit.Test;

import domain.Employee;
import service.NameListService;
import service.TeamException;

/**
 * 对namelist进行测试
 * @author Lily
 *
 */
//需要重写toString方法
public class TeamJunit {
	@Test
	public void testnamelist() {
		NameListService nls=new NameListService();
		Employee[] allEmployees=nls.getAllEmployees();
		for(int i=0;i<allEmployees.length;i++) {
			System.out.println(allEmployees[i]);
		}
	}
	@Test
	public void getonename()  {
		NameListService nls=new NameListService();
		int id=15;
			try {

				Employee emp=nls.getEmployee(id);
				System.out.println(emp);
			} catch (TeamException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
	}
}
