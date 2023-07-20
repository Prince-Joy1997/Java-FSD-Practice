package org.example;

import java.util.ArrayList;
import java.util.List;

public class Member {
    int memberId;
    String name;
    Address address; // the address of a member
    MemberAccount memberAccount; // A member has an account

    List<Member> memberList = new ArrayList<>();
    public Member(int memberId, String name, Address address) {
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member(int memberId, String name, Address address, MemberAccount memberAccount) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.memberAccount = memberAccount;
    }

    public void openAnAccount(int memberId, String name, Address address){

        MemberAccount account = new MemberAccount(memberId,null);
        Member member = new Member(memberId,name,address);

    }
}
