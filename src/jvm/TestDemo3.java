package jvm;

import java.util.ArrayList;
import java.util.List;

public class TestDemo3 {
    byte[] array = new byte[1 * 1024 * 1024];

    public static void main(String[] args) {
        List<TestDemo3> list = new ArrayList<TestDemo3>();
        int count = 0;

        try {
            while (true) {
            	// ��ͣ�� new ����,����ɻᴥ�� OOM ���������
                list.add(new TestDemo3());
                count++;
            }
        } catch (Error e) {
            System.out.println(count);
            e.printStackTrace();
        }
    }
}