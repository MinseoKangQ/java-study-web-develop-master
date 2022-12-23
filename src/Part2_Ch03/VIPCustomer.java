package Part2_Ch03;

// 우수 고객 클래스
public class VIPCustomer extends Customer {

    // 고객 아이디, 고객 이름, 고객 등급, 보너스 포인트, 보너스 포인트 적립 비율
    // 우수 고객은 물품 구매 시 10% 할인
    // 5% 보너스 포인트 적립
    // 담당 전문 상담원 배정

    double salesRatio;
    private String agentID;

    public VIPCustomer(int customerID, String customerName) {
        super(customerID, customerName);

        customerGrade = "VIP";
        bonusRatio = 0.05;
        salesRatio = 0.1;

        System.out.println("VIPCustomer(int, string) called");
    }

    public String getAgentID() {
        return agentID;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        price -= (int)(price * salesRatio);
        return price;
    }
}