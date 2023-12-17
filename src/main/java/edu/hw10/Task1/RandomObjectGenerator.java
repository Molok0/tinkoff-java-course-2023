package edu.hw10.Task1;

import edu.hw10.Task1.Annotations.Max;
import edu.hw10.Task1.Annotations.Min;
import edu.hw10.Task1.Annotations.ServiceMethod;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomObjectGenerator {
    private static final Random RANDOM = new Random();
    private static final int MAX_LEN_STRING = 100;
    private static final int INITIAL_CHAR = 26;

    @ServiceMethod
    public Object nextObject(Class<?> ob)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        var constructors = ob.getConstructors();
        Parameter[] parameters = constructors[0].getParameters();

        // это не нуджнааа
//        var x = Arrays.stream(parameters).map(Parameter::getType).toArray(Class[]::new);
//        var constructor = ob.getConstructor(x);

        List<Annotation[]> annotations = new ArrayList<>();

        for (var p : parameters) {
            var an = p.getAnnotations();
            annotations.add(an);
        }

        Map<Class<?>, Method> methods = getMethods();

        Object[] constructorParam = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            var parameterType = parameters[i].getType();
            var method = methods.get(parameterType);
            var annotation = annotations.get(i);

            Object[] methodArgs = {annotation};

            constructorParam[i] = method.invoke(this, methodArgs);
        }

        return constructors[0].newInstance(constructorParam);
    }

    @ServiceMethod
    private Map<Class<?>, Method> getMethods() {
        return Arrays.stream(this.getClass().getDeclaredMethods())
            .filter(method -> method.getReturnType() != void.class && !method.isSynthetic()
                && method.getReturnType() != Object.class && method.getReturnType() != List.class)
            .collect(Collectors.toMap(
                Method::getReturnType,
                method -> method
            ));
    }

    @ServiceMethod
    public Object nextObject(Class<?> ob, String method)
        throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        return create(ob);
    }

    @ServiceMethod
    private Object create(Class<?> ob)
        throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        return nextObject(ob);
    }

    @ServiceMethod
    private List<Integer> getMaxMin(Annotation[] annotations, int max, int min) {
        int newMax = max;
        int newMin = min;
        for (var an : annotations) {
            if (an instanceof Max) {
                newMax = ((Max) an).intValue();
            }
            if (an instanceof Min) {
                newMin = ((Min) an).intValue();
            }
        }
        return List.of(newMin, newMax);
    }

    private int getRandomInt(Annotation[] annotations) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        var list = getMaxMin(annotations, max, min);
        return RANDOM.nextInt(list.get(0), list.get(1));
    }

    private byte getRandomByte(Annotation[] annotations) {
        int max = Byte.MAX_VALUE;
        int min = Byte.MIN_VALUE;
        var list = getMaxMin(annotations, max, min);
        return (byte) RANDOM.nextInt(list.get(0), list.get(1));
    }

    private short getRandomShort(Annotation[] annotations) {
        int max = Short.MAX_VALUE;
        int min = Short.MIN_VALUE;
        var list = getMaxMin(annotations, max, min);
        return (short) RANDOM.nextInt(list.get(0), list.get(1));
    }

    private long getRandomLong(Annotation[] annotations) {
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        var list = getMaxMin(annotations, max, min);
        return RANDOM.nextLong(list.get(0), list.get(1));

    }

    @ServiceMethod
    private List<Long> getMaxMin(Annotation[] annotations, long max, long min) {
        long newMax = max;
        long newMin = min;
        for (var an : annotations) {
            if (an instanceof Max) {
                newMax = ((Max) an).intValue();
            }
            if (an instanceof Min) {
                newMin = ((Min) an).intValue();
            }
        }
        return List.of(newMin, newMax);
    }

    private float getRandomFloat(Annotation[] annotations) {
        int max = (int) Float.MAX_VALUE;
        int min = (int) Float.MIN_VALUE;
        var list = getMaxMin(annotations, max, min);
        return RANDOM.nextFloat(list.get(0), list.get(1));
    }

    private double getRandomDouble(Annotation[] annotations) {
        int max = (int) Double.MAX_VALUE;
        int min = (int) Double.MIN_VALUE;
        var list = getMaxMin(annotations, max, min);
        return RANDOM.nextFloat(list.get(0), list.get(1));
    }

    private char getRandomChar(Annotation[] annotations) {
        return (char) (RANDOM.nextInt(INITIAL_CHAR) + 'a');
    }

    private boolean getRandomBool(Annotation[] annotations) {
        return RANDOM.nextBoolean();
    }

    private String getRandomString(Annotation[] annotations) {
        int lenString = RANDOM.nextInt(MAX_LEN_STRING);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lenString; i++) {
            stringBuilder.append(getRandomChar(annotations));
        }
        return stringBuilder.toString();
    }
}
