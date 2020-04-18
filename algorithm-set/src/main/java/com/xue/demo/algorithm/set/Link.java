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

        NodeBean bean = reverseList(nodeBean);
        bean.printSelf();

    }

    /**
     * 链表反转
     *
     * @param
     * @return
     * @author xuexiong@souche.com  15:31 2020-04-16
     **/
    public static NodeBean reverseList(NodeBean root) {
        if(root==null||root.getNext()==null){
            return root;
        }
        //得到当前节点的下一节点
        NodeBean nextNode=root.getNext();
        //打断当前指针链
        root.setNext(null);
        //每次递归下一节点进行反转
        NodeBean re=reverseList(nextNode);
        //反转指针域
        nextNode.setNext(root);
        return re;
    }
}
