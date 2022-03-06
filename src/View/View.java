package View;

import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import java.time.LocalDate;
import java.util.ArrayList;

import Exception.IDExeption;
import Exception.ageException;
import Exception.emptyException;
import Exception.futureException;
import Exception.nullException;
import Model.Department;
import Model.Role;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class View {

	private Button button_READ, button_sceneMain_view_EMPLOYEES, button_addRole, button_addDepartment,
			button_addEmployee, button_scene_addDepaetment, button_sceneMain_department, button_scene_addEmployee,
			button_scene_addRole, button_scene_DisplayData, button_scene_wageSimulation, button_sceneMain_Employee,
			button_sceneMain_role, button_sceneMain_simulation, button_department_toString, button_Employee_toString,
			button_Role_toString, button_scene_ViewDepaetment, button_scene_ViewEmployee, button_scene_ViewRole,
			button_sceneMain_view_Departments, button_sceneMain_view_roles, nextPerson, button_back_ViewResults,
			button_scene_results, button_Save_Person_simulation, button_Reset_semulation;
	private VBox vbox_spinner_AddDepartment, vbox_role_Department, vbox_employee_Department, vbox_employee_type,
			vbox_role_name, vbox_employee_gender, vbox_birthDate, vbox_employmentDate, vbox_Employee_position,
			vbox_Employee_ID, vbox_department_Name, vbox_Depatment_checkbox_flexible_working,
			vbox_Depatment_checkbox_Coordinated_hours, vbox_Employee_Name, simulation_vbox, simulation_vbox_Spinner,
			simulation_vbox_ComboBox, vbox_spinner_AddRole, vbox_role_canChangeHours, vBox_results;
	private Label label_results, label_simulation_vbox_combobox, label_vbox_role_canChangeHours, label_role_Department,
			label_employee_Department, label_employee_type, label_role_name, label_employee_gender,
			labal_employementDate, label_birthDate, label_Employee_position, label_Employee_ID, label_Department_Name,
			label_Employee_Name, label_department_checkbox_flexible_working,
			label_department_checkbox_coordinated_hours, labal_vbox_spinner_AddDepartment, labal_vbox_spinner_AddRole,
			label_simulation_vbox_Spinner, label_simulation_vbox_Department, label_simulation_vbox_Employee,
			label_simulation_vbox_Role;
	private TextField textField_role_name, TextField_Employee_ID, TextField_Employee_Name, TextField_Department_Name;
	private Group root_addRole, root_addDepartment, root_addEmployee, mainGroup, group_wageSimulation,
			group_view_Departments, group_view_roles, group_view_EMPLOYEES, group_results;
	private CheckBox checkBox_vbox_role_canChangeHours, checkbox_department_checkbox_flexible_working,
			checkbox_department_checkbox_coordinated_hours;
	private DatePicker datePicker_birthDate, datePicker_employementDate;
	private ComboBox<String> combobox_simulation_vbox_ComboBox, combobox_role_Department, combobox_employee_Department,
			combobox_employee_type, comboBox_Employee_Role, combobox_employee_gender,
			comboBox_simulation_vbox_Department, comboBox_simulation_vbox_Role, comboBox_simulation_vbox_Employee;
	private Scene mainScene, scene_addDepartment, scene_Display, scene_wageSimulation, scene_addRole, scene_addEmployee,
			scene_view_Departments, scene_view_roles, scene_view_EMPLOYEES, scene_results;
	private Stage stg;
	private TextArea area_view_Departments, area_view_roles, textView_results, area_view_EMPLOYEES_new;
	private Spinner<Integer> spinner_simulation, spinner_AddDepartment, spinner_AddRole;

	public View(Stage stg) throws Exception {

		//
		// -- main scene
		//

		mainGroup = new Group();
		mainScene = new Scene(mainGroup, 300, 210);

		button_scene_addDepaetment = new Button("add department");
		button_scene_addDepaetment.setTranslateX(10);
		button_scene_addDepaetment.setTranslateY(10);
		button_scene_addDepaetment.setMinWidth(120);
		button_scene_addDepaetment.setStyle("-fx-base: 	DODGERBLUE;");

		button_scene_ViewDepaetment = new Button("view Employees");
		button_scene_ViewDepaetment.setTranslateX(170);
		button_scene_ViewDepaetment.setTranslateY(90);
		button_scene_ViewDepaetment.setMinWidth(120);
		button_scene_ViewDepaetment.setStyle("-fx-base: 	DODGERBLUE;");

		button_scene_addEmployee = new Button("add Employee");
		button_scene_addEmployee.setTranslateX(10);
		button_scene_addEmployee.setTranslateY(90);
		button_scene_addEmployee.setMinWidth(120);
		button_scene_addEmployee.setStyle("-fx-base: 	DODGERBLUE;");

		button_scene_ViewEmployee = new Button("view Department");
		button_scene_ViewEmployee.setTranslateX(170);
		button_scene_ViewEmployee.setTranslateY(10);
		button_scene_ViewEmployee.setMinWidth(120);
		button_scene_ViewEmployee.setStyle("-fx-base: 	DODGERBLUE;");

		button_scene_addRole = new Button("Add Role");
		button_scene_addRole.setTranslateX(10);
		button_scene_addRole.setTranslateY(50);
		button_scene_addRole.setMinWidth(120);
		button_scene_addRole.setStyle("-fx-base: 	DODGERBLUE;");

		button_scene_ViewRole = new Button("view Roles");
		button_scene_ViewRole.setTranslateX(170);
		button_scene_ViewRole.setTranslateY(50);
		button_scene_ViewRole.setMinWidth(120);
		button_scene_ViewRole.setStyle("-fx-base: 	DODGERBLUE;");

		button_scene_DisplayData = new Button("Display info");
		button_scene_DisplayData.setTranslateX(10);
		button_scene_DisplayData.setTranslateY(150);
		button_scene_DisplayData.setMinWidth(129);
		button_scene_DisplayData.setStyle("-fx-base: 	DODGERBLUE;");

		button_scene_wageSimulation = new Button("Simulation");
		button_scene_wageSimulation.setTranslateX(10);
		button_scene_wageSimulation.setTranslateY(130);
		button_scene_wageSimulation.setMinWidth(120);
		button_scene_wageSimulation.setStyle("-fx-base: 	DODGERBLUE;");

		button_scene_results = new Button("Results");
		button_scene_results.setTranslateX(170);
		button_scene_results.setTranslateY(130);
		button_scene_results.setMinWidth(120);
		button_scene_results.setStyle("-fx-base: 	DODGERBLUE;");

		button_Reset_semulation = new Button("Reset simulation");
		button_Reset_semulation.setTranslateX(10);
		button_Reset_semulation.setTranslateY(170);
		button_Reset_semulation.setMinWidth(280);
		button_Reset_semulation.setStyle("-fx-base: red;");

		mainGroup.getChildren().addAll(button_scene_wageSimulation, button_scene_addDepaetment,
				button_scene_addEmployee, button_scene_ViewEmployee, button_scene_addRole, button_scene_ViewRole,
				button_scene_ViewDepaetment, button_scene_results, button_Reset_semulation);

		//
		// ---- add department ----
		//

		button_sceneMain_department = new Button("Back");
		button_sceneMain_department.setTranslateX(10);
		button_sceneMain_department.setTranslateY(210);

		vbox_spinner_AddDepartment = new VBox();
		labal_vbox_spinner_AddDepartment = new Label("plaese choose a starting hour: ");
		spinner_AddDepartment = new Spinner<>(6, 13, 9);
		vbox_spinner_AddDepartment.setTranslateX(10);
		vbox_spinner_AddDepartment.setTranslateY(150);
		vbox_spinner_AddDepartment.getChildren().addAll(labal_vbox_spinner_AddDepartment, spinner_AddDepartment);
		vbox_spinner_AddDepartment.setVisible(false);

		button_addDepartment = new Button("Add Department");
		button_addDepartment.setTranslateX(400);
		button_addDepartment.setTranslateY(210);

		vbox_department_Name = new VBox();
		label_Department_Name = new Label("please enter a department name:");
		TextField_Department_Name = new TextField();
		vbox_department_Name.getChildren().addAll(label_Department_Name, TextField_Department_Name);
		vbox_department_Name.setTranslateX(10);

		vbox_Depatment_checkbox_flexible_working = new VBox();
		label_department_checkbox_flexible_working = new Label("Is the department flexible with its working houers?");
		checkbox_department_checkbox_flexible_working = new CheckBox();
		vbox_Depatment_checkbox_flexible_working.getChildren().addAll(label_department_checkbox_flexible_working,
				checkbox_department_checkbox_flexible_working);
		vbox_Depatment_checkbox_flexible_working.setTranslateX(10);
		vbox_Depatment_checkbox_flexible_working.setTranslateY(50);

		vbox_Depatment_checkbox_Coordinated_hours = new VBox();
		label_department_checkbox_coordinated_hours = new Label("Does the department needs to coordinate its hours?");
		checkbox_department_checkbox_coordinated_hours = new CheckBox();
		vbox_Depatment_checkbox_Coordinated_hours.getChildren().addAll(label_department_checkbox_coordinated_hours,
				checkbox_department_checkbox_coordinated_hours);
		vbox_Depatment_checkbox_Coordinated_hours.setTranslateX(10);
		vbox_Depatment_checkbox_Coordinated_hours.setTranslateY(100);
		vbox_Depatment_checkbox_Coordinated_hours.setVisible(false);

		root_addDepartment = new Group();
		root_addDepartment.getChildren().addAll(vbox_spinner_AddDepartment, button_addDepartment, vbox_department_Name,
				vbox_Depatment_checkbox_flexible_working, vbox_Depatment_checkbox_Coordinated_hours,
				button_sceneMain_department);

		scene_addDepartment = new Scene(root_addDepartment, 600, 250);

		//
		// ---- add Employee ----
		//

		button_sceneMain_Employee = new Button("Back");
		button_sceneMain_Employee.setTranslateX(10);
		button_sceneMain_Employee.setTranslateY(400);

		vbox_employee_Department = new VBox();
		label_employee_Department = new Label("Please choose your Department:");
		combobox_employee_Department = new ComboBox<String>();
		vbox_employee_Department.getChildren().setAll(label_employee_Department, combobox_employee_Department);
		vbox_employee_Department.setTranslateX(10);

		vbox_Employee_Name = new VBox();
		label_Employee_Name = new Label("Please enter an employee's name:");
		TextField_Employee_Name = new TextField();
		vbox_Employee_Name.getChildren().addAll(label_Employee_Name, TextField_Employee_Name);
		vbox_Employee_Name.setTranslateX(10);
		vbox_Employee_Name.setTranslateY(50);

		vbox_Employee_ID = new VBox();
		label_Employee_ID = new Label("Please enter an employee's ID:");
		TextField_Employee_ID = new TextField();
		vbox_Employee_ID.getChildren().addAll(label_Employee_ID, TextField_Employee_ID);
		vbox_Employee_ID.setTranslateX(10);
		vbox_Employee_ID.setTranslateY(100);

		vbox_employee_gender = new VBox();
		label_employee_gender = new Label("Please enter your gender:");
		combobox_employee_gender = new ComboBox<>();
		combobox_employee_gender.getItems().addAll("Male", "Female", "Other");
		vbox_employee_gender.getChildren().setAll(label_employee_gender, combobox_employee_gender);
		vbox_employee_gender.setTranslateX(10);
		vbox_employee_gender.setTranslateY(150);

		vbox_employee_type = new VBox();
		label_employee_type = new Label("Please choose your type:");
		combobox_employee_type = new ComboBox<>();
		combobox_employee_type.getItems().addAll("Basic", "Hourly", "Basic + Sales");
		vbox_employee_type.getChildren().setAll(label_employee_type, combobox_employee_type);
		vbox_employee_type.setTranslateX(10);
		vbox_employee_type.setTranslateY(200);

		vbox_Employee_position = new VBox();
		label_Employee_position = new Label("Please choose an employee's role:");
		comboBox_Employee_Role = new ComboBox<>();
		vbox_Employee_position.getChildren().addAll(label_Employee_position, comboBox_Employee_Role);
		vbox_Employee_position.setTranslateX(10);
		vbox_Employee_position.setTranslateY(250);

		vbox_birthDate = new VBox();
		label_birthDate = new Label("Please pick a birth date:");
		datePicker_birthDate = new DatePicker();
		vbox_birthDate.getChildren().addAll(label_birthDate, datePicker_birthDate);
		vbox_birthDate.setTranslateX(10);
		vbox_birthDate.setTranslateY(300);

		vbox_employmentDate = new VBox();
		labal_employementDate = new Label("Please pick an employment date:");
		datePicker_employementDate = new DatePicker();
		vbox_employmentDate.getChildren().addAll(labal_employementDate, datePicker_employementDate);
		vbox_employmentDate.setTranslateX(10);
		vbox_employmentDate.setTranslateY(350);

		button_addEmployee = new Button("Add Employee");
		button_addEmployee.setTranslateX(400);
		button_addEmployee.setTranslateY(400);

		root_addEmployee = new Group();
		root_addEmployee.getChildren().addAll(vbox_employee_Department, vbox_employee_type, button_addEmployee,
				vbox_Employee_Name, vbox_Employee_ID, vbox_Employee_position, vbox_birthDate, vbox_employmentDate,
				vbox_employee_gender, button_sceneMain_Employee);
		scene_addEmployee = new Scene(root_addEmployee, 600, 450);

		//
		// ---- add role ----
		//

		vbox_role_Department = new VBox();
		label_role_Department = new Label("Please choose a Role's Department: ");
		combobox_role_Department = new ComboBox<String>();

		vbox_role_Department.getChildren().addAll(label_role_Department, combobox_role_Department);
		vbox_role_Department.setTranslateX(10);
		vbox_role_Department.setTranslateY(70);

		root_addRole = new Group();

		vbox_spinner_AddRole = new VBox();
		labal_vbox_spinner_AddRole = new Label("Plaese choose starting hour: ");
		spinner_AddRole = new Spinner<Integer>(6, 13, 9);
		vbox_spinner_AddRole.setTranslateX(260);
		vbox_spinner_AddRole.setTranslateY(125);
		vbox_spinner_AddRole.getChildren().addAll(labal_vbox_spinner_AddRole, spinner_AddRole);
		vbox_spinner_AddRole.setVisible(false);

		vbox_role_name = new VBox();
		vbox_role_name.setTranslateX(10);
		vbox_role_name.setTranslateY(10);
		label_role_name = new Label("Please enter a new role's name:");
		textField_role_name = new TextField();
		vbox_role_name.getChildren().addAll(label_role_name, textField_role_name);

		vbox_role_canChangeHours = new VBox();
		vbox_role_canChangeHours.setTranslateX(10);
		vbox_role_canChangeHours.setTranslateY(125);
		label_vbox_role_canChangeHours = new Label("Is the role's working-hours are flexible?");
		checkBox_vbox_role_canChangeHours = new CheckBox();
		vbox_role_canChangeHours.getChildren().addAll(label_vbox_role_canChangeHours,
				checkBox_vbox_role_canChangeHours);
		vbox_role_canChangeHours.setVisible(false);

		button_addRole = new Button("Add Role");
		button_addRole.setTranslateX(400);
		button_addRole.setTranslateY(200);
		button_sceneMain_role = new Button("Back");
		button_sceneMain_role.setTranslateX(10);
		button_sceneMain_role.setTranslateY(200);

		root_addRole.getChildren().addAll(vbox_spinner_AddRole, vbox_role_canChangeHours, vbox_role_Department,
				vbox_role_name, button_addRole, button_sceneMain_role);
		scene_addRole = new Scene(root_addRole, 480, 250);

		//
		// ---- VIEW DEPARTMENTS ----
		//
		button_sceneMain_view_Departments = new Button("Back");
		button_sceneMain_view_Departments.setTranslateX(10);
		button_sceneMain_view_Departments.setTranslateY(430);

		area_view_Departments = new TextArea();
		area_view_Departments.setWrapText(true);
		area_view_Departments.setEditable(false);
		area_view_Departments.setTranslateX(10);
		area_view_Departments.setTranslateY(10);
		area_view_Departments.setMinSize(400, 400);
		group_view_Departments = new Group();
		group_view_Departments.getChildren().addAll(area_view_Departments, button_sceneMain_view_Departments);

		scene_view_Departments = new Scene(group_view_Departments, 497, 470);

		//
		// ---- VIEW ROLES ----
		//
		button_sceneMain_view_roles = new Button("Back");
		button_sceneMain_view_roles.setTranslateX(10);
		button_sceneMain_view_roles.setTranslateY(430);

		area_view_roles = new TextArea();
		area_view_roles.setWrapText(true);
		area_view_roles.setEditable(false);
		area_view_roles.setTranslateX(10);
		area_view_roles.setTranslateY(10);
		area_view_roles.setMinSize(400, 400);
		group_view_roles = new Group();
		group_view_roles.getChildren().addAll(area_view_roles, button_sceneMain_view_roles);

		scene_view_roles = new Scene(group_view_roles, 497, 470);
		//
		// ---- view EMPLOYEES ----
		//
		button_sceneMain_view_EMPLOYEES = new Button("Back");
		button_sceneMain_view_EMPLOYEES.setTranslateX(10);
		button_sceneMain_view_EMPLOYEES.setTranslateY(430);

		area_view_EMPLOYEES_new = new TextArea();
		area_view_EMPLOYEES_new.setWrapText(true);
		area_view_EMPLOYEES_new.setEditable(false);
		area_view_EMPLOYEES_new.setTranslateX(10);
		area_view_EMPLOYEES_new.setTranslateY(10);
		area_view_EMPLOYEES_new.setMinSize(400, 400);

		group_view_EMPLOYEES = new Group();
		group_view_EMPLOYEES.getChildren().addAll(area_view_EMPLOYEES_new, button_sceneMain_view_EMPLOYEES);

		scene_view_EMPLOYEES = new Scene(group_view_EMPLOYEES, 497, 470);
		//
		// ---- SIMULATION ----
		//
		simulation_vbox = new VBox();
		simulation_vbox.setTranslateX(10);
		simulation_vbox.setTranslateY(10);
		comboBox_simulation_vbox_Department = new ComboBox<String>();
		label_simulation_vbox_Department = new Label("Please choose a Department");
		comboBox_simulation_vbox_Role = new ComboBox<String>();
		label_simulation_vbox_Role = new Label("Please choose a Role");
		label_simulation_vbox_Employee = new Label("Employee --> you haven't choose any role!");

		simulation_vbox_ComboBox = new VBox();
		label_simulation_vbox_combobox = new Label("Please choose a prefrence:  ");
		combobox_simulation_vbox_ComboBox = new ComboBox<String>();
		combobox_simulation_vbox_ComboBox.getItems().addAll("Default", "Home", "LateStart", "EarlyStart");
		simulation_vbox_ComboBox.getChildren().addAll(label_simulation_vbox_combobox,
				combobox_simulation_vbox_ComboBox);

		simulation_vbox_Spinner = new VBox();
		label_simulation_vbox_Spinner = new Label("Please choose a strting hour:  ");
		spinner_simulation = new Spinner<>(6, 13, 9);
		simulation_vbox_Spinner.getChildren().addAll(label_simulation_vbox_Spinner, spinner_simulation);
		simulation_vbox_Spinner.setVisible(false);

		simulation_vbox.setSpacing(10);
		simulation_vbox.getChildren().addAll(label_simulation_vbox_Department, comboBox_simulation_vbox_Department,
				label_simulation_vbox_Role, comboBox_simulation_vbox_Role, label_simulation_vbox_Employee,
				simulation_vbox_ComboBox, simulation_vbox_Spinner);

		button_sceneMain_simulation = new Button("Back");
		button_sceneMain_simulation.setTranslateX(10);
		button_sceneMain_simulation.setTranslateY(270);

		button_Save_Person_simulation = new Button("Save Person simulation");
		button_Save_Person_simulation.setTranslateX(150);
		button_Save_Person_simulation.setTranslateY(270);

		group_wageSimulation = new Group();
		group_wageSimulation.getChildren().addAll(simulation_vbox, button_sceneMain_simulation,
				button_Save_Person_simulation);
		scene_wageSimulation = new Scene(group_wageSimulation, 300, 300);

		//
		// ---- VIEW RESULTS ----
		//

		vBox_results = new VBox();
		vBox_results.setTranslateX(10);
		vBox_results.setTranslateY(10);
		label_results = new Label("The results:");
		label_results.setTextFill(Color.BLUEVIOLET);
		Font fontTableHeader = Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 18);
		label_results.setFont(fontTableHeader);
		textView_results = new TextArea();
		textView_results.setMinSize(400, 400);

		vBox_results.getChildren().addAll(label_results, textView_results);
		vBox_results.setVisible(false);

		button_back_ViewResults = new Button("Back");
		button_back_ViewResults.setTranslateX(10);
		button_back_ViewResults.setTranslateY(440);

		group_results = new Group();
		group_results.getChildren().addAll(vBox_results, button_back_ViewResults);
		scene_results = new Scene(group_results, 497, 470);

		//
		// ---- STAGE ----
		//

		this.stg = stg;
		stg.setResizable(false);
		stg.setScene(mainScene);
		stg.setTitle("Simulation Program");
		stg.show();
	}

	public TextArea getArea_view_EMPLOYEES_new() {
		return area_view_EMPLOYEES_new;
	}

	public Spinner<Integer> getSpinner_simulation() {
		return spinner_simulation;
	}

	public Label getLabel_simulation_vbox_Employee() {
		return label_simulation_vbox_Employee;
	}

	public TextArea getTextView_results() {
		return textView_results;
	}

	public Button getNextPerson() {
		return nextPerson;
	}

	public VBox getvBox_results() {
		return vBox_results;
	}

	public VBox getSimulation_vbox() {
		return simulation_vbox;
	}

	public VBox getVbox_role_canChangeHours() {
		return vbox_role_canChangeHours;
	}

	public CheckBox getCheckBox_vbox_role_canChangeHours() {
		return checkBox_vbox_role_canChangeHours;
	}

	public ComboBox<String> getCombobox_simulation_vbox_ComboBox() {
		return combobox_simulation_vbox_ComboBox;
	}

	public VBox getSimulation_vbox_Spinner() {
		return simulation_vbox_Spinner;
	}

	public VBox getVbox_spinner_AddRole() {
		return vbox_spinner_AddRole;
	}

	public Spinner<Integer> getSpinner_AddDepartment() {
		return spinner_AddDepartment;
	}

	public VBox getVbox_Depatment_checkbox_Coordinated_hours() {
		return vbox_Depatment_checkbox_Coordinated_hours;
	}

	public VBox getVbox_Depatment_checkbox_flexible_working() {
		return vbox_Depatment_checkbox_flexible_working;
	}

	public VBox getVbox_spinner_AddDepartment() {
		return vbox_spinner_AddDepartment;
	}

	public ComboBox<String> getCombobox_role_Department() {
		return combobox_role_Department;
	}

	//
	// ---- GETTERS ----
	//
	public ComboBox<String> getCombobox_employee_Department() {
		return combobox_employee_Department;
	}

	public ComboBox<String> getComboBox_Employee_Role() {
		return comboBox_Employee_Role;
	}

	public Scene getMainScene() {
		return mainScene;
	}

	//
	// ---- DEPARTMENT GETTERS ----
	//
	public String get_Department_name() throws emptyException {
		String st = TextField_Department_Name.getText();
		if (!st.isEmpty())
			return st;
		else
			throw new emptyException();
	}

	public boolean get_department_flexible_working() {
		if (checkbox_department_checkbox_flexible_working.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean get_department_coordinated_hours() {
		if (checkbox_department_checkbox_coordinated_hours.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	//
	// ---- EMPLOYEE GETTERS ----
	//

	public String get_employeeName() throws emptyException {
		String string = TextField_Employee_Name.getText();
		if (!string.isEmpty()) {
			return string;
		} else {
			throw new emptyException();
		}
	}

	public String get_employeeID() throws IDExeption {
		String string = TextField_Employee_ID.getText();
		if (checkID(string)) {
			return string;
		} else {
			throw new IDExeption();
		}
	}

	private boolean checkID(String string) {
		if (string.length() != 9)
			return false;
		else {
			for (int i = 0; i < 9; i++) {
				if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public String get_employeeGender() throws nullException {
		String string = combobox_employee_gender.getValue();
		if (string != null) {
			return string;
		} else {
			throw new nullException();
		}
	}

	public String get_roles_Department() {
		return combobox_role_Department.getValue();
	}

	public String get_employeeDepartment() {
		return combobox_employee_Department.getValue();
	}

	public LocalDate get_employeeBirthDate() throws ageException, nullException {
		LocalDate date = datePicker_birthDate.getValue();
		if (ageException(date)) {
			return date;
		} else if (date == null) {
			throw new nullException();
		} else {
			throw new ageException();
		}
	}

	private boolean ageException(LocalDate date) {
		LocalDate now = LocalDate.now();
		LocalDate eighteenYearsAgo = now.minusYears(18);
		if (eighteenYearsAgo.isBefore(date)) {
			return false;
		} else {
			return true;
		}
	}

	public LocalDate get_employeeAddedDate() throws nullException, futureException {
		LocalDate date = datePicker_employementDate.getValue();
		LocalDate now = LocalDate.now();
		if (date.isBefore(now)) {
			return date;
		} else {
			throw new futureException();

		}
	}

	public String get_employeeRole() {
		return comboBox_Employee_Role.getValue();
	}

	public String get_name_role() throws emptyException {
		String string = textField_role_name.getText();
		if (!string.isEmpty()) {
			return string;
		} else {
			throw new emptyException();
		}

	}

	public String get_emmployee_type() {
		return combobox_employee_type.getValue();
	}

	//
	// ---- ACTIONS ----
	//

	public void button_scene_results(EventHandler<ActionEvent> event) {
		button_scene_results.setOnAction(event);
	}

	public void combobox_employee_Department(EventHandler<ActionEvent> event) {
		combobox_employee_Department.setOnAction(event);
	}

	public void checkbox_department_checkbox_flexible_working(ChangeListener<Boolean> listener) {
		checkbox_department_checkbox_flexible_working.selectedProperty().addListener(listener);
	}

	public void checkbox_department_checkbox_coordinated_hours(ChangeListener<Boolean> listener) {
		checkbox_department_checkbox_coordinated_hours.selectedProperty().addListener(listener);
	}

	public void checkBox_vbox_role_canChangeHours(ChangeListener<Boolean> listener) {
		checkBox_vbox_role_canChangeHours.selectedProperty().addListener(listener);
	}

	public void comboBox_simulation_vbox_Department(ChangeListener<String> listener) {
		comboBox_simulation_vbox_Department.valueProperty().addListener(listener);
	}

	public void combobox_employee_Department(ChangeListener<String> listener) {
		combobox_employee_Department.valueProperty().addListener(listener);
	}

	public void combobox_role_Department(ChangeListener<String> listener) {
		combobox_role_Department.valueProperty().addListener(listener);
	}

	public void combobox_simulation_vbox_ComboBox(ChangeListener<String> listiner) {
		combobox_simulation_vbox_ComboBox.valueProperty().addListener(listiner);
	}

	public void combobox_simulation_vbox_Role(ChangeListener<String> listiner) {
		comboBox_simulation_vbox_Role.valueProperty().addListener(listiner);
	}

	public void button_scene_ViewEmployee(EventHandler<ActionEvent> event) {
		button_scene_ViewDepaetment.setOnAction(event);
	}

	public void button_scene_ViewRoles(EventHandler<ActionEvent> event) {
		button_scene_ViewRole.setOnAction(event);
	}

	public void button_scene_ViewDepaetment(EventHandler<ActionEvent> event) {
		button_scene_ViewEmployee.setOnAction(event);
	}

	public void button_employee_dispaly(EventHandler<ActionEvent> event) {
		button_Employee_toString.setOnAction(event);
	}

	public void button_role_dispaly(EventHandler<ActionEvent> event) {
		button_Role_toString.setOnAction(event);
	}

	public void button_departmet_display(EventHandler<ActionEvent> event) {
		button_department_toString.setOnAction(event);
	}

	public void button_sceneMain_department(EventHandler<ActionEvent> event) {
		button_sceneMain_department.setOnAction(event);
	}

	public void button_sceneMain_Employee(EventHandler<ActionEvent> event) {
		button_sceneMain_Employee.setOnAction(event);
	}

	public void button_sceneMain_role(EventHandler<ActionEvent> event) {
		button_sceneMain_role.setOnAction(event);
	}

	public void button_sceneMain_wage(EventHandler<ActionEvent> event) {
		button_sceneMain_simulation.setOnAction(event);
	}

	public void button_sceneMain_viewDepartments(EventHandler<ActionEvent> event) {
		button_sceneMain_view_Departments.setOnAction(event);
	}

	public void button_sceneMain_viewRoles(EventHandler<ActionEvent> event) {
		button_sceneMain_view_roles.setOnAction(event);
	}

	public void button_sceneMain_viewEMPLOYEES(EventHandler<ActionEvent> event) {
		button_sceneMain_view_EMPLOYEES.setOnAction(event);
	}

	public void button_changeScene_department(EventHandler<ActionEvent> event) {
		button_scene_addDepaetment.setOnAction(event);
	}

	public void button_changeScene_emplyee(EventHandler<ActionEvent> event) {
		button_scene_addEmployee.setOnAction(event);
	}

	public void button_changeScene_role(EventHandler<ActionEvent> event) {
		button_scene_addRole.setOnAction(event);
	}

	public void button_changeScene_date(EventHandler<ActionEvent> event) {
		button_scene_DisplayData.setOnAction(event);
	}

	public void button_changeScene_wage(EventHandler<ActionEvent> event) {
		button_scene_wageSimulation.setOnAction(event);
	}

	public void button_addDepartment(EventHandler<ActionEvent> event) {
		button_addDepartment.setOnAction(event);
	}

	public void buttom_addRole(EventHandler<ActionEvent> event) {
		button_addRole.setOnAction(event);
	}

	public void buttom_addEmployee(EventHandler<ActionEvent> event) {
		button_addEmployee.setOnAction(event);
	}

	public void button_Reset_semulation(EventHandler<ActionEvent> event) {
		button_Reset_semulation.setOnAction(event);
	}

	public void button_Save_Person_simulation(EventHandler<ActionEvent> event) {
		button_Save_Person_simulation.setOnAction(event);
	}

	public void button_READ(EventHandler<ActionEvent> event) {
		button_READ.setOnAction(event);
	}

	//
	// -- set scene --
	//

	public void setScene_main() {
		stg.setScene(mainScene);
	}

	public void setScene_results() {
		stg.setScene(scene_results);
	}

	public void setScene_viewDepartment() {
		stg.setScene(scene_view_Departments);
	}

	public void setScene_viewRoles() {
		stg.setScene(scene_view_roles);
	}

	public void setScene_viewEMPLOYEES() {
		stg.setScene(scene_view_EMPLOYEES);
	}

	public void setScene_Department() {
		stg.setScene(scene_addDepartment);
	}

	public void setScene_employee() {
		stg.setScene(scene_addEmployee);
	}

	public void setScene_role() {
		stg.setScene(scene_addRole);
	}

	public void setScene_data() {
		stg.setScene(scene_Display);
	}

	public void setScene_wage() {
		stg.setScene(scene_wageSimulation);
	}

	//
	// ---- SETTERS ----
	//

	public void set_text_view_departments(String string) {
		area_view_Departments.appendText(string);
	}

	public void set_text_view_roles(String string) {
		area_view_roles.appendText(string);
	}

	public void set_comboBox_over_arrylist_roles_department(ArrayList<Department> d, ComboBox<String> c) {
		for (int i = 0; i < d.size(); i++) {
			c.getItems().add(d.get(i).getDepatmentName());
		}

	}

	public void set_comboBox_over_arrylist_department(ArrayList<Department> d, ComboBox<String> c) {
		for (int i = 0; i < d.size(); i++) {
			c.getItems().add(d.get(i).getDepatmentName());
		}

	}

	public void set_comboBox_over_arrylist_role(ArrayList<Role> d, ComboBox<String> c) {
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i).isOccupied() == false) {
				c.getItems().add(d.get(i).getRole_name());
			}

		}

	}

	public void set_comboBox_over_arrylist_role_simulation(ArrayList<Role> d, ComboBox<String> c) {
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i).isOccupied()) {
				c.getItems().add(d.get(i).getRole_name());
			}

		}

	}

	//
	// ---- RESETS ----
	//
	public void reset_employee() {
		TextField_Employee_Name.clear();
		TextField_Employee_ID.clear();
		combobox_employee_Department.getSelectionModel().clearSelection();
		combobox_employee_gender.getSelectionModel().clearSelection();
		combobox_employee_type.getSelectionModel().clearSelection();
		datePicker_birthDate.getEditor().clear();
		datePicker_employementDate.getEditor().clear();
		comboBox_Employee_Role.getSelectionModel().clearSelection();
		comboBox_Employee_Role.getItems().clear();
	}

	public void reset_deprtment() {
		TextField_Department_Name.clear();
		checkbox_department_checkbox_coordinated_hours.setSelected(false);
		checkbox_department_checkbox_flexible_working.setSelected(false);
		vbox_Depatment_checkbox_Coordinated_hours.setVisible(false);
		vbox_spinner_AddDepartment.setVisible(false);
	}

	public CheckBox getCheckbox_department_checkbox_coordinated_hours() {
		return checkbox_department_checkbox_coordinated_hours;
	}

	public void reset_role() {
		textField_role_name.clear();
		combobox_role_Department.getSelectionModel().clearSelection();
	}

	public void set_view_roles_ampty() {
		area_view_roles.clear();

	}

	public void set_view_departments_ampty() {
		area_view_Departments.clear();
	}

	public void reset_employee_back() {
		TextField_Employee_Name.clear();
		TextField_Employee_ID.clear();
		datePicker_birthDate.getEditor().clear();
		datePicker_employementDate.getEditor().clear();
		combobox_employee_Department.getItems().clear();
	}

	public void reset_combobox_add_role() {
		combobox_role_Department.getItems().clear();
	}

	//
	// -- functions --
	//
	public void alert(String msg) {
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText("Somthing went wrong");
		errorAlert.setContentText(msg);
		errorAlert.showAndWait();
	}

	public Spinner<Integer> getSpinner_AddRole() {
		return spinner_AddRole;
	}

	public Label getLabal_vbox_spinner_AddRole() {
		return labal_vbox_spinner_AddRole;
	}

	public ComboBox<String> getComboBox_simulation_vbox_Department() {
		return comboBox_simulation_vbox_Department;
	}

	public ComboBox<String> getComboBox_simulation_vbox_Role() {
		return comboBox_simulation_vbox_Role;
	}

	public ComboBox<String> getComboBox_simulation_vbox_Employee() {
		return comboBox_simulation_vbox_Employee;
	}

	public Scene getScene_results() {
		return scene_results;
	}

	public void button_back_ViewResults(EventHandler<ActionEvent> action) {
		button_back_ViewResults.setOnAction(action);

	}

}
