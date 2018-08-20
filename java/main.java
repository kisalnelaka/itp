


import java.util.Scanner;
import java.lang.reflect.*;
import org.python.core.*;
import org.python.util.*;
import org.python.util.PythonInterpreter;




public class main {
    static {
        System.loadLibrary("example_c_library");
    }

    public static void main(String[] args) throws Exception {
        PythonInterpreter interp = new PythonInterpreter();
        while (true) {
            System.out.println("Choose desired option: ");
            System.out.println("1.Load Progress Bar");
            System.out.println("2.Load Print csv");
            System.out.println("3.Load Fib and fact");
            System.out.println("4.Load c based plugin");

            System.out.println("5.List availible plugins");
            System.out.println("6.Solve Equation");
            System.out.println("7.Exit");
            Scanner in = new Scanner(System.in);
            String s = in.next();


            switch (s) {
                case "1":
                    /**loading plugin*/

                    Class pbclass = Class.forName("progressbar");
                    Object pb = pbclass.newInstance();
                    Method pbm = pbclass.getMethod("progress");
                    System.out.println(pbm.invoke(pb));
                    System.out.println("Activated Successfully");
                    break;


                case "2":
                    /**loading plugin*/

                    Class csvclass = Class.forName("csv_plugin");
                    Object csv = csvclass.newInstance();
                    Method csvm = csvclass.getMethod("isactive");
                    System.out.println(csvm.invoke(csv));
                    System.out.println("Activated Successfully");
                    break;
                case "3":
/**loading plugin*/
                    Class fibfacclass = Class.forName("fib_fact");
                    Object fibfact = fibfacclass.newInstance();
                    Method fibfacm = fibfacclass.getMethod("isactive");

                    System.out.println(fibfacm.invoke(fibfact));
                    System.out.println("Activated Successfully");
                    break;
                case "5":
                    /**loading plugin*/
                   //if (a == "true"){System.out.println("fib fac added");}
                    break;


                case "6":
                    /**solving expression*/
                    System.out.println("Please enter the expression");


                    Scanner exp = new Scanner(System.in);
                    String expression;
                    expression = exp.nextLine();
                    //interp.set("expr", new PyString(expression));

                /*System.out.println("Please enter the x value");
                Scanner xval = new Scanner(System.in);
                Integer xvalue;
                xvalue = xval.nextInt();
                interp.set("x", new PyInteger(xvalue));*/

                    


                    //System.out.println("your x value is: " +xvalue);
                    System.out.println("Please enter the minx value");
                    Scanner minx = new Scanner(System.in);
                    int minix;
                    minix = minx.nextInt();
                    System.out.println("Please enter the maxx value");
                    Scanner maxx = new Scanner(System.in);
                    int maxix;
                    maxix = maxx.nextInt();
                    System.out.println("Please enter the incx value");
                    Scanner incx = new Scanner(System.in);
                    int incrx;
                    incrx = incx.nextInt();
                    int x;
                    for (x = minix; x <= maxix; x += incrx) {
                        interp.set("x", new PyInteger(x));
                        double result = ((PyFloat) interp.eval("float(" + expression + ")")).getValue();


                        //y = interp.get("y");
                        System.out.println("answer for x= " + x + " is" + result);
                    }
                    break;




                case "7":

                    System.out.println("Bye");
                    System.exit(0);

                default:
                    System.out.println("Invalid option");
                    break;
            }



        }


    }
}
