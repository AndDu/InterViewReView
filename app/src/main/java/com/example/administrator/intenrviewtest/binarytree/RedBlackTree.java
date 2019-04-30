package com.example.administrator.intenrviewtest.binarytree;

/**
 * Created by YellowHuang on 2019/4/28.
 */

public class RedBlackTree<T> {


    private RedBlackTree<T> parent;
    private RedBlackTree<T> left;
    private RedBlackTree<T> right;
    private static final int RED = 1;
    private static final int BLACK = 2;
    private int Color = RED;

    public static <T> void roateLeft(RedBlackTree<T> p) {

        RedBlackTree<T> right = p.right;
        RedBlackTree<T> left = p.right.left;
        p.right = left;

        if (p.parent == null) {
            //根节点变成right
        } else if (p.parent.left == p) {
            p.parent.left = right;
        } else {
            p.parent.right = right;
        }

        right.parent = p.parent;
        p.parent = right;
    }

    public static <T> void roateRight(RedBlackTree<T> p) {
        RedBlackTree<T> left = p.left;
        RedBlackTree<T> right = p.right;
        p.left = p.left.right;
        left.right = p;
        if (p.parent == null) {
            //根节点变成left
        } else if (p.parent.left == p) {
            p.parent.left = left;
        } else {
            p.parent.right = left;
        }

        left.parent = p.parent;
        p.parent = left;

    }


}
