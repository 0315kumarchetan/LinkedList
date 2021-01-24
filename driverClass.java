import java.util.Scanner;
public class driverClass {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        ConstructionOfLinkedList ob = new ConstructionOfLinkedList();
        for(int i = 0; i<n ;i++){
            ob.addLast(scn.nextInt());
        }
        ob.print();
        System.out.println();
        int ans = ob.size();
        System.out.println(ans);
        int res  = ob.removeAt(2);
        System.out.println(res);
        int ans1 = ob.size();
        System.out.println("answer after remove ->"+ans1);
    }
    
}