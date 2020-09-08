

public class Test {
    private static Object object = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "currentTime : " + System.currentTimeMillis());
                    i++;
                    if (i == 10) {
                        synchronized (object) {
                            System.out.println("locked");
                        }
                    }
                }
            }
        });
        thread.start();
    }
}
