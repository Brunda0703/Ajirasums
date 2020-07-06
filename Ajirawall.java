import java.util.*;
public class Main
{
    public static int Solution(String s){
        int nor=0,wes=0,sou=0,eas=0,count=0;
        String sem[]=s.split(";");
        for(int i=0;i<sem.length;i++){
            String sub=sem[i].substring(7);
            String[] col=sub.split(":");
            for(int j=0;j<col.length;j++){
                String hiph[]=col[j].split("-");
                String str=hiph[1];
                int x=Integer.parseInt(hiph[3]);
                if(str.equals("N")){
                if(nor==0 || nor<x){
                    count++;
                    nor=nor+(x-nor);
                }
                }
                if(str.equals("S")){
                if(sou==0 || sou<x){
                    count++;
                    sou=sou+(x-sou);
                }
                }
                else if(str.equals("E")){
                if(eas==0 || eas<x){
                    count++;
                    eas=eas+(x-eas);
                }
                }
                else if(str.equals("W")){
                if(wes==0 || wes<x){
                    count++;
                    wes=wes+(x-wes);
                }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner S=new Scanner(System.in);
        //int res=0;
        String s="Day 1$ T1 - N - X - 5 : T2 - W - X - 3;Day 2$ T1 - S - X - 2";
        String s1=s.replaceAll(" ","");
        System.out.println(Solution(s1));
    }
}


You may be offline or with limited connectivity. Try downloading instead. 