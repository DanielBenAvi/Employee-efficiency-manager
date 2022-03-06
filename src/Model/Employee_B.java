package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee_B extends Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Employee_B(String employeeNeme, String iD, String gender, LocalDate empployeeAddedDate,
			LocalDate employeeBirthDate) {
		super(employeeNeme, iD, gender, empployeeAddedDate, employeeBirthDate);
		
	}

}
