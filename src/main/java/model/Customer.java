package model;

public class Customer extends Person{
    BankBranch branch;
    public Customer(String firstName, String lastName, String nationalCode) {
        super(firstName, lastName, nationalCode);
    }

    public Customer(String firstName, String lastName, String nationalCode, BankBranch branch) {
        super(firstName, lastName, nationalCode);
        this.branch = branch;
    }

    public BankBranch getBranch() {
        return branch;
    }

    public void setBranch(BankBranch branch) {
        this.branch = branch;
    }
}
