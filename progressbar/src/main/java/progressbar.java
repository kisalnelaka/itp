




public class progressbar implements api {


    @Override
    public void getExpression(String expression) {

    }

    @Override
    public void getxvals(int minix, int maxix, int incrx) {

    }

    @Override
    public String getresults(double result) {
return "succ";
    }

    @Override
    public void fib() {

    }

    @Override
    public void fact() {

    }

    @Override
    public boolean isactive() {
        return false;
    }

    public String  progress()
    {
        final int delay = 200, max = 100;
        for (int i = 0;max>=i;i++){System.out.print('#');
        }
        return "done";


    }
}
