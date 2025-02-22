package com.learn.leetcode.daily.w2024.q202409;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/walking-robot-simulation/description/?envType=daily-question&envId=2024-09-04">Task</a>
 */
public final class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x=0,y=0,d=0;
        final int[][] direction={{0,1},{1,0},{0,-1},{-1,0}};
        int maxDistance=0;
        final Set<String> obstacleSet=new HashSet<>();
        for(int[] obstacle:obstacles){
            obstacleSet.add(obstacle[0]+","+obstacle[1]);
        }
        for(int cmd:commands){
            if(cmd==-1){
                d=(d+1)%4;
            }else if(cmd==-2){
                d=(d+3)%4;
            }else{
                for(int i=0;i<cmd;i++){
                    int nx=x+direction[d][0];
                    int ny=y+direction[d][1];
                    if(obstacleSet.contains(nx+","+ny)){
                        break;
                    }
                    x=nx;
                    y=ny;
                    maxDistance=Math.max(maxDistance,x*x+y*y);
                }
            }
        }
        return maxDistance;
    }
}
