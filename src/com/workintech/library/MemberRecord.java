package com.workintech.library;
import com.workintech.person.Reader;
import java.util.Objects;

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
            noBooksIssued+=1;
            System.out.println("Balance Credit: " + credit);
        } else {
            System.out.println("The member: " + this.getName() + " reached maximum limit of the book issued ");
        }

    }
    void decBookIssued(){
        if(noBooksIssued <= maxBookLimit && noBooksIssued >= 0){
            credit += 20;
            noBooksIssued-=1;
            System.out.println("Balance Credit: " + credit);

        } else {
            System.out.println("The member: " + this.getName() + " has no issued books");
        }
    }
    void payBill(){
        if(credit>0) credit -=20;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MemberRecord that = (MemberRecord) o;
        return memberId == that.memberId && credit == that.credit && noBooksIssued == that.noBooksIssued && maxBookLimit == that.maxBookLimit && type == that.type && Objects.equals(dateOfMembership, that.dateOfMembership) && Objects.equals(address, that.address) && Objects.equals(phoneNo, that.phoneNo) && Objects.equals(reader, that.reader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), memberId, credit, type, dateOfMembership, noBooksIssued, maxBookLimit, address, phoneNo, reader);
    }
}
