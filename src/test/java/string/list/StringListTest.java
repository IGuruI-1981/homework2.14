package string.list;

import org.example.StringList;
import org.example.StringListImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class StringListTest {

    private final StringList stringList = new StringListImpl();

    @AfterEach
    public void afterEach() {
        stringList.clear();
    }

    @Test
    void addTest() {
        String[] arrayTest = {"1","2","3","4","5","6"};
        add(arrayTest);

        for (int i = 0; i < arrayTest.length; i++) {
            assertThat(stringList.get(i)).isEqualTo(arrayTest[i]);
            assertThat(stringList.contains(arrayTest[i])).isTrue();
            assertThat(stringList.indexOf(arrayTest[i])).isEqualTo(i);
            assertThat(stringList.lastIndexOf(arrayTest[i])).isEqualTo(i);

        }

        assertThat(stringList.toArray()).hasSize(arrayTest.length);
        assertThat(stringList.toArray()).containsExactly(arrayTest);


        stringList.add(0, "7");
        assertThat(stringList.size()).isEqualTo(arrayTest.length + 1);
        assertThat(stringList.get(0)).isEqualTo("7");

        stringList.add(2, "7");
        assertThat(stringList.size()).isEqualTo(arrayTest.length + 2);
        assertThat(stringList.get(2)).isEqualTo("7");
        assertThat(stringList.lastIndexOf("7")).isEqualTo(2);
        assertThat(stringList.indexOf("7")).isEqualTo(0);

        stringList.add(8, "7");
        assertThat(stringList.size()).isEqualTo(arrayTest.length + 3);
        assertThat(stringList.get(8)).isEqualTo("7");
        assertThat(stringList.lastIndexOf("7")).isEqualTo(8);
        assertThat(stringList.indexOf("7")).isEqualTo(0);

    }

    @Test
    void removeTest() {
        String[] arrayTest = {"1", "2", "3", "4", "5", "6"};
        add(arrayTest);

        stringList.remove( "3");
        assertThat(stringList.size()).isEqualTo(arrayTest.length - 1);
        assertThat(stringList.get(2)).isEqualTo("4");

        stringList.remove( 3);
        assertThat(stringList.size()).isEqualTo(arrayTest.length - 2);
        assertThat(stringList.get(3)).isEqualTo("6");


    }

    @Test
    void removeNegativTest() {
        String[] arrayTest = {"1", "2", "3", "4", "5", "6"};
        add(arrayTest);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> stringList.remove("7"));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> stringList.remove(6));
    }

    @Test
    void addNegativTest() {
        String[] arrayTest = {"1","2","3","4","5","6"};
        add(arrayTest);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->stringList.add(7,"7"));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->stringList.add(2,null));

    }

    @Test
    void addNegativ2Test() {
        String[] arrayTest = {"1", "2", "3", "4", "5", "6","7","8","9","10"};
        add(arrayTest);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->stringList.add("11"));

    }
    private void add(String[] arrayTest) {
        assertThat(stringList.isEmpty()).isTrue();
        Stream.of(arrayTest).forEach(stringList::add);
        assertThat(stringList.size()).isEqualTo(arrayTest.length);
    }

}
