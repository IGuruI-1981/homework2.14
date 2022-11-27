package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class IntegerListTest {

    private final IntegerList integerList = new IntegerListImpl();

    @AfterEach
    public void afterEach() {
        integerList.clear();
    }

    @Test
    void addTest() {
        Integer[] arrayTest = {1,2,3,4,5,6};
        add(arrayTest);

        for (int i = 0; i < arrayTest.length; i++) {
            assertThat(integerList.get(i)).isEqualTo(arrayTest[i]);
            assertThat(integerList.contains(arrayTest[i])).isTrue();
            assertThat(integerList.indexOf(arrayTest[i])).isEqualTo(i);
            assertThat(integerList.lastIndexOf(arrayTest[i])).isEqualTo(i);

        }

        assertThat(integerList.toArray()).hasSize(arrayTest.length);
        assertThat(integerList.toArray()).containsExactly(arrayTest);


        integerList.add(0, 7);
        assertThat(integerList.size()).isEqualTo(arrayTest.length + 1);
        assertThat(integerList.get(0)).isEqualTo(7);

        integerList.add(2, 7);
        assertThat(integerList.size()).isEqualTo(arrayTest.length + 2);
        assertThat(integerList.get(2)).isEqualTo(7);
        assertThat(integerList.lastIndexOf(7)).isEqualTo(2);
        assertThat(integerList.indexOf(7)).isEqualTo(0);

        integerList.add(8, 7);
        assertThat(integerList.size()).isEqualTo(arrayTest.length + 3);
        assertThat(integerList.get(8)).isEqualTo(7);
        assertThat(integerList.lastIndexOf(7)).isEqualTo(8);
        assertThat(integerList.indexOf(7)).isEqualTo(0);

    }


    @Test
    void setTest() {
        Integer[] arrayTest = {1, 2, 3, 4, 5, 6};
        add(arrayTest);

        integerList.set(4, 7);
        assertThat(integerList.size()).isEqualTo(arrayTest.length );
        assertThat(integerList.get(4)).isEqualTo(7);
        assertThat(integerList.indexOf(7)).isEqualTo(4);
    }

    @Test
    void setNegativTest() {
        Integer[] arrayTest = {1, 2, 3, 4, 5, 6};
        add(arrayTest);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> integerList.set(6, 7));

    }

    @Test
    void getNegativTest() {
        Integer[] arrayTest = {1, 2, 3, 4, 5, 6};
        add(arrayTest);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> integerList.get(6));

    }


    @Test
    void removeTest() {
        Integer[] arrayTest = {1, 2, 3, 4, 5, 6};
        add(arrayTest);

        integerList.remove( 3);
        assertThat(integerList.size()).isEqualTo(arrayTest.length - 1);
        assertThat(integerList.get(3)).isEqualTo(5);

        integerList.remove(Integer.valueOf(3));
        assertThat(integerList.size()).isEqualTo(arrayTest.length - 2);
        assertThat(integerList.get(3)).isEqualTo(6);


    }

    @Test
    void removeNegativTest() {
        Integer[] arrayTest = {1, 2, 3, 4, 5, 6};
        add(arrayTest);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> integerList.remove(Integer.valueOf(7)));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> integerList.remove(6));
    }

    @Test
    void addNegativTest() {
        Integer[] arrayTest = {1,2,3,4,5,6};
        add(arrayTest);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()-> integerList.add(7,7));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()-> integerList.add(2,null));

    }

    @Test
    void addNegativ2Test() {
        Integer[] arrayTest = {1, 2, 3, 4, 5, 6,7,8,9,10};
        add(arrayTest);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()-> integerList.add(11));

    }


    private void add(Integer[] arrayTest) {
        assertThat(integerList.isEmpty()).isTrue();
        Stream.of(arrayTest).forEach(integerList::add);
        assertThat(integerList.size()).isEqualTo(arrayTest.length);
    }

}
