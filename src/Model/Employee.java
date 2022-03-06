package Model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Employee implements Synchronizable, Changeable,Serializable {
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected String employeeName;
	protected String ID;
	protected String gender;
	protected LocalDate empployeeAddedDate;
	protected LocalDate employeeBirthDate;
	protected double calculation;
	protected Prefrence prefrence;
	protected int StartHours;
	
	public Employee(String employeeName, String iD, String gender, LocalDate employeeBirthDate,
			LocalDate empployeeAddedDate) {
		this.employeeName = employeeName;
		ID = iD;
		this.gender = gender;
		this.empployeeAddedDate = empployeeAddedDate;
		this.employeeBirthDate = employeeBirthDate;
		prefrence = Prefrence.Default;
		StartHours = 9;
		this.setCalculation(1);
	}

	public void setPrefrence(Prefrence prefrence) {
		this.prefrence = prefrence;
	}
	
	@Override
	public boolean isSynchronized() {
		return false;

	}

	@Override
	public boolean canChangeHours() {
		return false;

	}

	public String getGender() {
		return gender;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getID() {
		return ID;
	}

	public LocalDate getEmpployeeAddedDate() {
		return empployeeAddedDate;
	}

	public LocalDate getEmployeeBirthDate() {
		return employeeBirthDate;
	}

	public int getStartHours() {
		return StartHours;
	}

	public Prefrence getPrefrence() {
		return prefrence;
	}

	public double getCalculation() {
		return calculation;
	}

	public void setCalculation(double calculation) {
		this.calculation = calculation;
	}

}
