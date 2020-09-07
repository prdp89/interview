package com.interview.leetcode.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class NestedListIterator {

    //https://leetcode.com/problems/flatten-nested-list-iterator/
    public static void main( String[] args ) {
        List<NestedInteger> listList = new ArrayList<>();
        listList.add(new NestedIntegerImpl(Arrays.asList(1, 1)));
      /*  listList.add();
        listList.add();*/

/*
        listList.iter();
        NestedIterator i = new NestedIterator(nestedList);
        while (i.hasNext()) v[f()] = i.next();*/
    }

    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    public static class NestedIntegerImpl implements NestedInteger {

        List<Object> list = new ArrayList<>();

        NestedIntegerImpl( List<Integer> list ) {
            this.list.addAll(0, list);
        }

        NestedIntegerImpl( Integer item ) {
            this.list.add(item);
        }

        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public List<NestedInteger> getList() {
            return null;
        }
    }

    public class NestedIterator implements Iterator<Integer> {

        public NestedIterator( List<NestedInteger> nestedList ) {

        }

        @Override
        public Integer next() {
            return 0;
        }

        @Override
        public boolean hasNext() {
            return false;
        }
    }
}
