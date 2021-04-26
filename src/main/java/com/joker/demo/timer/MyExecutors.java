package com.joker.demo.timer;

import org.springframework.core.task.TaskExecutor;

import java.util.Random;
import java.util.concurrent.Executors;

public class MyExecutors {

    private class MyMessagePrint implements Runnable{

        private String message;

        public MyMessagePrint(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println("message = " + message);
        }
    }

    TaskExecutor taskExecutor;

    public MyExecutors(TaskExecutor taskExecutor){
        this.taskExecutor = taskExecutor;
    }

    public void printMessage(){
        taskExecutor.execute(new MyMessagePrint("message" + new Random().nextInt()));
    }

    public static void main(String[] args) {
        MyExecutors myExecutors = new MyExecutors(new TaskExecutor() {
            @Override
            public void execute(Runnable runnable) {
                runnable.run();
            }
        });
        myExecutors.printMessage();
    }



}

