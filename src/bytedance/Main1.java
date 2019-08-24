package bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 19:03 2019/8/11
 */
public class Main1 {
    public static void main(String[] args) {
        /*Scanner sca = new Scanner(System.in);
        int clockCount = sca.nextInt();

        int[][] clockTime = new int[clockCount][2];
        for (int i = 0; i < clockCount; i++) {
            for (int j = 0; j < 2; j++) {
                clockTime[i][j] = sca.nextInt();
            }
        }

        int timeToClassroom = sca.nextInt();

        int [][] timeToStudy = new int[1][2];
        for (int i = 0; i < 2; i++) {
            timeToStudy[0][i] = sca.nextInt();
        }*/


        int clockCount = 3;

        int[][] clockTime = {{5,0},{6,0},{7,0}};

        int timeToClassroom = 59;

        int [][] timeToStudy = {{6,59}};

        Arrays.sort(clockTime, Comparator.comparingInt(o->o[0]));

        long timeToStudyMinute = hourToMinute(timeToStudy[0][0],timeToStudy[0][1]);

       int latestTime[][] = new int[1][2];
       for (int i = clockCount - 1; i >= 0; i--) {
           long finalTime = hourToMinute(clockTime[i][0],clockTime[i][1]) + timeToClassroom;
           if (finalTime <= timeToStudyMinute) {
                latestTime[0][0] = clockTime[i][0];
                latestTime[0][1] = clockTime[i][1];
                break;
           }
       }

        System.out.println(latestTime[0][0] + " " + latestTime[0][1]);

    }


    private static long hourToMinute(int hour, int minute){
        return hour * 60 + minute;
    }
}
