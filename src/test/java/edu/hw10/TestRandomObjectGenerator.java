package edu.hw10;

import edu.hw10.Task1.RandomObjectGenerator;
import edu.hw10.Task1.TestClass.MyRecord;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestRandomObjectGenerator {

    @Test
    void nextObjectTest1()
        throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
        assertThat(randomObjectGenerator.nextObject(MyRecord.class)).isNotNull();
    }
}
