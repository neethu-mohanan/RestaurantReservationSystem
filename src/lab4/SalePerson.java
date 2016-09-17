/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author ShuvamNandi
 */
public class SalePerson implements Comparable<SalePerson> {

    private String firstName;
    private String lastName;
    private int totalSales;

    public SalePerson(String f, String l, int T) {
        firstName = f;
        lastName = l;
        totalSales = T;
    }

    public String toString() {
        return (lastName + "," + firstName + ":" + totalSales);
    }

    public boolean equals(SalePerson obj) {
        return (this.firstName == obj.getFirstName());

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTotalSales() {
        return totalSales;
    }

    @Override
    public int compareTo(SalePerson obj) {
        int c = this.totalSales - obj.getTotalSales();
        if (c == 0) {
            if (this.getLastName().compareTo(obj.getLastName()) < 0) {
                return 1;
            } else {
                return -1;
            }
        }
        return c;
    }
}