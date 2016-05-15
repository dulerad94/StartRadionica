package model;

public class Automobil {
	protected String markaIModel;
	protected int konjskaSnaga;
	
	public Automobil(String markaIModel, int konjskaSnaga){
		this.markaIModel=markaIModel;
		this.konjskaSnaga=konjskaSnaga;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return markaIModel+" A SNAGA JE "+konjskaSnaga;
	}
}
