package com.xue.demo.algorithm.bean;

import java.util.Random;

/**
 * 基于邻接矩阵表示法的无向图
 *
 * @param
 * @author xuexiong@souche.com  11:36 2020-04-16
 * @return
 **/
public class AMGraph {
    /**
     * 点集信息
     */
    private String[] points = null;
    /**
     * 边集信息 二维数组ij  ij表示点集中对应数组角标的某两个点
     * 0或者空 表示该位置对应的两个顶点之间没有边
     * 1 表示有边
     */
    private int[][] lines = null;


    /**
     * 打印一个图
     *
     * @return
     */
    public void printAll() {
        //打印所有点
        System.out.print("点:");
        for (String point : points) {
            System.out.print("[" + point + "],");
        }
        //打印所有边
        System.out.println();
        System.out.print("边:");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length; j++) {
                //随机加一条边
                if (lines[i][j] == 1) {
                    System.out.print("[" + i + "," + j + "],");
                }
            }

        }
        //打印个图

    }

    /**
     * 获取一个随机的 连通图
     *
     * @return
     */
    public static AMGraph builderRandom() {
        //顶点个数随机
        int pointNum = new Random().nextInt(4) + 5;

        String[] points = new String[pointNum];
        for (int i = 0; i < pointNum; i++) {
            points[i] = "点" + i;
        }

        //边随机 伪随机吧先
        int[][] lines = new int[pointNum][pointNum];
        //先保证图的联通性 1到2 2到3 3到4.。。。
        for (int i = 0; i < pointNum - 1; i++) {
            // i 到 i+1
            lines[i][i + 1] = 1;
        }
        //随机边
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length; j++) {
                //随机加一条边
                if (lines[i][j] != 1 && i < j && new Random().nextInt() % pointNum == 0) {
                    lines[i][j] = 1;
                }
            }

        }
        return new AMGraph(points, lines);
    }


    public AMGraph(String[] points, int[][] lines) {
        this.points = points;
        this.lines = lines;
    }

    public AMGraph() {
    }

    public String[] getPoints() {
        return points;
    }

    public void setPoints(String[] points) {
        this.points = points;
    }

    public int[][] getLines() {
        return lines;
    }

    public void setLines(int[][] lines) {
        this.lines = lines;
    }
}