import java.util.*;

public class PondAction extends pondsimulation implements Runnable {

    Random random = new Random();
    
    public synchronized void doAction(Fish obj1,Fish obj2) throws InterruptedException
    {
       
        if (obj1.gender==obj2.gender)
        {
            if (obj1.gender=='M')
           {
             pond.remove(obj1);
            pond.remove(obj2);
            System.out.println("Fish "+obj1.id+" and "+obj2.id+" killed each other");
           
           }
            if(obj2.gender=='F')
            {
                pond.remove(random.nextBoolean()?obj1:obj2);
               System.out.println("Fish "+obj1.id+" died ");
                
            }
        }
        else
        {
            Fish f1 = new Fish(random.nextBoolean()? 'M' : 'F', g_id++);
            Fish f2 = new Fish(random.nextBoolean()? 'M' : 'F', g_id++);
            pond.add(0,f1);
            pond.add(1,f2);
            System.out.println("Fish "+f1.id+" and "+f2.id+" were born");
            
        }
        System.out.println("No. of fishes "+(pond.size()));
    }

    @Override
    public void run() 
    {
        try{
       // for(int i=0;i<10;i++)
       while(true)
        {
            int a=(int)(Math.random()*pond.size());
            int b=(int)(Math.random()*pond.size());
            Fish f1 = pond.get(a);
            Fish f2 = pond.get(b);

            if (f1==null || f2==null)
            continue;

            if(f1.equals(f2))
            continue;

            if(pond.size()<=1){
                System.out.println("Insufficient fishes left");
                continue;
            }

            synchronized(f1)
            {
                synchronized(f2)
                {
                    doAction(f1, f2);
                }
            }

           
        }
        
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
    }
    
}
}
