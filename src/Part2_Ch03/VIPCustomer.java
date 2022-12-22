package Part2_Ch03;

// 우수 고객 클래스
public class VIPCustomer extends Customer {

    // 고객 아이디, 고객 이름, 고객 등급, 보너스 포인트, 보너스 포인트 적립 비율
    // 우수 고객은 물품 구매 시 10% 할인
    // 5% 보너스 포인트 적립
    // 담당 전문 상담원 배정

    double salesRatio;
    private String agentID;

    public String getAgentID() {
        return agentID;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    public VIPCustomer() {
        bonusRatio = 0.05;
        salesRatio = 0.1;
        customerGrade = "VIP";
    }
}