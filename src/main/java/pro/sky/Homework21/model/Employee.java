package pro.sky.Homework21.model;

public class Employee {
    public Employee(String firstName, String lastName, Integer departmentNumber, Integer salaryAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentNumber = departmentNumber;
        this.salaryAmount = salaryAmount;
    }
    private Integer departmentNumber;
    private Integer salaryAmount;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalaryAmount() {
        return salaryAmount;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    @Override
    public boolean equals(Object obj) {
        // Проверка на null
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) obj;
        if (!this.firstName.equals(other.firstName)) {
            return false;
        }
        if (!this.lastName.equals(other.lastName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        if (firstName == null) {
            result = 0;
        } else {
            result = firstName.hashCode();
        }
        if (lastName != null) {
            result += lastName.hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Имя:" + firstName + ". Фамилия:" + lastName + ".";
    }

}
