//package com.apismensky;
//
//import static com.google.common.collect.Lists.newArrayList;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
///**
// * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
// *
// * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
// *
// * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
// *
// * Example 1:
// *
// * Input: [[1,1],2,[1,1]]
// * Output: 8
// * Explanation: Four 1's at depth 1, one 2 at depth 2.
// * Example 2:
// *
// * Input: [1,[4,[6]]]
// * Output: 17
// * Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
// */
//class NestedWeightListSumII {
//
//    private static class NestedInteger {
//
//        private List<NestedInteger> list;
//
//        private Integer val;
//
//        public NestedInteger(List<NestedInteger> list) {
//            this.list = list;
//        }
//
//        public NestedInteger(int value) {
//            this.val = value;
//        }
//
//        public boolean isInteger() {
//            return val != null;
//        }
//
//        public Integer getInteger() {
//            return val;
//        }
//
//        public void setInteger(int value) {
//            this.val = value;
//        }
//
//        public List<NestedInteger> getList() {
//            return list;
//        }
//    }
//
////    private static class NodeInfo {
////        public NodeInfo(int depth, int sum) {
////            this.depth = depth;
////            this.sum = sum;
////        }
////        int depth; // node depth
////        int sum; // sum of all weights of current node + all children
////
////        @Override
////        public String toString() {
////            return "NodeInfo{depth:" + depth + ", sum:" + sum + "}";
////        }
////    }
////
////
////    private int depth(List<NestedInteger> nestedList) {
////        if (nestedList == null) {
////            return 0;
////        }
////        Iterator<NestedInteger> iter = nestedList.iterator();
////        int maxDepth = 0;
////        while (iter.hasNext()) {
////            NestedInteger ni = iter.next();
////            int depth = depth(ni.getList()) + 1;
////            if (depth > maxDepth) {
////                maxDepth = depth;
////            }
////        }
////        System.out.println(maxDepth);
////        return maxDepth;
////    }
////    private NodeInfo traverse(List<NestedInteger> nestedList) {
////        if (nestedList == null) {
////            return new NodeInfo(0, 0);
////        }
////
////        Iterator<NestedInteger> iter = nestedList.iterator();
////        int maxDepth = 0;
////        while (iter.hasNext()) {
////            NestedInteger ni = iter.next();
////            NodeInfo nodeInfo = traverse(ni.getList());
////            if (nodeInfo.depth > maxDepth) {
////                maxDepth = nodeInfo.depth;
////            }
////        }
////        System.out.println("maxDepth: "  + maxDepth);
////        int sum = 0;
////        iter = nestedList.iterator();
////        while (iter.hasNext()) {
////            NestedInteger ni = iter.next();
////            if (ni.getInteger() != null) {
////                sum += ni.getInteger();
////            }
////            NodeInfo nodeInfo = traverse(ni.getList());
////            sum += nodeInfo.sum * maxDepth;
////        }
////        NodeInfo result = new NodeInfo(maxDepth + 1, sum);
////        System.out.println(result);
////        return result;
////    }
//
////    public int depthSumInverse(List<NestedInteger> nestedList) {
//////        NodeInfo ni = traverse(nestedList);
//////        return ni.sum;
////    }
//
////    private Map<NestedInteger, Integer> dp;
////    private int maxDepth;
////    public int depthSumInverse(List<NestedInteger> nestedList) {
////        this.dp = new HashMap<>();
////        maxDepth = 0;
////        traverse(nestedList, 1);
////        return maxDepth;
////    }
////
////
////    private void traverse(List<NestedInteger> nestedList, int depth) {
////        if (nestedList == null) {
////            return;
////        }
////        Iterator<NestedInteger> iter = nestedList.iterator();
////        while (iter.hasNext()) {
////            NestedInteger ni = iter.next();
////            dp.put(ni, depth);
////            traverse(ni.getList(), depth + 1);
////        }
////        maxDepth++;
////    }
//
//
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        //return traverse(nestedList, 0);
//
//    }
//
//
//    public static void main(String[] args) {
//
//        List<NestedInteger> list = newArrayList(new NestedInteger(newArrayList(new NestedInteger(1), new NestedInteger(1))),
//                                                new NestedInteger(2),
//                                                new NestedInteger(newArrayList(new NestedInteger(1), new NestedInteger(1))));
////        int depthSumInverse = new NestedWeightListSumII().depthSumInverse(list);
////        System.out.println(depthSumInverse);
//        System.out.println(new NestedWeightListSumII().depthSumInverse(list));
//
//    }
//
//}
