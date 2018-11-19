
package hackerearth;

//import for Scanner and other utility classes
import java.util.Scanner;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader */
     /// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       /// String name = br.readLine();                // Reading input from STDIN
       /// System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        
        boolean flag = TestClass.validateTag(name);
        System.out.println("Hi, " + name + "." +flag); 
        // Write your code here

    }
    
    public static boolean validateTag(String tag){
        Boolean flag=false;
        int a1=Integer.parseInt(String.valueOf(tag.charAt(0)));
        int a2=Integer.parseInt(String.valueOf(tag.charAt(1)));
        int a4=Integer.parseInt(String.valueOf(tag.charAt(3)));
        int a5=Integer.parseInt(String.valueOf(tag.charAt(4)));
        int a6=Integer.parseInt(String.valueOf(tag.charAt(5)));
        int a7=Integer.parseInt(String.valueOf(tag.charAt(7)));
        int a8=Integer.parseInt(String.valueOf(tag.charAt(8)));
        if((a1+a2)%2==0  && (a4+a5)%2==0 && (a5+a6)%2==0 && (a7+a8)%2==0){
            flag=true;
        }
        return flag;
    }
}