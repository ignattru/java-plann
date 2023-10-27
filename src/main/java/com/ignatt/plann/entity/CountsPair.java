package com.ignatt.plann.entity;

public class CountsPair {
    private int subtaskCnt;
    private int doneSubtaskCnt;

    public CountsPair(int subtaskCnt, int doneSubtaskCnt) {
        this.subtaskCnt = subtaskCnt;
        this.doneSubtaskCnt = doneSubtaskCnt;
    }

    public int getSubtaskCnt() {
        return subtaskCnt;
    }

    public int getDoneSubtaskCnt() {
        return doneSubtaskCnt;
    }

    @Override
    public String toString() {
        return "Subtask count: " + subtaskCnt + ", Done subtask count: " + doneSubtaskCnt;
    }
}
