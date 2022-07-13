package com.speedment.example.solution;

import com.speedment.example.unit.Unit3Terminal;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.*;

public final class Unit3MyTerminal implements Unit3Terminal {

    @Override
    public void addToSet(Stream<String> stream, Set<String> set) {
        set.addAll(stream.collect(Collectors.toList()));
    }

    @Override
    public void addToListInOrder(Stream<String> stream, List<String> list) {
        list.addAll(stream.collect(Collectors.toList()));
    }

    @Override
    public Set<String> collectToSet(Stream<String> stream) {
        return stream.collect(Collectors.toSet());
    }

    @Override
    public List<String> collectToList(Stream<String> stream) {
        return stream.collect(Collectors.toList());
    }

    @Override
    public String collectJoining(Stream<String> stream) {
        return stream.collect(Collectors.joining("->"));
    }

    /**
    https://stackoverflow.com/questions/23079003/how-to-convert-a-java-8-stream-to-an-array
    **/
     @Override
    public String[] toArray(Stream<String> stream) {
        return stream.toArray((arrSize)->new String[arrSize]);
    }

    @Override
    public Map<String, Integer> collectToMap(Stream<String> stream) {

        return stream.collect(Collectors.toMap(elem->elem, elem->elem.length()));
    }

    @Override
    public int countCharacters(Stream<String> stream) {
        return stream.mapToInt(str->str.length()).sum();
    }

    @Override
    public int maxWordLen(Stream<String> stream) {
         Comparator<String> comp = (str1, str2)-> str1.length()-str2.length();
         Optional<String> longestWord = stream.max(comp);
         if (longestWord.isPresent()) return longestWord.get().length();
         return 0;
    }

    @Override
    public IntSummaryStatistics statistics(Stream<String> stream) {
        return stream.mapToInt(str->str.length()).summaryStatistics();
    }

    @Override
    public Optional<String> findLongestString(Stream<String> stream) {
        Comparator<String> comp = (str1, str2)-> str1.length()-str2.length();
        return stream.max(comp);
    }

    /**
     * https://stackoverflow.com/questions/54788400/how-can-i-group-strings-based-on-their-length
     * @param stream with input elements
     * @return
     */
    @Override
    public Map<Integer, List<String>> wordsGroupedByLength(Stream<String> stream) {
        return stream.collect(Collectors.groupingBy(str->str.length()));
    }

    @Override
    public Map<Integer, Long> wordsGroupedByLengthCounted(Stream<String> stream) {
        return stream.collect(Collectors.groupingBy(str->str.length(), Collectors.counting()));
    }

}
