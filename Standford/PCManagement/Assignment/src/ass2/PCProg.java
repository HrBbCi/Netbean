package ass2;

import java.util.ArrayList;
import java.util.Scanner;
import userlib.TextIO;

/**
 * @author Trinh Minh Nhat
 *
 * @overview:
 * 
 *            <pre>
 *            PCProg is the main class that describe how two class PC and Set
 *            interact with each other.
 */
public class PCProg {

	/**
	 *
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// create an array-list that contains complicated information.
		ArrayList<PC> allPC = new ArrayList<>();
		PCProg pcprog = new PCProg();
		Scanner sc = new Scanner(System.in);
		int test;
		int option = 0;
		/**
		 * @overview:
		 * 
		 * <pre>
		 * 				A loop do - while was use to response the conditions:
		 *                 Y/N from users;
		 * 
		 * @effect:
		 * 
		 *          <pre>
		 *          int test = 0; String a; if String a = 'n', test =1, then,
		 *          end do-while loop;
		 */
		do {
			/**
			 * @require:
			 * 
			 *           <pre>
			 *           String model /\ int year /\ String man
			 * @effect:
			 * 
			 *          <pre>
			 *          allow user to input model, year, manufacture and
			 *          components. initialize pc as <model, year, man, set>;
			 */

			System.out.print("Input your PC's model: ");
			String model = sc.nextLine();
			System.out.print("Input year: ");
			int year = Integer.parseInt(sc.nextLine());
			System.out.print("Input manufacturer: ");
			String man = sc.nextLine();
			// create new Set, named set;
			Set set = new Set();

			System.out.println("+------------------------------------------------------+");
			System.out.println("|                       OPTIONS                        |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("| 1. Enter number 1 to skip inputting components:      |");
			System.out.println("| 2. Enter number 2 to add components:                 |");
			System.out.println("| 3. Enter number 4 to save program into pcs.txt:      |");
			System.out.println("+------------------------------------------------------+");

			System.out.print("Input your options: ");
			option = Integer.parseInt(sc.nextLine());

			/**
			 * @overview:
			 * 
			 *            <pre>
			 *            Switch- case option, 3 cases that allow user to
			 *            select.
			 * @effect:
			 * 
			 *          <pre>
			 *          Case1: skip swich- case option. Case2: called method
			 *          insert from class Set; Case3: Called method remove from
			 *          class Set; Case4: Called method saveReport from class
			 *          PCProg;
			 */
			switch (option) {
			
			case 1: 
				break;
			
			case 2: 
				set.insert();
				break;

			case 3: 
				pcprog.saveReport(allPC);
				break;
			
			}
			// create a new PC, named pc;
			PC newPC = new PC(model, year, man, set);
			allPC.add(newPC);

			/**
			 * @effect: display user option (Y/N);
			 */
			System.out.println("+-------------------------------------------------------------+");
			System.out.println("|                      USER'S OPTIONS                         |");
			System.out.println("|-------------------------------------------------------------|");
			System.out.println("| 1. Enter 'Y' (Yes) to create one more PC and save program:  |");
			System.out.println("| 2. Enter 'N' (No) to display your Report:                   |");
			System.out.println("+-------------------------------------------------------------+");

			System.out.print("Your options from menu: ");
			String a = sc.nextLine();

			if (a.compareToIgnoreCase("N") == 0) {
				test = 0;
			} else {
				test = 1;
			}
		} while (test == 1);

		pcprog.displayReport(allPC);

	}

	/**
	 * @require: ArrayList<PC> allPC;
	 * @effect:
	 * 
	 *          <pre>
	 *          display PCprog Report using printf; Save report using
	 *          TextIO.putln and using TextIO.putf to format String
	 */
	public void displayReport(ArrayList<PC> allPc) {

		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("                                PCProG Report                                       ");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("%-15s %-15s %-20s %-20s", "Model", "Year", "manufacturer", "Set Components");
		for (int i = 0; i < allPc.size(); i++) {
			allPc.get(i).display();
		}
		System.out.println("\n------------------------------------------------------------------------------------");
	}

	/**
	 * @require: ArrayList<PC> allPC;
	 * @effect:
	 * 
	 *          <pre>
	 *          Put information in file named "pcs.txt" using Text I/O;
	 */
	public void saveReport(ArrayList<PC> allPC) {
		TextIO.writeFile("pcs.txt");
		TextIO.putln("------------------------------------------------------------------------------------------");
		TextIO.putln("                                 PCPRoG Report                                            ");
		TextIO.putln("------------------------------------------------------------------------------------------");
		TextIO.putf("%-15s %-15s %-20s %-20s", "Model", "Year", "manufacturer", "Set Components");
		for (int i = 0; i < allPC.size(); i++) {
			TextIO.putln(allPC.get(i).toString());
		}
		TextIO.putln("------------------------------------------------------------------------------------------");
		System.out.println("Report is saved!");
	}

}
