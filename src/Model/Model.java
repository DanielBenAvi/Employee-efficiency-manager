package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import Exception.IDExeption;
import Exception.emptyException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Model implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Company> companies;

	//
	// -------- constructor
	//

	public Model() {
		companies = new ArrayList<>();

		ObjectInputStream inFile = null;
		try {
			inFile = new ObjectInputStream(new FileInputStream("Data.data"));
			readAll(inFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//
	// ------- add new things ----
	//
	public void addDepartment(String get_Department_name, boolean a, boolean b, int startingHours)
			throws emptyException {

		companies.get(0).addDepartment(get_Department_name, b, a, startingHours);
	}

	public void addRole(String get_name_role, String Role_Department, int Role_startHour, boolean ChangeHours) {
		companies.get(0).getDepartments().get(findDepartment(Role_Department)).addRole(get_name_role, Role_startHour,
				ChangeHours);
	}

	public void addEmployee(String name, String id, String gender, LocalDate AddedDate, LocalDate BirthDate,
			String roleName, String employeeType, String Department) throws IDExeption {

		int i = findDepartment(Department);
		int j = findRole(roleName, Department);
		if (!RoleOccupiedCheck()) {
			if (j == -1) {
				alert("find roles error");
			} else {
				companies.get(0).getDepartments().get(i).getRoles().get(j).addEmployee(name, id, gender, AddedDate,
						BirthDate, employeeType);
			}
		} else {
			if (IDCheck(id)) {
				if (i == -1) {
					alert("find dep error");
				} else {
					if (j == -1) {
						alert("find roles error");
					} else {
						companies.get(0).getDepartments().get(i).getRoles().get(j).addEmployee(name, id, gender,
								AddedDate, BirthDate, employeeType);
					}
				}
			} else {
				alert("the employee alrady exists");
			}
		}
	}

	//
	// ----- find ----
	//
	public boolean RoleOccupiedCheck() {
		for (int i = 0; i < companies.get(0).getDepartments().size(); i++) {
			for (int j = 0; j < companies.get(0).getDepartments().get(i).getRoles().size(); j++) {
				if (companies.get(0).getDepartments().get(i).getRoles().get(j).isOccupied())
					return true;
			}
		}
		return false;
	}

	public boolean IDCheck(String ID) throws IDExeption {
		for (int i = 0; i < companies.get(0).getDepartments().size(); i++) {
			for (int j = 0; j < companies.get(0).getDepartments().get(i).getRoles().size(); j++) {
				if (companies.get(0).getDepartments().get(i).getRoles().get(j).isOccupied()) {
					if (companies.get(0).getDepartments().get(i).getRoles().get(j).getEmployee().getID().equals(ID))
						throw new IDExeption();
				}
			}
		}
		return true;
	}

	public int findDepartment(String departmentName) {
		for (int i = 0; i < companies.get(0).getDepartments().size(); i++) {
			if (companies.get(0).getDepartments().get(i).getDepatmentName().equals(departmentName)) {
				return i;
			}

		}

		return -1; // if can't find
	}

	public int findRole(String role, String department) {
		int i = findDepartment(department);
		for (int j = 0; j < companies.get(0).getDepartments().get(i).getRoles().size(); j++) {
			if (companies.get(0).getDepartments().get(i).getRoles().get(j).getRole_name().equals(role)) {
				return j;
			}
		}
		return -1;
	}

	//
	// -------- getters ----
	//
	public ArrayList<Department> getDepartments() {
		return companies.get(0).getDepartments();
	}

	public ArrayList<Company> getCompanies() {
		return companies;
	}

	//
	// -- alert --
	//
	public void alert(String msg) {
		Alert errorAlert = new Alert(AlertType.NONE, msg, ButtonType.CLOSE);
		errorAlert.showAndWait();
	}

	//
	// --- simulation --
	//
	public void resetCalculation() {
		companies.get(0).setCalc(1);
		for (int i = 0; i < companies.get(0).getDepartments().size(); i++) {
			companies.get(0).getDepartments().get(i).setCalculation(1);
			for (int j = 0; j < companies.get(0).getDepartments().get(i).getRoles().size(); j++) {
				companies.get(0).getDepartments().get(i).getRoles().get(j).getEmployee().setCalculation(1);
				companies.get(0).getDepartments().get(i).getRoles().get(j).getEmployee()
						.setPrefrence(Prefrence.Default);
			}
		}
	}

	public void simultionNew(int departmentPlacement, int rolePlacement, String prefrance, int hour) {
		if (companies.get(0).getDepartments().get(departmentPlacement).isFlexible_working()) {
			if (companies.get(0).getDepartments().get(departmentPlacement).isCoordinated_hours()) {
				int k = companies.get(0).getDepartments().get(departmentPlacement).getStartingHours();
				if (prefrance.equals("LateStart") || prefrance.equals("EarlyStart")) {
					companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement)
							.getEmployee().setCalculation(1 - 0.2 * Math.abs(k - hour));
				} else if (prefrance.equals("Home")) {
					companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement)
							.getEmployee().setCalculation(1 - 0.1 * Math.abs(k - hour));
				}
			} else {
				int k = companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement)
						.getStartHour();
				if (companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement)
						.isChangeHours()) {
					if (prefrance.equals("LateStart") || prefrance.equals("EarlyStart")) {
						companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement)
								.getEmployee().setCalculation(1 + 0.2 * Math.abs(9 - hour));
					} else if (prefrance.equals("Home")) {
						companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement)
								.getEmployee().setCalculation(1 + 0.1 * Math.abs(9 - hour));
					}
				} else {
					if (prefrance.equals("LateStart") || prefrance.equals("EarlyStart")) {
						companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement)
								.getEmployee().setCalculation(1 - 0.2 * Math.abs(k - hour));
					} else if (prefrance.equals("Home")) {
						companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement)
								.getEmployee().setCalculation(1 - 0.1 * Math.abs(k - hour));
					}
				}
			}
		} else {
			if (prefrance.equals("LateStart") || prefrance.equals("EarlyStart")) {
				companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement).getEmployee()
						.setCalculation(1 - 0.2 * Math.abs(9 - hour));
			} else if (prefrance.equals("Home")) {
				companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement).getEmployee()
						.setCalculation(1 - 0.1 * Math.abs(9 - hour));
			}
		}
	}

	public String Display_results_new() {
		String string = "";
		string = string + " Company's Efficitioncy: " + (int) (companies.get(0).getCalc() * 100) + "%\n\n";
		for (int i = 0; i < companies.get(0).getDepartments().size(); i++) {
			string = string + " --- Department: " + companies.get(0).getDepartments().get(i).getDepatmentName()
					+ "\n";
			string = string + " --- Department's Efficitioncy: "
					+ (int) ((companies.get(0).getDepartments().get(i).getCalculation()) * 100) + "%\n";
			for (int j = 0; j < companies.get(0).getDepartments().get(i).getRoles().size(); j++) {
				if (!companies.get(0).getDepartments().get(i).getRoles().get(j).isOccupied()) {
					string = string + " --------- "
							+ companies.get(0).getDepartments().get(i).getRoles().get(j).getRole_name()
							+ " --> is Unoccupied \n";
				} else {
					string = string + " --------- "
							+ companies.get(0).getDepartments().get(i).getRoles().get(j).getRole_name() + " --> \n";
					string = string + " ------------------ Employee Name: "
							+ companies.get(0).getDepartments().get(i).getRoles().get(j).getEmployee().getEmployeeName()
							+ "\n";
					string = string + " ------------------ Prefrence: "
							+ companies.get(0).getDepartments().get(i).getRoles().get(j).getEmployee().getPrefrence()
							+ "\n";
					string = string + " ------------------ Efficitioncy: " + (int) (companies.get(0).getDepartments().get(i)
							.getRoles().get(j).getEmployee().getCalculation() * 100) + "%\n";
				}
			}
			string = string + "\n";
		}

		return string;
	}

	public void calc_department_efficiency() {
		for (int i = 0; i < companies.get(0).getDepartments().size(); i++) {
			double calc = 0;
			double occNum = 0;
			for (int j = 0; j < companies.get(0).getDepartments().get(i).getRoles().size(); j++) {
				if (companies.get(0).getDepartments().get(i).getRoles().get(j).isOccupied()) {
					calc = calc
							+ companies.get(0).getDepartments().get(i).getRoles().get(j).getEmployee().getCalculation();
					occNum++;
				}
			}
			calc = calc / occNum;
			companies.get(0).getDepartments().get(i).setCalculation(calc);
			calc = 0;
			occNum = 0;
		}

	}

	public void calc_company_efficiency() {
		double num = 0;
		double counter = 0;
		for (int i = 0; i < companies.get(0).getDepartments().size(); i++) {
			if (!Double.isNaN(companies.get(0).getDepartments().get(i).getCalculation())) {
				num = num + companies.get(0).getDepartments().get(i).getCalculation();
				counter++;
			}

		}
		if (num != 0) {
			companies.get(0).setCalc(num / counter);
		} else {
			companies.get(0).setCalc(0);
		}

	}

	//
	// -- display
	//
	public String displayRoles() {
		return companies.get(0).DisplayRoles();
	}

	public String displayDipartment() {
		return companies.get(0).DisplayDepartments();
	}

	public String displayEmployees() {
		// System.out.println("198");
		return companies.get(0).DisplayEmployees();
	}

	//
	// read & save
	//

	public void saveAll(ObjectOutputStream outFile) throws IOException {
		outFile.writeObject(companies.get(0));
		outFile.close();
	}

	public void readAll(ObjectInputStream inFile) throws IOException, ClassNotFoundException {
		companies.add((Company) inFile.readObject());

		inFile.close();
	}

}
