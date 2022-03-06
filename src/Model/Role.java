package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Role implements Synchronizable, Changeable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String role_name;
	private Employee employee;
	private int startHour;
	private boolean occupied;
	private boolean ChangeHours;
	private boolean Synchronized;

	public Role(String role_name, int startHour, boolean ChangeHours) {
		this.role_name = role_name;
		this.startHour = startHour;
		this.ChangeHours = ChangeHours;
		this.occupied = false;
	}

	public String getRole_name() {
		return role_name;
	}

	public void addEmployee(String name, String id, String gender, LocalDate AddedDate, LocalDate BirthDate,
			String employeeType) {
		occupied = true;
		if (employeeType.equals("Basic")) {
			employee = new Employee_B(name, id, gender, AddedDate, BirthDate);
		} else if (employeeType.equals("Hourly")) {
			employee = new Employee_H(name, id, gender, AddedDate, BirthDate);
		} else if (employeeType.equals("Basic + Sales")) {
			employee = new Employee_B_S(name, id, gender, AddedDate, BirthDate);
		}
	}

	public boolean isOccupied() {
		return occupied;
	}

	public Employee getEmployee() {
		return employee;
	}

	public boolean getSynchronized() {
		return Synchronized;
	}

	public boolean isChangeHours() {
		return ChangeHours;
	}


	public boolean canChangeHours() {
		return ChangeHours;

	}

	public boolean isSynchronized() {
		return ChangeHours;

	}

	public int getStartHour() {
		return startHour;
	}

	public String DisplayEmployees() {
		String string = "";
		if (occupied) {
			string = string + "\n ------ Name:  " + employee.getEmployeeName();
			string = string + "\n ------ Id:  " + employee.getID();
			string = string + "\n ------ Gender:  " + employee.getGender();
			string = string + "\n ------ BirthDate:  " + employee.getEmployeeBirthDate();
			string = string + "\n ------ EmploymentDate:  " + employee.getEmpployeeAddedDate();
			if (String.valueOf(employee.getClass()).equals("class Model.Employee_B")) {
				string = string + "\n ------ Employee type:  basic";
			} else if (String.valueOf(employee.getClass()).equals("class Model.Employee_H")) {
				string = string + "\n ------ Employee type:  hourly";
			} else if (String.valueOf(employee.getClass()).equals("class Model.Employee_B_S")) {
				string = string + "\n ------ Employee type:  basic + bonus";
			}

		} else {
			string = string + "\n ------ The Role is unOccupied";

		}
		string = string + "\n";
		return string;
	}

}
