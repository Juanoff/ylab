package ru.ylab;

import ru.ylab.app.App;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        App.createInstance();
        App.getInstance().menu();
    }
}