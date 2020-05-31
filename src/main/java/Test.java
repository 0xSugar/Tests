import org.w3c.dom.css.Counter;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.LockSupport;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.*;

public class Test {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        addAll(list, 0,9,8,7,6,5,4,3,2,1);

        HashSet<Integer> set = new HashSet<>(list);

        Integer[] arr = list.toArray(new Integer[0]);

    }
}