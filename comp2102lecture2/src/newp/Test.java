package newp;

public class Test {

    public static void main(String[] args) {
        Student s1 = new Student("emir");
        Student s2 = new Student("ilkim");
        Student s3 = new Student("rana");
        Student s4 = new Student("barış");


        s1.friend=s2;
        s2.friend=s3;
        s3.friend=s4;
        s4.friend=s1; //  s4.friend=s1;

        System.out.println(s1.friend.friend.name);
        System.out.println(s1.friend.friend.friend.friend.name);

    }
}
