package np;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 *
 * @author suayb25
 */

public class Disjoint {
    public static void main(String[] args) throws IOException {
        PrintWriter pw1 = new PrintWriter("disjoint_1_cpu_time.txt");
        ThreadMXBean bean1 = ManagementFactory.getThreadMXBean( );
        System.out.println(bean1.isCurrentThreadCpuTimeSupported());
        for (int x=16;x<4*65536;x*=2){
            int[] A = new int[1000];
            int[] B = new int[1000];
            int[] C = new int[1000];
            fillArrayWithRandomNumbers(A);
            fillArrayWithRandomNumbers(B);
            fillArrayWithRandomNumbers(C);

            long startTime = System.nanoTime();
            disjoint2(A,B,C);
            long endTime = System.nanoTime();
            long elapsedTime = (endTime-startTime);
            pw1.println(x+"\t"+ elapsedTime);
            System.out.println("Finish time= "+elapsedTime);
        }
        pw1.close();

    }

    public static boolean disjoint1(int[] A,int[] B,int[] C){
        for(int a=0;a<A.length;a++){
            for (int b=0;b<B.length;b++){
                for (int c=0;c<C.length;c++){
                    if(A[a]==B[b] || B[b]==C[c]){
                        return false;               //we found common value
                    }
                }
            }
        }
        return true;                                //if we reach this, sets are disjoint
    }

    public static boolean disjoint2(int[] A,int[] B,int[] C){
        for(int a=0;a<A.length;a++){
            for (int b=0;b<B.length;b++){
                if(A[a]==B[b]){                     //only check C when we find match from A and B
                    for (int c=0;c<C.length;c++){
                        if(A[a]==C[c]){             //and thus b==c as well
                            return false;           //we dound a common value
                        }
                    }
                }
            }
        }
        return true;                                //if we reach this, sets are disjoint
    }

    public static void fillArrayWithRandomNumbers(int[] Array){
        for (int i=0;i<Array.length;i++){
            Array[i]=(int)(Math.random()*10 +1);
            System.out.println(Array[i]);
        }
    }
}