package com.speedment.example.solution;

import com.speedment.example.unit.Unit2Intermediate;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Unit2MyIntermediate implements Unit2Intermediate {

    @Override
    public Stream<String> wordsLongerThanThreeChars(Stream<String> stream) {
        return stream.filter(word->word.length()>3);
    }

    @Override
    public Stream<String> firstTwoWordsLongerThanThreeChars(Stream<String> stream) {
        return stream.filter(word->word.length()>3).limit(2);
    }

    @Override
    public Stream<String> firstDistinctTwoWordsLongerThanThreeCharsInAlphabeticOrder(Stream<String> stream) {
        return stream.filter(word->word.length()>3).distinct().limit(2).sorted();
    }

    @Override
    public IntStream lengthOfWords(Stream<String> stream) {
        return stream.mapToInt(str->str.length());
    }

    @Override
    public IntStream increasingSawtooth() {
        return IntStream.iterate(0, i->i+1).flatMap((int ip)->IntStream.range(0, ip));
    }

    @Override
    public Stream<String> strings(Stream<Object> stream) {
        return stream.filter(obj->obj instanceof String).map(obj->(String)obj);
    }
}
