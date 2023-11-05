package edu.hw4_update;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task20Test {
    @Test
    void toPrettyPrint() {
        Map<String, Set<ValidationError>> answer = new HashMap<>();
        answer.put("рыба", Set.of(ValidationError.INVALID_AGE));
        answer.put("паук", new HashSet<>());
        answer.put("вторая кошка", new HashSet<>());
        answer.put("кошка", Set.of(ValidationError.INVALID_HEIGHT));
        answer.put("птица", Set.of(ValidationError.INVALID_WEIGHT));
        answer.put("собака", new HashSet<>());

        Map<String,String> prettyAnswer = new HashMap<>();
        prettyAnswer.put("рыба", "Возраст меньше 0");
        prettyAnswer.put("паук", "");
        prettyAnswer.put("вторая кошка", "");
        prettyAnswer.put("кошка", "Рост меньше 0");
        prettyAnswer.put("птица", "Вес меньше 0");
        prettyAnswer.put("собака", "");
        assertThat(Tasks.toPrettyPrint(answer)).isEqualTo(prettyAnswer);
    }
}
