package com.example.administrator.intenrviewtest.binarytree;

/**
 * Created by YellowHuang on 2019/4/12.
 */

public class NodeTree {

    private char data;
    private NodeTree leftChild;
    private NodeTree rightChild;

    public NodeTree(char data, NodeTree leftChild, NodeTree rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public NodeTree() {

    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public NodeTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeTree leftChild) {
        this.leftChild = leftChild;
    }

    public NodeTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeTree rightChild) {
        this.rightChild = rightChild;
    }


    public static NodeTree CreateTree(String expression) {
        NodeTree node[] = new NodeTree[40]; // 用Node数组临时保存根节点位置
        NodeTree head = null, temp = null;   //head记录头节点位置，temp是碰到字母时临时生成的节点
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
                    temp = new NodeTree(data, null, null);// 碰到字母，直接创建相应节点
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


    public static String expression = "A(B(D(,G)),C(E,F))";



    /*
        A(B(D(,G)),C(E,F))
        A(B(D(,G)),C(E,F))
        A(B(D(,G),),C(E,F))

     */
    static NodeTree createTree(String expression) {


        if (expression == null) return new NodeTree();
        char[] chars = expression.toCharArray();
        NodeTree nodeTrees[] = new NodeTree[chars.length];
        NodeTree temp = null;
        int index = 0;
        Future future = Future.LEFT;
        for (int i = 0; i < chars.length; i++) {
            char s = chars[i];
            switch (s) {
                case '(':
                    temp = nodeTrees[index];
                    ++index;
                    future = Future.LEFT;
                    break;
                case ')':
                    --index;
                    if (index != 0) {
                        temp = nodeTrees[index - 1];
                    } else {
                        temp = nodeTrees[0];
                    }
                    future = Future.LEFT;
                    break;
                case ',':
                    future = Future.RIGHT;
                    break;
                default:
                    nodeTrees[index] = new NodeTree();
                    nodeTrees[index].setData(s);
                    if (temp == null || index == 0) {
                        continue;
                    }
                    if (future == Future.LEFT) {
                        temp.setLeftChild(nodeTrees[index]);
                    } else {
                        temp.setRightChild(nodeTrees[index]);
                    }
                    break;
            }
        }
        return nodeTrees[0];
    }

    enum Future {
        LEFT, RIGHT
    }


    static String printTree(NodeTree nodeTree) {
        if (nodeTree == null) return "";
        StringBuilder builder = new StringBuilder("");
        NodeTree leftChild = nodeTree.getLeftChild();
        NodeTree rightChild = nodeTree.getRightChild();
        char data = nodeTree.getData();
        StringBuilder append = builder.append(data);
        String lefts = printTree(leftChild);
        String rights = printTree(rightChild);
        if (lefts.length() != 0) {
            if (rights.length() != 0) {
                append.append("(").append(printTree(leftChild));
            } else {
                append.append("(").append(printTree(leftChild)).append(")");
            }

        }

        if (rights.length() != 0) {
            if (lefts.length() == 0) {
                append.append("(,").append(rights).append(")");
            } else {
                append.append(",").append(rights).append(")");
            }

        }
        return builder.toString();
    }


    public static void main(String[] args) {//"A(B(D(,G)),C(E,F))"
        NodeTree tree = createTree(expression);
        String s = printTree(tree);
        System.out.print(s);
    }

}
