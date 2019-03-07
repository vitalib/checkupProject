/*public class Code {
  public static void main(String[] args) {
	Double mas[];
    mas = new Double[5000005];
    System.out.print(mas[0]);
 	for (int i = 0; i < 5000005; ++i) {
		mas[i] = Math.random();
	}
	for (int i = 0; i < 5000005; ++i) {
		System.out.println(mas[i]);
	}
    System.out.println("Success");
  }
}*/

import java.util.Vector;

public class Code
{
  public static void main(String[] args)
  {
    Vector v = new Vector();
    while (true)
    {
      Runtime rt = Runtime.getRuntime();
      System.out.println( "max memory: " + rt.maxMemory() );
      System.out.println( "free memory: " + rt.freeMemory() );
	    byte b[] = new byte[1048576];
      v.add(b);
    }
  }
}
