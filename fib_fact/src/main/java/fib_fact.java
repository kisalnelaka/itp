



public class fib_fact implements api{


    @Override
    public void getExpression(String expression) {

    }

    @Override
    public void getxvals(int minix, int maxix, int incrx) {

    }

    @Override
    public String getresults(double result) {
        return null;
    }

    @Override
    public void fib() {  int n = 10, t1 = 0, t2 = 1;
        System.out.print("First " + n + " terms: ");

        for (int i = 1; i <= n; ++i)
        {
            System.out.print(t1 + " + ");

            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }

    }

    @Override
    public void fact() {
        int num = 10;
        long factorial = 1;
        for(int i = 1; i <= num; ++i)
        {
            // factorial = factorial * i;
            factorial *= i;
        }
        System.out.printf("Factorial of %d = %d", num, factorial);

    }

    @Override
    public boolean isactive() {
        return true;
    }
}
