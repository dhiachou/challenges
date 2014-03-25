	

    import java.util.Scanner;
     
    public class Solution {
           
            public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            String str=in.nextLine();
            String tmp="";
           
        for(int i=0;i<str.length();i++)
            {
              if (Integer.toBinaryString(str.charAt(i)).length()==6) tmp+="0"+Integer.toBinaryString(str.charAt(i));
              else tmp+=Integer.toBinaryString(str.charAt(i));
            }
       
       int i=0;
       
       while(i<tmp.length())
         {  int index=i;
            String paste="0";
            while(i<tmp.length()-1 && tmp.charAt(i)==tmp.charAt(i+1)  )
            {
              i++;
              paste+="0";
            }
            if (tmp.charAt(index)=='0') System.out.print("00 "+paste); else System.out.print("0 "+paste);
            i++;
        if (i<tmp.length()) System.out.print(" ");
        }
                  }
                                               }
