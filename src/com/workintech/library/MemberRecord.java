package com.workintech.library;

import com.workintech.person.Reader;

import java.util.SortedMap;

public class MemberRecord extends Reader {
    private long memberId;
    private int credit;
    private MemberType type;
    private String dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit;
    private String address;
    private String phoneNo;
    private Reader reader;

    public MemberRecord(Reader reader, long memberId, MemberType type, String dateOfMembership, String address, String phoneNo) {
        super(reader.getName(),reader.getLastname());
        this.memberId = memberId;
        this.credit = 100;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssued = 0;
        this.maxBookLimit = 5;
        this.reader = reader;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public int getCredit() {
        return credit;
    }

    public String getName() {
        return super.getName();
    }
    public long getMemberId() {
        return memberId;
    }
    void getMember(MemberRecord member){
        System.out.println("Member ID: " + member.memberId);
        System.out.println("Member Name: " + member.reader.getName());
        System.out.println("Member Address: " + member.address);
        System.out.println("Member Phone Number: " + member.phoneNo);
        System.out.println("Member Membership Type: " + member.type);
        System.out.println("Member Date of Membership: " + member.dateOfMembership);
        System.out.println("Member has no books issued: " + member.noBooksIssued);
    }
    void incBookIssued(){
        if(noBooksIssued < maxBookLimit ){
            payBill();
            noBooksIssued+=1;
            System.out.println("Balance Credit: " + credit);
        } else {
            System.out.println("The member: " + this.getName() + " reached maximum limit of the book issued ");
        }

    }
    void decBookIssued(){
        if(noBooksIssued <= maxBookLimit){
            credit += 25;
            noBooksIssued-=1;
            System.out.println("Credit(Decrease Issued Books: " + credit);

        } else {
            System.out.println("The member: " + this.getName() + " has no issued books");
        }
    }
     void payBill(){
        if(credit>0) credit -=25;
    }

}
