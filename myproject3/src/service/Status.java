package service;
//枚举类
public class Status {
	private final String name;
	private Status(String name) {
		this.name=name;
	}
	public static final Status free=new Status("FREE");
	public static final Status busy=new Status("BUSY");
	public static final Status vocation=new Status("VOCATION");
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
