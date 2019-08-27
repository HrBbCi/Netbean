package ass2;

import userlib.DomainConstraint;

/**
 * @author Trinh Minh Nhat
 *
 * @overview:
 * 
 * <pre>
 * 				an electronic device for storing and processing data,
 *                 typically in binary form, according to instructions given
 *                 to it in a variable program.
 * @attribute:
 * 
 *             <pre>
 *             model String String year Integer int manufacturer String
 *             String components Set Set
 *
 * @Object:
 * 
 *          <pre>
 *          A typical PC : < m , y, man, c> where model(m), year(y),
 *          manufacture(man), components(c);
 *
 * @abtract_properties:
 * 
 *                      <pre>
 *                      mutable(model) = true /\ optional = false /\ length
 *                      = 20 /\ mutable(year) = false /\ optional = false /\
 *                      min = 1940 /\ mutable(manufacture) = false /\ option
 *                      = false /\ length = 20 /\ mutable(components) = true
 *                      /\ optional = false.
 */


public class PC {

	
	@DomainConstraint(type = "String", mutable = true, optional = false, length = 20)
	private String model;

	@DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1940)
	private int year;

	@DomainConstraint(type = "String", mutable = true, optional = false)
	private String manufacturer;

	@DomainConstraint(type = "String", mutable = true, optional = true)
	private Set component;

	public PC() {

	}

	/**
	 * @effects:
	 * 
	 *           <pre>
	 *           if model, year, manufacture are valid, initialise this as
	 *           <model, year, manufacture> else initialise this as <> and print
	 *           error.
	 */
	public PC(String model, int year, String man, Set component) {
		if (validateModel(model)) {
			this.model = model;
		} else {
			System.err.println("Invalid model, man!! " + model);
			
		}
		if (validateYear(year)) {
			this.year = year;
		} else {
			System.err.println("Invalid year, man!! " + year);
			
		}
		if (validateMan(man)) {
			this.manufacturer = man;
		} else {
			System.err.println("Invalid manufacture, man!! " + man);
		}
		if (validateComponent(component)) {
			this.component = component;
		} else {
			System.out.println("Invalid Component, man!!" + component);
		}

	}

	
	/**
	 * @modifies: this.model;
	 * @effect: if model is valid, set this.model = model, else do nothing;
	 */
	public void setModel(String model) {
		if (validateModel(model)) {
			this.model = model;
		}
	}

	public void setComponent(Set component) {
		if (validateComponent(component)) {
			this.component = component;
		}
	}

	/**
	 * @effect: return model;
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @effect: return year;
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @effect: return manufacture;
	 */
	public String getMan() {
		return manufacturer;
	}

	/**
	 * @effect: return component.
	 */
	public Set component() {
		return component();
	}

	/**
	 * @effect: if model is valid, return true, else return false;
	 */
	private boolean validateModel(String model) {
		if (model != null && model.length() <= 20) {
			return true;
		}
		return false;
	}

	/**
	 * @effect: if year is valid return true, else return false;
	 */
	private boolean validateYear(int year) {
		if (year >= 1940) {
			return true;
		}
		return false;
	}

	/**
	 * @effect: if manufacture is valid, return true, false return false;
	 */
	private boolean validateMan(String man) {
		if (man != null && man.length() <= 20) {
			return true;
		}
		return false;
	}

	/**
	 *
	 * @effect: if components is valid, return true, false return false;
	 */
	private boolean validateComponent(Set component) {
		if (component != null) {
			return true;
		}
		return false;
	}

	/**
	 * @effect:
	 * 
	 *          <pre>
	 *          takes information out the console screen. Use printf() and try -
	 *          catch();
	 */

	public void display() {
		try {
			System.out.printf("\n%-15s %-15s %-20s %-20s", model, year, manufacturer, component.toString());
		} catch (NullPointerException e) {
			System.out.printf("Data null!");
		}
	}

}
