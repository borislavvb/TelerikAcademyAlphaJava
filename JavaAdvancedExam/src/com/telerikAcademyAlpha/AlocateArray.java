package com.telerikAcademyAlpha;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AlocateArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        IntStream.range(0,in.nextInt())
                .map(x -> x*5)
                .forEach(System.out::println);
    }
}
