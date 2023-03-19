import java.sql.SQLOutput;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.IntStream;

public class hostel {
    public static void main(String[] args) {
    }
    String hosteller_name;
    String hosteller_id;
    int batch;
    Date hostel_admission_date;
    int room_no;
    static int idlength=10;
    public String id_generator(){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
// create StringBuffer size of AlphaNumericString
        StringBuilder s = new StringBuilder(idlength);
        int y;
        for ( y = 0; y < idlength; y++) {
// generating a random number
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
// add Character one by one in end of s
            s.append(AlphaNumericString
                    .charAt(index));
        }
        return s.toString();
    }
    hostel(){
        hosteller_id= id_generator();
        hosteller_name=name_initiator();
        batch=getBatch();
    }
    public String name_initiator(){
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter name:");
        String str= scn.next();
        return str;
    }
    public int getBatch(){
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter your graduation year:");
        int n=scn.nextInt();
        int count=0;
        while(n<2023 ){
            System.out.println("Please enter a valid year of graduation");
            int m=scn.nextInt();
            n=m;
            count++;
            if(count>3){
                System.out.println("Session expired");
                break;
            }
        }
        return n;
    }
    public void is_eligible(){
        System.out.println("Enter domicile state:");
        Scanner scn=new Scanner(System.in);
        String state= scn.nextLine();

        System.out.println("Your hostel allotment process has begun, congratulations");
        System.out.println("Here is your hostel id: "+this.hosteller_id);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        System.out.println("Your hostel admission date is: "+date);
        hostel_admission_date=date;
        allocator(this.hosteller_id);
        System.out.println("Your room number is: "+tracker.get(this.hosteller_id));
        return;

        //System.out.println("Sorry we will not be able to allot hostel to you ay this moment");
        //System.out.println("We're sorry! But due to limited number of hostel rooms available with us, we prefer giving them to people living far away");

    }    //USING HASHSET HERE |||||||
    HashSet<String> locations=new HashSet<>();
    public void add_locs(){
        locations.add("Haryana");
        locations.add("Hyderabad");
        locations.add("Bihar");
        locations.add("Uttar Pradesh");
        locations.add("Chandigarh");
        locations.add("Chhatisgarh");
        locations.add("Karnataka");
        locations.add("Tamil Nadu");
        locations.add("Madhya Pradesh");
        locations.add("Punjab");
        locations.add("Jammu and Kashmir");
        locations.add("Himachal Pradesh");
        locations.add("Uttarakhand");
        locations.add("Delhi");
    }
    // hashmap to store id of student against room no
    HashMap<String,Integer> tracker=new HashMap<>();
    //hashmap to store room no against 0/1 representing whether a room is taken or not
    HashMap<Integer,Integer> rooms=new HashMap<>();
    public void allocator(String id){
        for(int i=100;i<=200;i++){
            rooms.put(i,0);
        }
        if(!tracker.containsKey(id)){
            //allocating the room to a new student
            for(int key:rooms.keySet()){
                if(rooms.get(key)==0){
                    tracker.put(id,key);
                    rooms.put(key,1);
                }
                else{
                    System.out.println("Sorry all rooms are full");
                }
            }
        }else{
            System.out.println("User already exists");
        }
    }

}
