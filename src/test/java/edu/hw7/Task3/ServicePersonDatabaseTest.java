package edu.hw7.Task3;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ServicePersonDatabaseTest {

    @Test
    void servicePersonDatabaseTest() {
        PersonDatabase db = new ServicePersonDatabase();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 100000; i++) {
            Person person = new Person(i, "Person " + i, "Address " + i, "Number " + i);
            executorService.execute(() -> db.add(person));
        }

        for (int i = 0; i < 100000; i++) {
            String name = "Person " + i;
            String address = "Address " + i;
            String number = "Number " + i;
            executorService.execute(() -> {
                List<Person> personName = db.findByName(name);
                List<Person> personAddress = db.findByAddress(address);
                List<Person> personNumber = db.findByPhone(number);

                assertThat(personName.isEmpty()).isEqualTo(false);
                assertThat(personAddress.isEmpty()).isEqualTo(false);
                assertThat(personNumber.isEmpty()).isEqualTo(false);
            });
        }
        executorService.shutdown();

    }

}
