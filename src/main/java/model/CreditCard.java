package model;

public class CreditCard {
    private String cardNumber;
    private int cvv2;
    private String secondPass;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv2() {
        return cvv2;
    }

    public void setCvv2(int cvv2) {
        this.cvv2 = cvv2;
    }

    public String getSecondPass() {
        return secondPass;
    }

    public void setSecondPass(String secondPass) {
        this.secondPass = secondPass;
    }

    public CreditCard(String cardNumber, int cvv2, String secondPass) {
        this.cardNumber = cardNumber;
        this.cvv2 = cvv2;
        this.secondPass = secondPass;
    }

}
