package com.xue.demo.algorithm.bean;

import java.util.Random;

/**
 * 链表
 *
 * @param
 * @author xuexiong@souche.com  11:36 2020-04-16
 * @return
 **/
public class NodeBean {
    /**
     * 数据
     *
     * @author xuexiong@souche.com  11:37 2020-04-16
     * @param
     * @return
     **/
    private Object data;
    /**
     * 当前链表
     *
     * @author xuexiong@souche.com  11:37 2020-04-16
     * @param
     * @return
     **/
    private NodeBean next;

    public NodeBean(Object data, NodeBean next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public NodeBean getNext() {
        return next;
    }

    public void setNext(NodeBean next) {
        this.next = next;
    }

    public NodeBean() {
    }

    /**
     * 初始换一个链表类 随机值
     *
     * @param
     * @return
     * @author xuexiong@souche.com  11:42 2020-04-16
     **/
    public void ramdomInit() {
        this.setData((new Random().nextInt(5000)));
        for (int i = 0; i < (Math.random() * 20+5); i++) {
            NodeBean lastestNode = this;
            while (lastestNode.getNext() != null) {
                lastestNode = lastestNode.next;
            }
            NodeBean lasteNodeNew = new NodeBean();
            lastestNode.setNext(lasteNodeNew);
            lasteNodeNew.setData(new Random().nextInt(5000));
        }
    }

    /**
     * 初始换一个链表类 随机值
     *
     * @param
     * @return
     * @author xuexiong@souche.com  11:42 2020-04-16
     **/
    public void printSelf() {
        NodeBean nodeBean = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (nodeBean.getNext()!=null){
            stringBuilder.append(nodeBean.data).append(" -> ");
            nodeBean = nodeBean.getNext();
        }
        stringBuilder.append(nodeBean.data).append(" -> ");
        System.out.println(stringBuilder.toString());
    }
}
