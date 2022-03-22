package com.xue.demo.algorithm.set;

import com.xue.demo.algorithm.bean.NodeBean;

/**
 * @author: xuexiong@souche.com
 * @date: 2020-04-16 11:32
 * @description: 链表
 */
public class Link {
    public static void main(String[] args) {
        NodeBean nodeBean = new NodeBean();
        nodeBean.ramdomInit();
        nodeBean.printSelf();
        System.out.print("链表反转递归:");
        NodeBean bean = reverseList(nodeBean);
        bean.printSelf();


        NodeBean nodeBean2 = new NodeBean();
        nodeBean2.ramdomInit();
        nodeBean2.printSelf();
        System.out.print("链表反转循环:");
        NodeBean bean2 = reverseForList(nodeBean2);
        bean2.printSelf();

    }

    /**
     * 链表反转 循环
     *
     * @param nodeBean2
     * @return
     */
    private static NodeBean reverseForList(NodeBean root) {
        if (root == null || root.getNext() == null) {
            return root;
        }
        //前一个节点
        NodeBean preNode = null;
        //当前节点
        NodeBean nowNode = root;

        while (nowNode != null) {
            //下一个节点 临时存储,因为当前节点反转后，会丢失下一个节点，所以需要提前存储
            NodeBean nextNode = nowNode.getNext();
            //当前节点反转
            nowNode.setNext(preNode);

            //节点后移
            preNode = nowNode;
            nowNode = nextNode;
        }
        return preNode;

    }

    /**
     * 链表反转
     *
     * @param
     * @return
     * @author xuexiong@souche.com  15:31 2020-04-16
     **/
    public static NodeBean reverseList(NodeBean root) {
        if (root == null || root.getNext() == null) {
            return root;
        }
        //得到当前节点的下一节点
        NodeBean nextNode = root.getNext();
        //打断当前指针链
        root.setNext(null);
        //每次递归下一节点进行反转
        NodeBean re = reverseList(nextNode);
        //反转指针域
        nextNode.setNext(root);
        return re;
    }
}
