package main.model;

/**
 * @author rtl
 * @site elbadaernu404.github.io
 * @company suzhou university
 * @create 2020-06-21 16:57
 */
public class Department {
    private int number;
    private String departmentname;
    private String departmentfunction;
    public Department() {

    }
    public Department(int number, String departmentname, String departmentfunction) {
        this.number = number;
        this.departmentname = departmentname;
        this.departmentfunction = departmentfunction;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getDepartmentfunction() {
        return departmentfunction;
    }

    public void setDepartmentfunction(String departmentfunction) {
        this.departmentfunction = departmentfunction;
    }

    @Override
    public String toString() {
        return "Department{" +
                "number=" + number +
                ", departmentname='" + departmentname + '\'' +
                ", departmentfunction='" + departmentfunction + '\'' +
                '}';
    }
}
