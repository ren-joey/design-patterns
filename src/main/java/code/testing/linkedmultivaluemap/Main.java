package code.testing.linkedmultivaluemap;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedMultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("key1", "value1");
        multiValueMap.add("key1", "value2");
        multiValueMap.add("key2", "value3");
        multiValueMap.set("key2", "value4"); // replace the value of key2
        for (Map.Entry<String, List<String>> entry: multiValueMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}