import java.util.*;

public class ATM{
    
    static int minimum = Integer.MAX_VALUE;
    
    public static int find_near(List<Integer> dt , int val){
        
        int min = Integer.MAX_VALUE;
        for( int i = 0 ; i < dt.size() ; i++ ){
            
            int dif = val - dt.get(i);
            if( dif >= 0 && min > dif ){
                
                min = dif;
            }
            else if( dif < 0 && min > (dif*-1)){
                
                min = dif*-1;
            }
        }
        
        return min;
    }
    
    public static int calculate(int [] arr, int [] data){
        
        List<Integer> ar = new ArrayList<Integer>();
        List<Integer> dt = new ArrayList<Integer>();
        
        for(Integer a: arr)
            ar.add(a);
            
        for(Integer a: data)
            dt.add(a);
        
        int sum = 0;
        
        for(int i = 0 ; i < ar.size() ; i++){
            
            if( !dt.contains(ar.get(i)) ){
                
                sum = sum + find_near(dt,ar.get(i));
            }
        }
        
        return sum;
    }
    
    public static void find(int [] arr,int [] data,int start,int end,int index,int r){
        
        if( r == index ){
            
            // for(int i = 0 ; i < r ; i++ ){
            //     System.out.print(data[i]+" ");
            // }
            // System.out.println();
            
            int sum = calculate(arr,data);
            if( sum < minimum ){
                
                minimum = sum;
            }
            //System.out.println(sum);
            return;
        }
        
        for(int i = start ; i <= end ; i++ ){
            
            data[index] = arr[i];
            
            find(arr,data,i+1,end,index+1,r);
        }
        
        return;
        
    }
	public static void main(String args[]){
	
		Scanner scanner = new Scanner(System.in);
		
		int atm = scanner.nextInt();
		
		int areas = scanner.nextInt();
		int arr[] = new int[areas];
		int data[] = new int [areas];
		for(int i = 0 ; i < areas ; i++){
			
			arr[i] = scanner.nextInt();
		}
		
		find(arr,data,0,areas-1,0,atm);
		
		System.out.println(minimum);
	}
}