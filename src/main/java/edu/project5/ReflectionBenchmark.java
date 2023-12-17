package edu.project5;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Thread)
public class ReflectionBenchmark {
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(ReflectionBenchmark.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(1)
            .warmupForks(1)
            .warmupIterations(1)
            .warmupTime(TimeValue.seconds(5))
            .measurementIterations(1)
            .measurementTime(TimeValue.seconds(5))
            .build();

        new Runner(options).run();
    }

    private Student student;
    private Method method;
    private MethodHandle methodHandle;
    private LambdaMetafactory lambdaMetafactory;
    private static final String METHOD = "name";
    private static final String NAME = "Oleg";
    private static final String SURNAME = "Own";

    @Setup
    public void setup() throws NoSuchMethodException, IllegalAccessException {
        student = new Student(NAME, SURNAME);
        method = student.getClass().getMethod(METHOD);
        methodHandle = getMethodHandle();
        lambdaMetafactory = getLambdaMetafactory();
    }

    private LambdaMetafactory getLambdaMetafactory() {
    }

    private MethodHandle getMethodHandle() throws NoSuchMethodException, IllegalAccessException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Method thisMethod  = Student.class.getDeclaredMethod(METHOD);
        thisMethod.setAccessible(true);
        MethodHandle ans = lookup.unreflect(thisMethod);
        return ans;
    }

    @Benchmark
    public void directAccess(Blackhole bh) {
        String name = student.name();
        bh.consume(name);
    }

    @Benchmark
    public void reflection(Blackhole bh) throws InvocationTargetException, IllegalAccessException {
         var name = (String) method.invoke(student);
         bh.consume(name);
    }
    @Benchmark
    public void methodHandles(Blackhole bh) throws Throwable {
        var name = (String) methodHandle.invoke(student);
        bh.consume(name);
    }

//    @Benchmark
//    public void lambdaMetafactory(Blackhole bh) throws InvocationTargetException, IllegalAccessException {
//        var name = (String) lambdaMetafactory.invoke(student);
//        bh.consume(name);
//    }
}
