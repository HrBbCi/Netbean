package ass2;

import java.util.Vector;
import userlib.DomainConstraint;
import java.util.Scanner;

/**
 * @author Trinh Minh Nhat
 *
 * @object:   <pre>
 *            Sets are mutable,unbounded sets of String.
 * @attribute:<pre>
 *            intSet            Vector
 * @Object:   <pre>
 *            a typical intSet  : component<String>;
 * @abtract_properties: <pre>
 *            mutable(set) = true /\ optional(set) = true;
 *
 */
public class Set {

    @DomainConstraint(type = "String", mutable = true, optional = true)
    private Vector<String> component;

    public Set() {
        component = new Vector<>();
    }

    /**
     * @effect: <pre>
     *          If this component already in Set, do nothing
     *          else, add newElement into Set.
     */
    @SuppressWarnings("resource")
	public void insert() {
        if (component.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.print("How many components that you wants to create: ");
            int numb = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < numb; i++) {
                System.out.print("The element " + (i + 1) + " : ");
                String newElement = sc.nextLine();
                component.add(newElement);
            }
        } else {
            System.err.println("Components are exsist, can not add more!");
        }
    }

    /**
     * @effect: <pre>
     *          for loop to gain the number of components in Set
     *          then, take it out by String.
     */

    @Override
    public String toString() {
        String comp = "[ ";
        for (int i = 0; i < component.size(); i++) {
            comp += component.get(i) + " ,";
        }
        comp += " ]";
        return comp;
    }
}
