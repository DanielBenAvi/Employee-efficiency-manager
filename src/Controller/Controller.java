package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Exception.IDExeption;
import Exception.ageException;
import Exception.emptyException;
import Exception.futureException;
import Exception.nullException;
import Model.Model;
import Model.Prefrence;
import View.View;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {

	public Controller(Model model, View view) {

		//
		// -- change scene to main form view results
		//

		EventHandler<ActionEvent> button_back_ViewResults = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene_main();
			}
		};
		view.button_back_ViewResults(button_back_ViewResults);

		//
		// -- change scenes to main form add department
		//

		EventHandler<ActionEvent> change_scene_main_from_AddDepartment = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene_main();
				view.reset_deprtment();
			}
		};
		view.button_sceneMain_department(change_scene_main_from_AddDepartment);

		//
		// -- change scenes to main form add employee
		//

		EventHandler<ActionEvent> change_scene_main_from_AddEmployee = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				try {
					view.setScene_main();
					view.reset_employee_back();
				} catch (Exception e) {
				}

			}
		};
		view.button_sceneMain_Employee(change_scene_main_from_AddEmployee);

		//
		// -- change scenes to main form view employee
		//

		EventHandler<ActionEvent> change_scene_main_from_viewEmployee = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene_main();
				view.getArea_view_EMPLOYEES_new().clear();
				;
			}
		};
		view.button_sceneMain_viewEMPLOYEES(change_scene_main_from_viewEmployee);

		//
		// -- change scenes to main form view departments
		//

		EventHandler<ActionEvent> change_scene_main_from_ViewDepartment = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene_main();
				view.set_view_departments_ampty();
			}
		};
		view.button_sceneMain_viewDepartments(change_scene_main_from_ViewDepartment);

		//
		// -- change scenes to main form view roles
		//

		EventHandler<ActionEvent> change_scene_main_from_ViewRoles = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene_main();
				view.set_view_roles_ampty();
			}
		};
		view.button_sceneMain_viewRoles(change_scene_main_from_ViewRoles);

		//
		// -- change scenes to main form add role
		//

		EventHandler<ActionEvent> change_scene_main_from_role = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene_main();
				view.reset_combobox_add_role();
			}
		};
		view.button_sceneMain_role(change_scene_main_from_role);

		//
		// -- change scenes to main form add simulation
		//

		EventHandler<ActionEvent> change_scene_main_from_wage = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene_main();
				view.getComboBox_simulation_vbox_Department().getItems().clear();
				view.getCombobox_simulation_vbox_ComboBox().getSelectionModel().clearSelection();
			}
		};
		view.button_sceneMain_wage(change_scene_main_from_wage);

		//
		// -- change scene from main to view Department
		//

		EventHandler<ActionEvent> change_scene_viewDepartment_from_main = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene_viewDepartment();
				view.set_text_view_departments(model.displayDipartment());
			}
		};
		view.button_scene_ViewDepaetment(change_scene_viewDepartment_from_main);

		//
		// -- change scene from main to view roles
		//

		EventHandler<ActionEvent> change_scene_viewRoles_from_main = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene_viewRoles();
				view.set_text_view_roles(model.displayRoles());

			}
		};
		view.button_scene_ViewRoles(change_scene_viewRoles_from_main);

		EventHandler<ActionEvent> change_scene_viewEmployees_from_main = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				try {
					view.setScene_viewEMPLOYEES();
					view.getArea_view_EMPLOYEES_new().setText(model.displayEmployees());
				} catch (NullPointerException npe) {
				}
			}
		};
		view.button_scene_ViewEmployee(change_scene_viewEmployees_from_main);

		EventHandler<ActionEvent> button_scene_results = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				try {
					view.setScene_results();
					view.getvBox_results().setVisible(true);
//					model.calc_department_efficiency();
					view.getTextView_results().setText(model.Display_results_new());

				} catch (NullPointerException e) {
				} catch (Exception e) {
				}

			}
		};
		view.button_scene_results(button_scene_results);

		//
		// -- change from main to add
		//

		EventHandler<ActionEvent> change_scene_department = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene_Department();

			}
		};
		view.button_changeScene_department(change_scene_department);

		EventHandler<ActionEvent> change_scene_employee = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				view.setScene_employee();
				view.set_comboBox_over_arrylist_department(model.getDepartments(),
						view.getCombobox_employee_Department());

			}
		};
		view.button_changeScene_emplyee(change_scene_employee);

		EventHandler<ActionEvent> change_scene_role = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				view.setScene_role();
				view.set_comboBox_over_arrylist_roles_department(model.getDepartments(),
						view.getCombobox_role_Department());
			}
		};
		view.button_changeScene_role(change_scene_role);

		//
		// --- simulation ---
		//

		ChangeListener<String> comboBox_simulation_vbox_Department = new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try {
					view.getComboBox_simulation_vbox_Role().getItems().clear();
					String departentName = view.getComboBox_simulation_vbox_Department().getValue();
					int i = model.findDepartment(departentName);
					view.set_comboBox_over_arrylist_role_simulation(
							model.companies.get(0).getDepartments().get(i).getRoles(),
							view.getComboBox_simulation_vbox_Role());
				} catch (IndexOutOfBoundsException ie) {
				} catch (Exception e) {
				}

			}

		};
		view.comboBox_simulation_vbox_Department(comboBox_simulation_vbox_Department);

		ChangeListener<String> comboBox_simulation_vbox_Role = new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try {
					view.getLabel_simulation_vbox_Employee().setText("Employee --> you haven't choose any role!");
					String departentName = view.getComboBox_simulation_vbox_Department().getValue();
					int i = model.findDepartment(departentName);
					String RoleName = view.getComboBox_simulation_vbox_Role().getValue();
					int j = model.findRole(RoleName, departentName);
					view.getLabel_simulation_vbox_Employee().setText("Employee: " + model.companies.get(0)
							.getDepartments().get(i).getRoles().get(j).getEmployee().getEmployeeName());

				} catch (IndexOutOfBoundsException ie) {
				} catch (Exception e) {
				}

			}

		};
		view.combobox_simulation_vbox_Role(comboBox_simulation_vbox_Role);

		EventHandler<ActionEvent> change_scene_Simulation = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {

				view.setScene_wage();
				view.set_comboBox_over_arrylist_department(model.companies.get(0).getDepartments(),
						view.getComboBox_simulation_vbox_Department());

			}
		};
		view.button_changeScene_wage(change_scene_Simulation);

		ChangeListener<String> listiner_combobox_simulation_vbox_ComboBox = new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try {
					view.getSimulation_vbox_Spinner().setVisible(false);
					if (view.getCombobox_simulation_vbox_ComboBox().getValue().equals("Default")) {
						view.getSimulation_vbox_Spinner().setVisible(false);
					} else {
						view.getSimulation_vbox_Spinner().setVisible(true);
					}
				} catch (IndexOutOfBoundsException ie) {
				} catch (Exception e) {
				}
			}
		};
		view.combobox_simulation_vbox_ComboBox(listiner_combobox_simulation_vbox_ComboBox);

		EventHandler<ActionEvent> button_Reset_semulation = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				try {
					model.resetCalculation();
					view.getTextView_results().clear();
				} catch (NullPointerException npe) {
				} catch (Exception e) {
				}

			}

		};
		view.button_Reset_semulation(button_Reset_semulation);

		EventHandler<ActionEvent> button_Save_Person_simulation = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				try {
					int departmentPlacement = model
							.findDepartment(view.getComboBox_simulation_vbox_Department().getValue());
					int rolePlacement = model.findRole(view.getComboBox_simulation_vbox_Role().getValue(),
							view.getComboBox_simulation_vbox_Department().getValue());
					String prefrance = view.getCombobox_simulation_vbox_ComboBox().getValue();
					int hour = view.getSpinner_simulation().getValue();
					model.simultionNew(departmentPlacement, rolePlacement, prefrance, hour);
					String prefrence = view.getCombobox_simulation_vbox_ComboBox().getValue();
					if (prefrence.equals("LateStart")) {
						model.companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement)
								.getEmployee().setPrefrence(Prefrence.LateStart);
					} else if (prefrence.equals("EarlyStart")) {
						model.companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement)
								.getEmployee().setPrefrence(Prefrence.EarlyStart);
					} else if (prefrence.equals("Home")) {
						model.companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement)
								.getEmployee().setPrefrence(Prefrence.Home);
					} else if (prefrence.equals("Default")) {
						model.companies.get(0).getDepartments().get(departmentPlacement).getRoles().get(rolePlacement)
								.getEmployee().setPrefrence(Prefrence.Default);
					}
					model.calc_department_efficiency();
					model.calc_company_efficiency();
					view.getComboBox_simulation_vbox_Department().getSelectionModel().clearSelection();
					view.getComboBox_simulation_vbox_Role().getSelectionModel().clearSelection();
					view.getCombobox_simulation_vbox_ComboBox().getSelectionModel().clearSelection();
				} catch (IndexOutOfBoundsException ee) {
				} catch (Exception e) {
				}

			}

		};
		view.button_Save_Person_simulation(button_Save_Person_simulation);

		//
		// ---- add department
		//
		EventHandler<ActionEvent> addDepartment = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				try {
					model.addDepartment(view.get_Department_name(), view.get_department_flexible_working(),
							view.get_department_coordinated_hours(), view.getSpinner_AddDepartment().getValue());
					view.reset_deprtment();
				} catch (emptyException ee) {
					view.alert("Some fields are empty");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		view.button_addDepartment(addDepartment);

		ChangeListener<Boolean> checkbox_department_checkbox_flexible_working = new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				try {

					if (view.get_department_flexible_working()) {
						view.getVbox_Depatment_checkbox_Coordinated_hours().setVisible(true);
					} else {
						view.getVbox_Depatment_checkbox_Coordinated_hours().setVisible(false);
						view.getCheckbox_department_checkbox_coordinated_hours().setSelected(false);

						view.getVbox_spinner_AddDepartment().setVisible(false);
						view.getSpinner_AddDepartment().getValueFactory().setValue(9);

					}

				} catch (IndexOutOfBoundsException ie) {
				} catch (Exception e) {
				}

			}

		};
		view.checkbox_department_checkbox_flexible_working(checkbox_department_checkbox_flexible_working);

		ChangeListener<Boolean> Vbox_Depatment_checkbox_Coordinated_hours = new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				try {
					if (view.get_department_coordinated_hours()) {
						view.getVbox_spinner_AddDepartment().setVisible(true);
					} else {
						view.getVbox_spinner_AddDepartment().setVisible(false);
						view.getSpinner_AddDepartment().getValueFactory().setValue(9);
					}

				} catch (IndexOutOfBoundsException ie) {
				} catch (Exception e) {
				}

			}

		};
		view.checkbox_department_checkbox_coordinated_hours(Vbox_Depatment_checkbox_Coordinated_hours);

		//
		// ---- add role
		//

		EventHandler<ActionEvent> addRolEventHandler = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				try {
					model.addRole(view.get_name_role(), view.get_roles_Department(),
							view.getSpinner_AddRole().getValue(),
							view.getCheckBox_vbox_role_canChangeHours().isSelected());
					view.reset_role();
				} catch (emptyException ee) {
					view.alert("You Haven't Entered A Role Name");
				} catch (IndexOutOfBoundsException e) {
					view.alert("You Haven't chose Any Department!");
				}

			}
		};
		view.buttom_addRole(addRolEventHandler);

		EventHandler<ActionEvent> resetRoles = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				view.getComboBox_Employee_Role().getItems().clear();
			}
		};
		view.buttom_addEmployee(resetRoles);

		ChangeListener<String> listener_combobox_role_Department = new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try {
					String departentName = view.get_roles_Department();
					view.getVbox_role_canChangeHours().setVisible(false);
					view.getVbox_spinner_AddRole().setVisible(false);

					view.getCheckBox_vbox_role_canChangeHours().setSelected(false);
					int i = model.findDepartment(departentName);
					if (model.companies.get(0).getDepartments().get(i).isFlexible_working()) {
						if (!model.companies.get(0).getDepartments().get(i).isCoordinated_hours()) {
							view.getVbox_role_canChangeHours().setVisible(true);
						}

					}
				} catch (IndexOutOfBoundsException ie) {

				} catch (Exception e) {
				}

			}

		};
		view.combobox_role_Department(listener_combobox_role_Department);

		ChangeListener<Boolean> checkBox_vbox_role_canChangeHours = new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				try {
					view.getVbox_spinner_AddRole().setVisible(false);
					if (view.getCheckBox_vbox_role_canChangeHours().isSelected()) {
						view.getVbox_spinner_AddRole().setVisible(true);
					}

				} catch (IndexOutOfBoundsException ie) {
				} catch (Exception e) {
				}

			}

		};
		view.checkBox_vbox_role_canChangeHours(checkBox_vbox_role_canChangeHours);

		//
		// ---- add employee
		//

		EventHandler<ActionEvent> addEmployee = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				try {
					model.addEmployee(view.get_employeeName(), view.get_employeeID(), view.get_employeeGender(),
							view.get_employeeBirthDate(), view.get_employeeAddedDate(), view.get_employeeRole(),
							view.get_emmployee_type(), view.get_employeeDepartment());
					view.reset_employee();

				} catch (emptyException e) {
					view.alert("Some Fields Are Empty!");
				} catch (IDExeption e) {
					view.alert("The ID Is Invalid!");
				} catch (IndexOutOfBoundsException e) {
					view.alert("Some Fields Aren't Checked!");
				} catch (nullException e) {
					view.alert("Some Fields Aren't Checked!");
				} catch (NullPointerException e) {
					view.alert("Some Fields Aren't Checked!");
				} catch (ageException e) {
					view.alert("You can't add underAge employee!");
				} catch (futureException e) {
					view.alert("You can't Add Future Date!");
				} catch (Exception e) {
					view.alert("Something is wrong!");
				}

			}

		};
		view.buttom_addEmployee(addEmployee);

		ChangeListener<String> set_Employee_roles_over_arrays1 = new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				try {
					view.getComboBox_Employee_Role().getItems().clear();
					String departentName = view.get_employeeDepartment();
					int i = model.findDepartment(departentName);
					view.set_comboBox_over_arrylist_role(model.companies.get(0).getDepartments().get(i).getRoles(),
							view.getComboBox_Employee_Role());
				} catch (IndexOutOfBoundsException ie) {
				} catch (Exception e) {
				}

			}

		};
		view.combobox_employee_Department(set_Employee_roles_over_arrays1);

		//
		// --- save ---
		//
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			public void run() {
				ObjectOutputStream outFile = null;
				try {
					outFile = new ObjectOutputStream(new FileOutputStream("Data.data"));

				} catch (FileNotFoundException e1) {
					System.out.println("File not found");
					e1.printStackTrace();
				} catch (IOException e1) {
					System.out.println("Input Output exception");
					e1.printStackTrace();
				}
				try {
					model.saveAll(outFile);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}));

	}

}
