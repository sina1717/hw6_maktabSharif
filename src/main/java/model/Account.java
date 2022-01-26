package model;

public class Account {
    private String accountId;
    private CreditCard card;
    private String password;
    private Customer customer;

    public Account(String accountId, CreditCard card, String password, Customer customer) {
        this.accountId = accountId;
        this.card = card;
        this.password = password;
        this.customer = customer;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
