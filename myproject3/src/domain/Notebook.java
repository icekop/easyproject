package domain;

public class Notebook implements Equipment {
	private String model;//机器型号
	private double price;//机器价格
	Notebook(){
		super();
	}

	public Notebook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return model+"("+price+")";
	}
}
