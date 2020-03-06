package com.xue.demo.algorithm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: xuexiong@souche.com
 * @date: 2020-03-06 21:20
 * @description: 二叉树
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNodeBean {
    /**
     * 值
     */
    Integer val;
    /**
     * 左子节点
     */
    TreeNodeBean left;
    /**
     * 右子节点
     */
    TreeNodeBean right;

    /**
     * 左是否为空
     *
     * @param
     * @return
     * @author xuexiong@souche.com  21:54 2020-03-06
     **/
    public boolean hasLeft() {
        return this.left != null;

    }

    /**
     * 右是否为空
     *
     * @param
     * @return
     * @author xuexiong@souche.com  21:54 2020-03-06
     **/
    public boolean hasRight() {
        return this.right != null;

    }
}
