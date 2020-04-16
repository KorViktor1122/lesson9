package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;

public class Begin  {
    private static Object obj ;

    public static void start(Class aClass){
        if(!FromTillCorrect(aClass)){
            throw new RuntimeException();
        }

        try {
            obj = aClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }

        Method from = null;
        Method till = null;
        ArrayList<Method> testMethods = new ArrayList<>();
        Method[] objMethods = aClass.getDeclaredMethods();

        for (Method method : objMethods) {
            if(method.getAnnotation(BeforeSuite.class) != null){
                from = method;
            } else if (method.getAnnotation(AfterSuite.class) != null){
                till = method;
            } else  if (method.getAnnotation(Test.class) != null){
                testMethods.add(method);
            }
        }

        testMethods.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).value()));

        if(from != null){
            testMethods.add(0,from);
        }
        if (till != null){
            testMethods.add(till);
        }

        try {
            for (Method testMethod : testMethods) {
                if (Modifier.isPrivate(testMethod.getModifiers())) ;
                {
                    testMethod.setAccessible(true);
                }
                testMethod.invoke(obj);
            }
        } catch (IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
    }

    private static boolean FromTillCorrect(Class aClass) {
        int fromCount = 0;
        int tillCount = 0;

        for (Method method : aClass.getDeclaredMethods()) {
            if(method.getAnnotation(BeforeSuite.class) != null){
                fromCount++;
            }

            if(method.getAnnotation(AfterSuite.class) != null){
                tillCount++;
            }
        }
        return (fromCount < 2) && (tillCount < 2);
    }
}
