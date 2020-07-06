import java.util.*;

public class Safari{
    
    public static void find(int cars,int mpas,int rpas,int rtime,int mtime,int ttime){
        
        int dum_rtime = rtime , dum_mtime = mtime;
        int wait = cars - rpas;
        
        if( cars < rpas )
            wait = rpas - cars;
        
        int dum_cars = 0;
        int comp = 0;
        int dum_comp = cars;
        int mcomp[][] = new int[mpas][2];
        int k = 0 , in = 0;
        
        if( rpas < cars ){
            
            dum_comp = rpas;
            dum_cars = cars - dum_comp;
        }
        
        //System.out.println(dum_comp);
        
        for(int i = 0 ; i <= ttime ; i++){
            
            //System.out.println("Start Pass = "+wait+" Time = "+i+" muse pas balance "+mpas+" Ride Time = "+dum_rtime+" mcomp[][] = "+mcomp[k][0]+" "+mcomp[k][1]+" Completed = "+comp+" Ride Taken count = "+dum_comp+" Available Car = "+dum_cars);
            
            if( mcomp[k][1] == i && k != in ){
                
                //System.out.println("Diff");
                if( mcomp[k][0] != cars ){
                
                    dum_cars = dum_cars + mcomp[k][0];
                }
                comp = comp + mcomp[k][0];
                k++;
            }
            
            if( i != 0 && i%mtime == 0 && mpas > 0 ){
                
                //System.out.println("MueStart Pass = "+wait+" Time = "+i+" muse pas balance "+mpas+" Ride Time = "+dum_rtime+" mcomp[][] = "+mcomp[k][0]+" "+mcomp[k][1]+" Completed = "+comp+" Ride Taken count = "+dum_comp+" Available Car = "+dum_cars);
                mpas--;
                wait = wait + 1;
                
                if( dum_cars != 0 && i >= rtime ){
                
                    if( dum_cars >= wait ){
                        
                        mcomp[in][0] = wait;
                        mcomp[in][1] = i+rtime;
                        dum_cars = dum_cars - wait;
                        wait = 0;
                        in++;
                    }
                    else if( dum_cars < wait && dum_cars != 0 ){
                        
                        mcomp[in][0] = dum_cars;
                        wait = wait - dum_cars;
                        dum_cars = 0;
                        in++;
                    }
                }
                //System.out.println("MueEnd Pass = "+wait+" Time = "+i+" muse pas balance "+mpas+" Ride Time = "+dum_rtime+" mcomp[][] = "+mcomp[k][0]+" "+mcomp[k][1]+" Completed = "+comp+" Ride Taken count = "+dum_comp+" Available Car = "+dum_cars);
            }
            
            if( dum_rtime == 0 ){
                
                //System.out.println("RideStart Pass = "+wait+" Time = "+i+" muse pas balance "+mpas+" Ride Time = "+dum_rtime+" mcomp[][] = "+mcomp[k][0]+" "+mcomp[k][1]+" Completed = "+comp+" Ride Taken count = "+dum_comp+" Available Car = "+dum_cars);
                dum_rtime = rtime;
                
                comp = comp + dum_comp;
                
                if( dum_cars != cars ){
                    
                    dum_cars = dum_cars + dum_comp;
                }
                
                if( dum_cars >= wait ){
                    
                    dum_comp = wait;
                    dum_cars = dum_cars - wait;
                    wait = 0;
                }
                else if( dum_cars < wait && dum_cars != 0 ){
                    
                    dum_comp = dum_cars;
                    wait = wait - dum_cars;
                    dum_cars = 0;
                }
                //System.out.println("RideEnd Pass = "+wait+" Time = "+i+" muse pas balance "+mpas+" Ride Time = "+dum_rtime+" mcomp[][] = "+mcomp[k][0]+" "+mcomp[k][1]+" Completed = "+comp+" Ride Taken count = "+dum_comp+" Available Car = "+dum_cars);
            }
            
            dum_rtime--;
            //System.out.println("END Pass = "+wait+" Time = "+i+" muse pas balance "+mpas+" Ride Time = "+dum_rtime+" mcomp[][] = "+mcomp[k][0]+" "+mcomp[k][1]+" Completed = "+comp+" Ride Taken count = "+dum_comp+" Available Car = "+dum_cars);
            //System.out.println("NEXT");
        }
        
        System.out.println(dum_cars+" "+comp+" "+mpas+" "+wait);
    }
    
    public static void main(String args[]){
        
        Scanner scanner = new Scanner(System.in);
        
        int test = scanner.nextInt();
        
        for(int i = 0 ; i < test ; i++){
            
            int cars = scanner.nextInt();
            int mpas = scanner.nextInt();
            int rpas = scanner.nextInt();
            int rtime = scanner.nextInt();
            int mtime = scanner.nextInt();
            int ttime = scanner.nextInt();
            
            find(cars,mpas,rpas,rtime,mtime,ttime);
        }
    }
}
