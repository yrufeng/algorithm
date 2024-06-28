package demo;

public class AlternatePrinting {
    private static int count = 1;

    public static void main(String[] args) {
        // 创建两个线程
        Thread thread1 = new Thread(() -> {
            while (count <= 10) {
                // 获取锁
                synchronized (AlternatePrinting.class) {
                    if (count % 2 == 1) {
                        System.out.println("线程 1: " + count);
                        count++;
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (count <= 10) {
                // 获取锁
                synchronized (AlternatePrinting.class) {
                    if (count % 2 == 0) {
                        System.out.println("线程 2: " + count);
                        count++;
                    }
                }
            }
        });

        // 启动线程
        thread1.start();
        thread2.start();
    }
}
