package lesson7;

public class Tests_Set {
    @Test(value = 5)
    public void testMethod1(){
        System.out.println("Priority = 5");
    }
    @Test(value = 1)
    public void testMethod2(){
        System.out.println("Prioriry = 1");
    }
    @Test(value = 10)
    public void testMethod3(){
        System.out.println("Priority = 10");
    }
    @Test(value = 7)
    public void testMethod4(){
        System.out.println("Priority = 7");
    }
    @Test
    public void testMethod5(){
        System.out.println("Priority = default");
    }
    @AfterSuite
    public void afterMathod(){
        System.out.println("AfterSuite maethod");
    }
    @BeforeSuite
    public void beforSuiteMethod(){
        System.out.println("BeforSuite method");
    }

}
