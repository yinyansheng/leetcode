package com.donne.newcoder;

import java.util.*;

public class P_成绩排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int sort = Integer.parseInt(scanner.nextLine());
        
        List<Score> scoreList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            scoreList.add(new Score(arr[0], Integer.parseInt(arr[1])));
        }

        Comparator<Score> comparator = (o1, o2) -> sort == 0 ? o1.getScore() - o2.getScore() : o2.getScore() - o1.getScore();
        scoreList.sort(comparator);

        scoreList.forEach(System.out::println);
    }


}

class Score {
    public Score(String name, Integer score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public String toString() {
        return String.format("%s %s", name, score);
    }

    private String name;
    private Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
