package code.testing.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayManipulation {
    public static void main(String[] args) {
        try {
            List<Integer> list = new ArrayList<>(10);
            list.add(3, 5); // 就算前面有設定預設寬度，這邊要塞入指定 index 還是會報錯
            System.out.println(list);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException: " + e.getMessage());
        }
        {
            List<Integer> list = new ArrayList<>(Collections.nCopies(10, 3));
            list.set(5, 4); // 會將 index 5 的值改成 4，總數量還是 10
            System.out.println("List after setting index 5 to 3: " + list);
        }
        {
            List<Integer> list = new ArrayList<>(Collections.nCopies(10, 3));
            list.add(5, 4); // 會從 index 5 之後加入4，總數量會變成 11
            System.out.println("List after adding index 5 to 3: " + list);
        }
    }
}
