package Lab1_Java_Package;

public class Lab1_HW
{
    public static boolean IsKRed(int n, int k)
    {
        int sum=n;
        while(sum>9)
        {
            int temp = sum;
            sum=0;
            while(temp>0)
            {
                int cf=temp%10;
                sum+=cf*cf;
                temp/=10;
            }

        }
        return sum == k;
    }

    public static void main(String[] args)
    {
        int a,b,k;
        long startTime=System.nanoTime();

        StringBuilder result = new StringBuilder();

        a= Integer.parseInt(args[0]);
        b= Integer.parseInt(args[1]);
        k= Integer.parseInt(args[2]);

        if(a>b)
        {
            System.out.println("Variabila a trebuie sa fie mai mica decat b! Reintrodu valorile!");
            return;
        }

        for(int i=a; i<=b; i++)
        {
            if(IsKRed(i,k))
                result.append(i).append(" ");
        }

        long endTime=System.nanoTime();
        long time=endTime-startTime;

        System.out.println("Numerele "+k+ " reductibile din intervalul [ "+a+", "+b+" ]:");
        System.out.println(result);
        System.out.println("Timp de executie: "+time);
    }
}

//Cazan Rares