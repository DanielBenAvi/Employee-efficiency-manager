package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Exception.emptyException;

public class Company implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String companyName;
	private ArrayList<Department> departments;
	private double calc;


	//
	// ---- constructors ----
	//
	public Company(String companyName) {
		this.companyName = companyName;
		this.departments = new ArrayList<Department>();
		setCalc(1);
	}

	//
	// ---- functions ----
	//
	public double getCalc() {
		return calc;
	}
	
	public void setCalc(double calc) {
		this.calc = calc;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void addDepartment(String name, boolean flexible_working, boolean coordinated_hours, int startingHours)
			throws emptyException {
		departments.add(new Department(name, flexible_working, coordinated_hours, startingHours));

	}

	//
	// ---- getters ----
	//
	public ArrayList<Department> getDepartments() {
		return departments;
	}

	public String getCompanyName() {
		return companyName;
	}

	//
	// ---- setters ----
	//
	public void setDepartments(ArrayList<Department> departments) {
		this.departments = departments;
	}

	//
	// -- display
	//

	public String DisplayRoles() {
		String string = "";
		for (int i = 0; i < departments.size(); i++) {
			string = string + (i + 1) + ". ";
			string = string + departments.get(i).getDepatmentName();
			string = string + departments.get(i).displayRoles();
			string = string + "\n";
		}

		return string;
	}

	public String DisplayDepartments() {
		String string = "";
		for (int i = 0; i < departments.size(); i++) {
			string = string + (i + 1) + ". ";
			string = string + departments.get(i).getDepatmentName() + ": ";
			string = string + "\n--- coordinated Houres: " + departments.get(i).isCoordinated_hours();
			string = string + "\n--- flexible Houres: " + departments.get(i).isFlexible_working();
			string = string + "\n--- starting Hour: " + departments.get(i).getStartingHours() + ":00";
			string = string + "\n";
			string = string + "\n";
		}

		return string;
	}

	public String DisplayEmployees() {
		
		String string = "";
		for (int i = 0; i < departments.size(); i++) {
			string = string + departments.get(i).getDepatmentName() + ": ";
			string = string + departments.get(i).DisplayEMployeesNew();
			string = string + "\n";
		}

		return string;
	}

}
