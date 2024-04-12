package com.xue.demo.algorithm.demo;

import com.xue.demo.algorithm.bean.NodeBean;
import com.xue.demo.algorithm.bean.TreeNodeBean;

/**
 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

 k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class K个一组翻转链表 {
    public static void main(String[] args) {
        NodeBean nodeBean = new NodeBean();
        nodeBean.initByArray(new int[]{1,2,3,4,5});
        nodeBean.printSelf();
        NodeBean nodeBean1 = reverseKGroup(nodeBean, 3);
        nodeBean1.printSelf();
    }
    public static NodeBean reverseKGroup(NodeBean head, int k) {
        NodeBean newHead = gerReverseHead(head,k);
        //反转
        reverseKGroupByK(null,head,k);

        //返回第一次的翻转头部
        return newHead;
    }
    public static void reverseKGroupByK(NodeBean beforeLastNode,NodeBean head, int k) {
        //翻转前k个后的头部
        NodeBean headReverse = gerReverseHead(head,k);
        if( headReverse== null){
            //上一个链表的最后一个  和  本次的第一个连起来
            beforeLastNode.next = head;
            //已经到达默认
            return;
        }

        //本次翻转
        NodeBean preNodeTemp = null;
        NodeBean nowNode = head;
        for(int i = 0 ; i< k; i++){
            //缓存下一个
            NodeBean nextNodeTemp = nowNode.next;
            //当前翻转
            nowNode.next = preNodeTemp;
            //下一次更新
            preNodeTemp = nowNode;
            nowNode = nextNodeTemp;
        }
        if(beforeLastNode != null){
            //上一个链表的最后一个  和  本次的第一个连起来
            beforeLastNode.next = headReverse;
        }

        //翻转下一次
        reverseKGroupByK(head,nowNode,k);
    }
    public static NodeBean gerReverseHead(NodeBean head, int k) {
        //判断是否可以到达末尾 并且返回头结点
        NodeBean tempNode = head;
        for(int i = 0;i<k-1 && tempNode!=null;i++){
             tempNode = tempNode.next;
        }
        return tempNode;
    }
}