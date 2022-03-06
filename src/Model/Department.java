package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Synchronizable, Changeable,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String depatmentName;
	private ArrayList<Role> roles;
	private boolean Synchronized;
	private boolean ChangeHours;
	private int startingHours;
	private double calculation;

	//
	// ----- constructor ----
	//
	public Department(String depatmentName, boolean Synchronized, boolean canChangeHours, int startingHours) {
		super();
		this.depatmentName = depatmentName;
		setSynchronized(Synchronized);
		setChangeHours(canChangeHours);
		this.roles = new ArrayList<Role>();
		this.startingHours = startingHours;
		calculation = 1.0;
	}


	//
	// ----- interface ----
	//
	public boolean isSynchronized() {
		return Synchronized;
	}

	public boolean canChangeHours() {
		return ChangeHours;
	}

	//
	// ---- functions ----
	//

	public void addRole(String name, int startHout, boolean ChangeHours) {
		roles.add(new Role(name, startHout, ChangeHours));

	}


	//
	// ---- to string ----
	// \

	public String displayRoles() {
		String string = "";
		for (int i = 0; i < roles.size(); i++) {
			string = string + "\n";
			string = string + "--- name: " + roles.get(i).getRole_name() + "\n";
			string = string + "--- is occupied: " + roles.get(i).isOccupied() + "\n";
			string = string + "--- can change hours: " + roles.get(i).isChangeHours() + "\n";
			if (roles.get(i).isChangeHours()) {
				string = string + "--- start hour: " + roles.get(i).getStartHour() + ":00 \n ";
			}

		}
		return string;
	}

	public String DisplayEMployeesNew() {
		String string = "";
		if (roles.size() == 0) {
			string = string + "\n";
			string = string + "The Department is Empty!";
		} else {
			for (int i = 0; i < roles.size(); i++) {
				string = string + "\n";
				string = string + " --- " + roles.get(i).getRole_name();
				string = string + roles.get(i).DisplayEmployees();
			}
		}
		string = string + "\n";
		return string;
	}
	//
	// ---- getters ----
	//
	public String getDepatmentName() {
		return depatmentName;
	}
	
	public boolean isFlexible_working() {
		return ChangeHours;
	}
	
	public boolean isCoordinated_hours() {
		return Synchronized;
	}

	public int getStartingHours() {
		return startingHours;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}

	public double getCalculation() {
		return calculation;
	}

	//
	// ---- getters ----
	//
	public void setSynchronized(boolean synchronized1) {
		Synchronized = synchronized1;
		
	}
	public void setCalculation(double calculation) {
		this.calculation = calculation;
	}
	
	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}
	
	public void setChangeHours(boolean changeHours) {
		ChangeHours = changeHours;
	}


}
