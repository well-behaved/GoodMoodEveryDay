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
        /*
                      1
           2                       3
       34                  31            54
                             312
         */
        TreeNodeBean treeNodeBean = new TreeNodeBean(1
                , new TreeNodeBean(2, new TreeNodeBean(34, null, null), null)
                , new TreeNodeBean(3
                , new TreeNodeBean(31, null, new TreeNodeBean(312, null, null)), new TreeNodeBean(54)));
        System.out.println("\n\r" + "层序遍历");
        levelTraversal(treeNodeBean);
        System.out.println("\n\r" + "前序遍历");
        preorderTraversal(treeNodeBean);
        System.out.println("\n\r" + "中序遍历");
        sequentialTraversal(treeNodeBean);
        System.out.println("\n\r" + "后序遍历");
        postOrderTraversal(treeNodeBean);
        System.out.println("\n\r" + "树的最大高度为:" + height(treeNodeBean));
        System.out.println("\n\r" + "判断一棵树是否为平衡树:" + isAvl(treeNodeBean));
        //判断一个树是另一个树的子树
        TreeNodeBean parent = new TreeNodeBean();
        TreeNodeBean children = new TreeNodeBean();
        ischildren(parent, children);

    }

    /**
     * 判断一个树是否为另一个树的子树
     *
     * @param
     * @return
     * @author xuexiong@souche.com  22:08 2020-03-19
     **/
    private static void ischildren(TreeNodeBean parent, TreeNodeBean children) {
        //层序遍历 + 递归比较
        QueueBean<TreeNodeBean> queueBean = new QueueBean<>();
        queueBean.add(parent);
        ischildren(queueBean, children);

    }

    /**
     * 判断一个树是否为另一个树的子树
     * 层序遍历 + 递归判断
     * @param
     * @return
     * @author xuexiong@souche.com  22:08 2020-03-19
     **/
    private static void ischildren(QueueBean<TreeNodeBean> parent, TreeNodeBean children) {
        TreeNodeBean treeNodeBean = parent.get();
        if (isSame(treeNodeBean.getLeft(), children.getLeft())) {
            return;
        }
        parent.add(treeNodeBean.getRight());
        parent.add(treeNodeBean.getLeft());
        if (parent.isNull()) {
            return;
        }
        ischildren(parent, children);
    }

    /**
     * 是否相等
     *
     * @param
     * @return
     * @author xuexiong@souche.com  22:25 2020-03-19
     **/
    private static boolean isSame(TreeNodeBean left, TreeNodeBean left1) {
        return left.getVal().equals(left1.getVal()) && isSame(left.getLeft(), left1.getLeft()) &&
                isSame(left.getRight(), left1.getRight());
    }


    /**
     * 判断一颗树是否为平衡树
     * <p>
     * 只要子树是平衡树，那么就是二叉树
     *
     * @param
     * @return
     * @author xuexiong@souche.com  22:01 2020-03-09
     **/
    private static boolean isAvl(TreeNodeBean treeNodeBean) {
        if (treeNodeBean == null) {
            return true;
        }
        if (Math.abs(height(treeNodeBean.getLeft()) - height(treeNodeBean.getRight())) > 1) {
            return false;
        } else {
            return isAvl(treeNodeBean.getLeft()) && isAvl(treeNodeBean.getRight());
        }
    }


    /**
     * 求树的高度
     *
     * @param
     * @return
     * @author xuexiong@souche.com  21:52 2020-03-09
     **/
    private static int height(TreeNodeBean treeNodeBean) {
        if (treeNodeBean == null) {
            return 0;
        }
        return Math.max(height(treeNodeBean.getRight()), height(treeNodeBean.getLeft())) + 1;
    }

    /**
     * 前序遍历 先中间 后两边
     *
     * @param
     * @return
     * @author xuexiong@souche.com  21:40 2020-03-09
     **/
    private static void preorderTraversal(TreeNodeBean treeNodeBean) {
        if (treeNodeBean == null) {
            return;
        }
        Integer val = treeNodeBean.getVal();
        if (val != null) {
            System.out.print(val + ",");
        }
        preorderTraversal(treeNodeBean.getLeft());
        preorderTraversal(treeNodeBean.getRight());
    }

    /**
     * 中序遍历 先左边 再中间 后右边
     *
     * @param
     * @return
     * @author xuexiong@souche.com  21:40 2020-03-09
     **/
    private static void sequentialTraversal(TreeNodeBean treeNodeBean) {
        if (treeNodeBean == null) {
            return;
        }
        Integer val = treeNodeBean.getVal();
        preorderTraversal(treeNodeBean.getLeft());
        if (val != null) {
            System.out.print(val + ",");
        }
        preorderTraversal(treeNodeBean.getRight());
    }

    /**
     * 后序遍历 先左边 后后面 在中间
     *
     * @param
     * @return
     * @author xuexiong@souche.com  21:40 2020-03-09
     **/
    private static void postOrderTraversal(TreeNodeBean treeNodeBean) {
        if (treeNodeBean == null) {
            return;
        }
        Integer val = treeNodeBean.getVal();
        postOrderTraversal(treeNodeBean.getLeft());
        postOrderTraversal(treeNodeBean.getRight());
        if (val != null) {
            System.out.print(val + ",");
        }
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
            System.out.print(nodeBean.getVal() + ",");
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
