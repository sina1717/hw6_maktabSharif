package model;

public class BankBranch {
    private int branchId;
    private String name;
    private String address;

    public BankBranch(int branchId, String name, String address) {
        this.branchId = branchId;
        this.name = name;
        this.address = address;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
