package Part2_Ch05._14;

import java.util.TreeSet;
import java.util.Iterator;

public class MemberTreeSet {

    private TreeSet<Member> treeSet;

    public MemberTreeSet() {
        treeSet = new TreeSet<>();
    }

    public void addMember(Member member) {
        treeSet.add(member);
    }

    // 이 부분을 Iterator로 구현
    public boolean removeMember(int memberId) {

        Iterator<Member> ir = treeSet.iterator();

        while(ir.hasNext()) { // 순회
            Member member = ir.next();
            int tempId = member.getMemberId();
            if(tempId == memberId) {
                treeSet.remove(member); // object 지정
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;

    }

    public void showAllMember() {

        for(Member member : treeSet) {
            System.out.println(member);
        }
        System.out.println();
    }

}