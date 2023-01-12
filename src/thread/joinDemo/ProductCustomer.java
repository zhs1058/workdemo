package thread.joinDemo;
import java.util.ArrayList;
 
public class ProductCustomer {
    public static void main(String[] args) {
        // ����һ���ֿ���� �����  (һ������һ����)
        ArrayList<Bread> arrayList =new ArrayList<>();  // ֻ�ܴ洢Bread�����List���϶���
 
        // ���������߳�
        Thread t1 =new Thread(new Producer(arrayList));
        Thread t2 =new Thread(new Consumer(arrayList));
 
        // ����name
        t1.setName("�������߳�");
        t2.setName("�������߳�");
 
        // �����߳�
        t1.start();
        t2.start();
        // ��Ϊ�����̹߳���һ���ֿ����, ��synchronized�ؼ�������,��ôt1��t2�߳̾���Ҫ��������,����������ִ��,
        // ����t1������������,��ôt1�߳�run���ܳ���,��ʱt2���Ŷ�����,��t1�Ѷ������ͷź�t2�õ�����ʼִ��
 
    }
}
 
// �����߳�
class Producer implements Runnable{
    // �õ��ֿ����
    ArrayList<Bread> list;
    // ͨ�����췽���õ��ֿ����
    public Producer(ArrayList<Bread> list){
        this.list =list;
    }
 
    @Override
    public void run() {
        // һֱ����(��ѭ��)
        while (true){
            // synchronized : ��Ϊ�����̹߳���òֿ����,�������߳�������Ŀ���Ǳ�֤�̰߳�ȫ
            synchronized (list){    // ��ǰ����������ǰ������list�ֿ����
                if (list.size() > 9){    // ����0,˵���ֿ����Ѿ���һ��Ԫ���� �ֿ��Ѿ����˵������ѽ��̽�������
                    try {
                        list.wait();    // �ֿ����� �õ�ǰ�߳̽���ȴ�״̬,�����ͷŵ�list���϶������, ��Ϊһ�������һ����
                    } catch (InterruptedException e) {  // ���������߳�synchronized�Ѿ������������, ����Ҫ�����ͷŵ� �����̲߳����õ����ܳ���
                        e.printStackTrace();
                    }
                }
                // ������ִ�е����� ˵���ֿ�Ϊ��
                // ��ֿ������Ԫ��
                Bread bread =new Bread("���~");
                list.add(bread);
                System.out.println(Thread.currentThread().getName() +"������:" +bread.getName() + "---Ŀǰ��������" +list.size());
 
                // ������Ϻ� ���������߽�������
                list.notify();
 
                // ����ȫ��ִ����Ϻ�,�������߻��ͷŵ������� Ȼ�����¿�ʼ��������, �п����ͷź�������������߳�������
                // Ҳ�п����ͷŵ����������������˶�����, ����ʹ�������������˶����� �ֿ��Ѿ����� �����߻���ֻ���ͷŶ�����
                // ����ȴ�״̬   (ִ��Ч�ʵ�)
            }
        }
 
    }
}
 
// �����߳�
class Consumer implements Runnable{
    // �õ��ֿ����
    ArrayList<Bread> list;
    // ͨ�����췽���õ��ֿ����
    public Consumer(ArrayList<Bread> list){
        this.list =list;
    }
 
    @Override
    public void run() {
        // һֱ����
        while (true){
            synchronized (list){
                if (list.size() < 1){   // �ֿ⼯�ϵ���0 ˵���ֿ�Ϊ�� ����ȴ�״̬,ͬ�����߳�һ���Ѷ������ͷŵ�,������������
                    try {
                        list.wait();    // ����ȴ�״̬,�ͷŵ�������
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // ����ִ�е����� ˵���ֿ����� ��Ҫ��������
                Bread bread =list.remove(0);
                System.out.println(Thread.currentThread().getName() +"������:" +bread.getName() + "---Ŀǰ��������" +list.size());
 
                // ͬ�� ���Ѻ� ���������߳� ��ʼ�������
                list.notify();
            }
        }
 
    }
}


class Bread {
    private String name;
 
    public Bread(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    // ��дtoString����
    @Override
    public String toString() {
        return name;
    }
}
 
 