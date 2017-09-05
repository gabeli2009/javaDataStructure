package com.data.j2novice.squeue.blockqueue;

import java.util.Random;  
import java.util.concurrent.BlockingQueue;  
import java.util.concurrent.LinkedBlockingQueue;  
  
public class TestBlockingQueue {  
  
    public static void main(String[] args) {  
        final BlockingQueue<Integer> queue=new LinkedBlockingQueue<Integer>(3);  
        final Random random=new Random();  
          
        class Producer implements Runnable{  
            @Override  
            public void run() {  
                while(true){  
                    try {  
                        int i=random.nextInt(100);  
                        System.out.println("put   "+i);  
                        queue.put(i);//�����дﵽ����ʱ�򣬻��Զ�������  
                        if(queue.size()==3)  
                        {  
                            System.out.println("full");  
                        }  
                        System.out.println("put ok "+i);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
          
        class Consumer implements Runnable{  
            @Override  
            public void run() {  
                while(true){  
                    try {  
                       int _ii = queue.take();//������Ϊ��ʱ��Ҳ���Զ�����  
                        Thread.sleep(3000);  
                        System.out.println("take "+_ii);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
          
        new Thread(new Producer()).start();  
        new Thread(new Consumer()).start();  
    }  
  
}  