package main.model;

/**
 * @author rtl
 * @site elbadaernu404.github.io
 * @company suzhou university
 * @create 2020-06-23 14:02
 */
public class Employee {
    private int id;
    private String employeename;
    private String employeedept;
    private String employeeemail;
    public Employee() {

    }
    public Employee(int id, String employeename, String employeedept, String employeeemail) {
        this.id = id;
        this.employeename = employeename;
        this.employeedept = employeedept;
        this.employeeemail= employeeemail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmployeedept() {
        return employeedept;
    }

    public void setEmployeedept(String employeedept) {
        this.employeedept = employeedept;
    }

    public String getEmployeeemail() {
        return employeeemail;
    }

    public void setEmployeeemail(String employeeemail) {
        this.employeeemail = employeeemail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeename='" +employeename + '\'' +
                ", employeedept='" + employeedept + '\'' +
                ", employeeemail='" + employeeemail + '\'' +
                '}';
    }
}
