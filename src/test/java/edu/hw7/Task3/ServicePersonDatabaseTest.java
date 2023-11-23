package edu.hw7.Task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ServicePersonDatabaseTest {

    @Test
    void servicePersonDatabaseTestSize() {

        int sizeDb = 100000;
        PersonDatabase db = new ServicePersonDatabase();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < sizeDb; i++) {
            Person person = new Person(i, "Person " + i, "Address " + i, "Number " + i);
            executorService.execute(() -> db.add(person));
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        assertThat(sizeDb).isEqualTo(db.getSize());
    }

}
