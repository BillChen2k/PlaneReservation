package cn.edu.ecnu.planereservation.Core.Payment;

public class WechatPay implements Payment {

    private double amount;

    @Override
    public int confirmPayment() {
        return 0;
    }

    public WechatPay(double amount) {
        this.amount = amount;
    }
}
