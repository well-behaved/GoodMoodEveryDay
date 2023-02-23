package com.xue.demo.algorithmGraph;

import com.xue.demo.algorithm.bean.AMGraph;

/**
 * @author: xuexiong@souche.com
 * @date: 2023/2/22 17:15
 * @description: 遍历例子
 */
public class IteratorDemo {
    public static void main(String[] args) {

        AMGraph amGraph = AMGraph.builderRandom();
        amGraph.printAll();
        //深度遍历
        deepIterator(amGraph);

    }

    /**
     * 深度遍历
     *
     * @param amGraph
     */
    private static void deepIterator(AMGraph amGraph) {
        //定义一个头部节点 也就是起始节点
        int headPoint = 0;
        amGraph.getPoints();

    }
}
