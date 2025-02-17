package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;///  atributos base
	private double baseSalary;

	private Departament departament;
	private List<HourContract> contracts = new ArrayList<>(); /// associações
	
	//construtores
	public Worker() {}
	
	public Worker(String name, WorkerLevel level, double baseSalary, Departament departament){
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}
	
	//getters e setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void setContracts(List<HourContract> contracts) {
		this.contracts = contracts;
	}
	//metodos
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	
	
	public Double income(Integer year, Integer month){
		double sum = baseSalary;
		for(HourContract c: contracts) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(c.getDate());
			
			int c_year = cal.get(Calendar.YEAR);
			int c_month	= 1+cal.get(Calendar.MONTH);
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
	
	
	
	
}
