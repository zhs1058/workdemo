package thread.joinDemo;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest{
    //���ھۺ����е�ͳ��ָ��
    private static Map map = new HashMap();
    //������������������Ҫͳ��4��ָ��
    private static CountDownLatch countDownLatch = new CountDownLatch(4);

    public static void main(String[] args) {
        //��¼��ʼʱ��
        long startTime = System.currentTimeMillis();
        Thread countUserThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("����ͳ�������û�����");
                    Thread.sleep(3000);//����ִ����Ҫ3��
                    // map.put("userNumber", 1);//������ֵ
                    countDownLatch.countDown();//����Ѿ����һ������
                    System.out.println("ͳ�������û��������");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread countOrderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("����ͳ�ƶ�������");
                    Thread.sleep(3000);//����ִ����Ҫ3��
                    map.put("countOrder", 2);//������ֵ
                    countDownLatch.countDown();//����Ѿ����һ������
                    System.out.println("ͳ�ƶ����������");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread countGoodsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("������Ʒ����");
                    Thread.sleep(3000);//����ִ����Ҫ3��
                    map.put("countGoods", 3);//������ֵ
                    countDownLatch.countDown();//����Ѿ����һ������
                    System.out.println("ͳ����Ʒ�������");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread countmoneyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("���������۶�");
                    Thread.sleep(3000);//����ִ����Ҫ3��
                    map.put("countmoney", 4);//������ֵ
                    countDownLatch.countDown();//����Ѿ����һ������
                    System.out.println("ͳ�����۶����");
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        //�������߳�ִ������
        countUserThread.start();
        countGoodsThread.start();
        countOrderThread.start();
        countmoneyThread.start();
        try {
            //���̵߳ȴ�����ͳ��ָ��ִ�����
            countDownLatch.await();
            //countDownLatch.await(1, TimeUnit.SECONDS);
            long endTime = System.currentTimeMillis();//��¼����ʱ��
            System.out.println("------ͳ��ָ��ȫ�����--------");
            System.out.println("ͳ�ƽ��Ϊ��" + map.toString());
            System.out.println("������ִ��ʱ��Ϊ" + (endTime - startTime) / 1000 + "��");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}