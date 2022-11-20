import java.util.ArrayList;

public class pondsimulation {
    static ArrayList<Fish> pond = new ArrayList<>();
    static int g_id = 1; 

    static void populatePond()
    {
        for (int i=0;i<5;i++)
        {
            Fish f1 = new Fish('M',g_id++);
            Fish f2 = new Fish('F',g_id++);
            pond.add(f1);
            pond.add(f2);
        }
        
    }
    public static void main(String[] args)
    {

        PondAction r = new PondAction();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        Thread t5 = new Thread(r);
       
        populatePond();
        for (int i=0;i<10;i++)
        {
           Fish f1 = pond.get(i);
            System.out.println(f1.gender+" "+f1.id);
        }
        //System.out.println(pond);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
