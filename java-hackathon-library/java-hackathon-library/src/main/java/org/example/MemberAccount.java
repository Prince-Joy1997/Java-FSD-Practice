package org.example;

public class MemberAccount {
    int accountNo;
    BorrowedBookInfo[] borrowed;

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public BorrowedBookInfo[] getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(BorrowedBookInfo[] borrowed) {
        this.borrowed = borrowed;
    }

    public MemberAccount(int accountNo, BorrowedBookInfo[] borrowed) {
        this.accountNo = accountNo;
        this.borrowed = borrowed;
    }
}
