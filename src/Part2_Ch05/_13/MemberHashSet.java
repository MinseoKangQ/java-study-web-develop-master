package Part2_Ch05._13;

import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {

    private HashSet<Member> hashSet;

    public MemberHashSet() {
        hashSet = new HashSet<>();
    }

    public MemberHashSet(int size) {
        hashSet = new HashSet<>(size);
    }

    public void addMember(Member member) {
        hashSet.add(member);
    }

    // 이 부분을 Iterator로 구현
    public boolean removeMember(int memberId) {

        Iterator<Member> ir = hashSet.iterator();

        while(ir.hasNext()) { // 순회
            Member member = ir.next();
            int tempId = member.getMemberId();
            if(tempId == memberId) {
                hashSet.remove(member); // object 지정
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;

    }

    public void showAllMember() {

        for(Member member : hashSet) {
            System.out.println(member);
        }
        System.out.println();
    }

}