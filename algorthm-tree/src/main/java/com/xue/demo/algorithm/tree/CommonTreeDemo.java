package com.xue.demo.algorithm.tree;

import com.xue.demo.algorithm.bean.QueueBean;
import com.xue.demo.algorithm.bean.TreeNodeBean;

/**
 * @author: xuexiong@souche.com
 * @date: 2020-03-06 21:14
 * @description: 一般的树类算法
 */
public class CommonTreeDemo {
    public static void main(String[] args) {
        TreeNodeBean treeNodeBean = new TreeNodeBean(1
                , new TreeNodeBean(2, null, null)
                , new TreeNodeBean(3
                    , new TreeNodeBean(31, null, new TreeNodeBean(312,null,null)), null));
        //层序遍历
        levelTraversal(treeNodeBean);

    }

    /**
     * 二叉树层序遍历
     *
     * @param
     * @return
     * @author xuexiong@souche.com  21:31 2020-03-06
     **/
    private static void levelTraversal(TreeNodeBean treeNodeBean) {
        QueueBean<TreeNodeBean> queueBean = new QueueBean<>();
        queueBean.add(treeNodeBean);
        level(queueBean);
    }

    private static void level(QueueBean<TreeNodeBean> queueBean) {
        TreeNodeBean nodeBean = queueBean.get();
        if (nodeBean != null) {
            System.out.println(nodeBean.getVal());
            if (nodeBean.hasLeft()) {
                queueBean.add(nodeBean.getLeft());
            }
            if (nodeBean.hasRight()) {
                queueBean.add(nodeBean.getRight());
            }
        }
        if (queueBean.isNull()) {
            return;
        }
        level(queueBean);
    }
}
