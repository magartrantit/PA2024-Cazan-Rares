package Lab1_Java_Package;
public class Lab1_Bonus
{

    public static void main(String[] args)
    {
        int n= Integer.parseInt(args[0]);
        int[][] matrix = new int[n+1][n+1];


        //construim matricea
        for(int i=0;i<n-1;i++)
        {
            matrix[i][n-1]=1;
            matrix[n-1][i]=1;
        }

        for(int i=0;i<n-1;i++)
        {
            matrix[i][i+1]=1;
            matrix[i+1][i]=1;
            if(i==n-2)
            {
                matrix[0][n-2]=1;
                matrix[n-2][0]=1;
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
        System.out.println();

        //cicluri

        int ct=0;
        for(int i=3;i<=n;i++)
        {
            System.out.println("Cicluri cu "+i+" noduri:");

            for(int j=0;j<n-1;j++)
            {
                ct++;
                StringBuilder ciclu=new StringBuilder();
                ciclu.append(n-1);
                ciclu.append(" ");
                ciclu.append(j);
                ciclu.append(" ");
                for(int l=1;l<i-1;l++)
                {
                    ciclu.append((j+l)%(n-1));
                    ciclu.append(" ");
                }
                ciclu.append(n-1);
                System.out.println(ciclu);
            }

            //pt ciclu exterior
            if(i==n-1)
            {
                StringBuilder ciclu=new StringBuilder();
                for(int j=0;j<=n-2;j++)
                {
                    ciclu.append(j);
                    ciclu.append(" ");
                }
                ciclu.append(0);
                System.out.println(ciclu);
                ct++;
            }
        }

        System.out.println("Numarul de cicluri: "+ct);
    }

}

//Cazan Rares

