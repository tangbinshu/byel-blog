package com.byelblog.entity;

import lombok.Data;

@Data
public class PageSet {
    private int begNum;
    private int fetchNum;

    public PageSet(int begNum, int fetchNum) {
    }
}
