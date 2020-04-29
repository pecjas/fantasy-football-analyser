package ffb.test.utilities;

import ffb.analyzer.models.espn.TransactionCounter;
import org.junit.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericTests {
    public static void validateGetMethodsReturnNonNullValue(List<?> testObjects) throws InvocationTargetException, IllegalAccessException {
        List<Method> getterMethods = new ArrayList<Method>();

        for (Method method : testObjects.get(0).getClass().getMethods()) {
            if (isGetterMethod(method)) {
                getterMethods.add(method);
            }
        }

        for (var i = 0; i < testObjects.size(); i++) {
            for (var j = 0; j < getterMethods.size(); j++) {
                var method = getterMethods.get(j);
//                Assert.assertNotNull(getterMethods.get(j).invoke(testObjects.get(i)));
                Assert.assertNotNull(method.invoke(testObjects.get(i)));
            }
        }
    }

    public static void validateGetMethodsReturnNonNullValue(Object testObject) throws InvocationTargetException, IllegalAccessException {
        for (Method method : testObject.getClass().getMethods()) {
            if (isGetterMethod(method)) {
                Assert.assertNotNull(method.invoke(testObject));
            }
        }
    }

    private static boolean isGetterMethod(Method method) {
        if (Modifier.isPublic(method.getModifiers()) == false ||
                method.getReturnType().equals(Void.TYPE)) {
            return false;
        }

        if (method.getName().matches("^get[A-Z].*") ||
                method.getName().matches("^is[A-Z].*")) {
            return true;
        }

        return false;
    }
}
