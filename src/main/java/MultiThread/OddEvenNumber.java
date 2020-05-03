package MultiThread;

public class OddEvenNumber {

    static class NumThread extends Thread implements Runnable {
        String name;
        Object other, self;
        int num, boundary;

        public NumThread(String name, int num, int boundary) {
            this.name = name;
            this.num = num;
            this.boundary = boundary;
        }

        public void setLock(Object other) {
            this.other = other;
        }

        public void setSelf(Object self) {
            this.self = self;
        }

        @Override
        public void run() {
            while (num < boundary) {
                synchronized (self) {
                    System.out.println(num);
                    num += 2;

                    synchronized (other) {
                        other.notify();
                    }
                    try {
                        if (num < boundary) {
                            self.wait();
                        } else {
                            self.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Object A = new Object();
        Object B = new Object();
        NumThread thread1 = new NumThread("A", 0, 101);
        NumThread thread2 = new NumThread("B", 1, 101);

        thread1.setLock(B);
        thread1.setSelf(A);

        thread2.setLock(A);
        thread2.setSelf(B);

        thread1.start();
        Thread.sleep(100);
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
