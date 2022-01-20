package model;

public class Employee extends Person{
    private int employeeId;
    private String password;
    private BankBranch branch;


    public Employee(String firstName, String lastName, String nationalCode, int employeeId, String password, BankBranch branch) {
        super(firstName, lastName, nationalCode);
        this.employeeId = employeeId;
        this.password = password;
        this.branch = branch;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BankBranch getBranch() {
        return branch;
    }

    public void setBranch(BankBranch branch) {
        this.branch = branch;
    }
}
