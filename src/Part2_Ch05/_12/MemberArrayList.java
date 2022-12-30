package Part2_Ch05._12;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberArrayList {

    private ArrayList<Member> arrayList;

    public MemberArrayList() {
        arrayList = new ArrayList<>();
    }

    public MemberArrayList(int size) {
        arrayList = new ArrayList<>(size);
    }

    public void addMember(Member member) {
        arrayList.add(member);
    }

    // 이 부분을 Iterator로 구현
    public boolean removeMember(int memberId) {

        Iterator<Member> ir = arrayList.iterator();

        while(ir.hasNext()) { // 순회
            Member member = ir.next();
            int tempId = member.getMemberId();
            if(tempId == memberId) {
                arrayList.remove(member); // object 지정
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;

    }

    public void showAllMember() {

        for(Member member : arrayList) {
            System.out.println(member);
        }
        System.out.println();
    }

}