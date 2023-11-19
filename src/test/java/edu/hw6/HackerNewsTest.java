package edu.hw6;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static edu.hw6.HackerNews.news;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HackerNewsTest {

    @Test
    void hackerNewsTopStoriesTest() {
        String answer = Arrays.toString(HackerNews.hackerNewsTopStories());
        assertThat(answer).isNotEmpty();
    }

    @Test
    void newsTestEmpty() {
        String newsTitle = news(0);
        assertThat(newsTitle).isEqualTo(null);
    }

    @Test
    void newsTest() {
        String newsTitle = news(37570037);
        assertThat(newsTitle).isEqualTo("JDK 21 Release Notes");
    }
}
