package com.example.administrator.intenrviewtest.binarytree;

/**
 * Created by YellowHuang on 2019/4/12.
 */

public class Node {

    private char data;
    private Node leftChild;
    private Node rightChild;

    public Node(char data, Node leftChild, Node rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    String expression = "A(B(D(,G)),C(E,F))";

    public static Node CreateTree(String expression) {
        Node node[] = new Node[40]; // 用Node数组临时保存根节点位置
        Node head = null, temp = null;   //head记录头节点位置，temp是碰到字母时临时生成的节点
        int childTag = 0; // 定义一个孩子节点的标记，判断为坐还是右
        int height = -1; // 记录根节点在数组中的位置，便于设置其左右孩子节点
        char[] exps = expression.toCharArray(); // 将传进来的字符串分割为字符数组

        for (int i = 0; i < exps.length; i++) {
            char data = exps[i];
            switch (data) {
                case '(': // 准备创建左孩子节点，并且把"("之前的节点保存到数组中
                    height++;     //位置自增
                    node[height] = temp;   //将"("之前的那个节点保存到数组中
                    childTag = 1;          //准备创建左孩子节点
                    break;
                case ',':
                    childTag = 2;      // 准备创建右孩子节点
                    break;
                case ')': // 返回上一级节点
                    height--; //位置自减，定位到根节点数组中的上一个位置
                    break;
                default:
                    temp = new Node(data, null, null);// 碰到字母，直接创建相应节点
                    if (head == null) {
                        head = temp;
                    } else {
                        switch (childTag) {
                            case 1:
                                node[height].setLeftChild(temp);
                                break;
                            case 2:
                                node[height].setRightChild(temp);
                                break;
                        }
                    }
            }
        }
        return head;
    }

}
