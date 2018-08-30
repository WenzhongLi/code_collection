package leetcode_google;

import java.util.*;

public class CountofSmallerNumbersAfterSelf_315 {
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> result = new LinkedList<Integer>();

        if(nums == null || nums.length == 0){
            return result;
        }
        result.add(0);
        node root = new node(nums[nums.length - 1]);

        for(int i = nums.length - 2;i>=0; i--){
            int r = add(root, nums[i]);
            result.addFirst(r);
        }
        return result;
    }
    private int add(node currentNode, int num){
        int countSmallNum = 0;
        while(true){
            if(currentNode.value < num){
                countSmallNum += currentNode.numSmall;
                if(currentNode.right == null){
                    currentNode.right = new node(num);
                    return countSmallNum;
                }else{
                    currentNode = currentNode.right;
                }
            }else{
                currentNode.numSmall ++;

                if(currentNode.left == null){
                    currentNode.left = new node(num);
                    return countSmallNum;
                }else{
                    currentNode = currentNode.left;
                }
            }
        }
    }
    class node{
        int numSmall = 1;//set to one because every node on its right has to be bigger then it, so that is at least on element smaller it.
        //it marks the all left tree from this node has numSmall - 1 num that is smaller then this.
        int value = 0;
        node left, right;
        node (int value){
            this.value = value;
        }
    }
}
