




public interface api{
    /**loading expression method*/
    void getExpression(String expression);
    /**loading x values method*/
    void getxvals(int minix, int maxix, int incrx);
    /**loading result method*/
    String getresults(double result);

    boolean isactive();
    void fib();
    void fact();

}