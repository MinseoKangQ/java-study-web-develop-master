package Part2_Ch03;

// 일반 고객 클래스
public class Customer {

    // 고객 아이디, 고객 이름, 고객 등급, 보너스 포인트, 보너스 포인트 적립 비율
    // 일반 고객은 물품 구매 시 1% 보너스 포인트 적립

    protected int customerID;
    protected String customerName;
    protected String customerGrade;
    int bonusPoint;
    double bonusRatio;

//    public Customer() {
//        customerGrade = "SILVER";
//        bonusRatio = 0.01;
//
//        System.out.println("Customer() called");
//    }

    public Customer(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;

        customerGrade = "SILVER";
        bonusRatio = 0.01;

        System.out.println("Customer(int, string) called");
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        return price;
    }

    public String showCustomerInfo() {
        return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + " 입니다.";
    }
}
