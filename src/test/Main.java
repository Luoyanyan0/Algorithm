package test;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 班级人数
        int studentNumber = in.nextInt();

        // 学生成绩
        int[] studentScore = new int[studentNumber];
        for (int i = 0; i < studentNumber; i++) {
            studentScore[i] = in.nextInt();
        }

        // 查询的次数
        int queryCount = in.nextInt();
        // 查询的位置
        int queryPosition[] = new int[queryCount];
        for (int i = 0; i < queryCount; i++) {
            queryPosition[i] = in.nextInt();
        }

        for (int i = 0; i < queryCount; i++) {
            int currentPosition = queryPosition[i] - 1;
            int currentScore = studentScore[currentPosition];
            int biggerCount = 0;
            for (int j = 0; j < studentScore.length; j++) {
                if (studentScore[j] <= currentScore) {
                    biggerCount++;
                }
            }
            double result = (double)((biggerCount - 1) * 100) / studentNumber;
            System.out.println(String.format("%.6f",result));
        }
    }
}


/*public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] score = new int[length];
        for(int i = 0; i< length; i++){
            score[i] = in.nextInt();
        }
        //Arrays.sort(score);
        int times = in.nextInt();
        for(int i = 0;i < times; i ++){
            int index = in.nextInt();
            int count = 0;
            for(int j =0; j < length; j++){
                if(score[j] <= score[index-1]){
                    count++;
                }
            }
            double percent = (count-1)*100*1.0/length;
            System.out.println(String.format("%.6f", percent));
            BigDecimal bg = new BigDecimal(percent).setScale(6, RoundingMode.HALF_UP);
            System.out.println(bg);
        }
    }
}*/
