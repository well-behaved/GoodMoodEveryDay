package com.xue.demo.algorithmGraph;

import com.xue.demo.algorithm.bean.AMGraph;

/**
 * @author: xuexiong@souche.com
 * @date: 2023/2/22 11:23
 * @description:
 */
public class Demo {
    public static void main(String[] args) {
        AMGraph amGraph = AMGraph.builderRandom();
        amGraph.printAll();
    }
}
