public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("Welcome to Vision Hostel management system . We are happy to serve you :)");
        hostel u1=new hostel();
        System.out.println("Your unique id is "+u1.hosteller_id);
        u1.is_eligible();
        System.out.println("Thank you");
    }
}