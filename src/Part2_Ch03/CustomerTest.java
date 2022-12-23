package Part2_Ch03;

import java.util.ArrayList;

public class CustomerTest {

    public static void main(String [] args) {

        ArrayList<Customer> customerList = new ArrayList<>();

        Customer customerT = new Customer(10010, "1");
        Customer customerJ = new Customer(10010, "2");
        Customer customerE = new GoldCustomer(10010, "3");
        Customer customerP = new GoldCustomer(10010, "4");
        Customer customerK = new VIPCustomer(10010, "5");

        customerList.add(customerT);
        customerList.add(customerJ);
        customerList.add(customerE);
        customerList.add(customerP);
        customerList.add(customerK);

        for(Customer customer : customerList) {
            System.out.println(customer.showCustomerInfo());
        }

        int price = 10000;
        for(Customer customer : customerList) {
            int cost = customer.calcPrice(price);
            System.out.println(customer.getCustomerName() + "님이 " + cost + "원 지불하셨습니다.");
            System.out.println(customer.getCustomerName() + "님의 현재 보너스 포인트는 " + customer.bonusPoint + "입니다.");
        }

        if(customerE instanceof GoldCustomer) {
            GoldCustomer vc = (GoldCustomer) customerE;
            System.out.println(customerE.showCustomerInfo());
        }

//        Customer customerLee = new Customer(10010, "이순신");
//        customerLee.bonusPoint = 1000;
//        int price = customerLee.calcPrice(1000);
//        System.out.println(customerLee.showCustomerInfo());
//        System.out.println("내야 할 금액은 " + price + "원 입니다.");
//
//        VIPCustomer customerKim = new VIPCustomer(10020, "김유신");
//        customerKim.bonusPoint = 1000;
//        price = customerKim.calcPrice(1000);
//        System.out.println(customerKim.showCustomerInfo());
//        System.out.println("내야 할 금액은 " + price + "원 입니다.");
//
//        // 가능, newCustomer는 Customer 타입
//        // 실제 인스턴스는 VIPCustomer
//        // 사용 가능한 필드/메서드는 Customer에 내포된 것
//        // 자바에서는 항상 인스턴스의 메서드가 호출됨
//        Customer newCustomer = new VIPCustomer(10030, "no-name");
//
//        // 타입과 인스턴스의 것 중에 인스턴스 것이 불림 -> ** 가상함수 **
//        System.out.println(newCustomer.calcPrice(1000));
    }

}
