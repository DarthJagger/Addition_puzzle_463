import java.util.*;

public class Solution {

    public static int helper(ArrayList<Integer>number,int place, int total){
        if (place == number.size())
            return total;

        int adding = helper(number,place+1,total+number.get(place));
        int subtracting = helper(number,place+1,total-number.get(place));

        if (adding<0 && subtracting<0)
            return -1;
        else if (adding<0)
            return subtracting;
        else if (subtracting<0)
            return adding;
        else
            return Math.min(adding,subtracting);


    }




    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StringBuffer test = new StringBuffer(scan.nextLine());
        int test_length = test.length();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int last_space=0;


        for(int i=0;i<test_length;i++){
            if(test.charAt(i)==' '){
                numbers.add(Integer.parseInt(test.toString().substring(last_space,i)));
                last_space = i+1;
            }
        }
        numbers.add(Integer.parseInt(test.toString().substring(last_space,test.length())));




        System.out.println(helper(numbers,0,0));
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}