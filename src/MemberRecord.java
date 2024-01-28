public class MemberRecord {
    private long memberId;
    private int credit;
    private MemberType type;
    private String dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit;
    private String name;
    private String address;
    private String phoneNo;

    public MemberRecord(long memberId, MemberType type, String dateOfMembership, String name, String address, String phoneNo) {
        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssued = 0;
        this.maxBookLimit = 5;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.credit = 100;
    }

    void getMember(MemberRecord member){
        System.out.println("Member ID: " + member.memberId);
        System.out.println("Member Name: " + member.name);
        System.out.println("Member Address: " + member.address);
        System.out.println("Member Phone Number: " + member.phoneNo);
        System.out.println("Member Membership Type: " + member.type);
        System.out.println("Member Date of Membership: " + member.dateOfMembership);
        System.out.println("Member has no books issued: " + member.noBooksIssued);
    }




}
