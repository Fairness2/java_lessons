import java.util.Arrays;

public class Thirteen {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        doTask();
    }

    private static void doTask(){
        float[] arr = new float[size];
        Arrays.fill(arr, 1F);
        doOneThread(arr);
        Arrays.fill(arr, 1F);
        doTwoThread(arr);
    }

    private static void doOneThread(float[] arr){
        long a = System.currentTimeMillis();
        processArray(arr);
        System.out.printf("Время вычислений в один поток: %s%n", System.currentTimeMillis() - a);
    }

    private static void processArray(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void doTwoThread(float[] arr){
        long a = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread th1 = new Thread(() -> {
            processArray(arr1);
            System.arraycopy(arr1, 0, arr, 0, h);

        });
        th1.start();
        Thread th2 = new Thread(() -> {
            processArray(arr2);
            System.arraycopy(arr2, 0, arr, h, h);
        });
        th2.start();

        try {
            th1.join();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        try {
            th2.join();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.printf("Время вычислений в два потока: %s%n", System.currentTimeMillis() - a);
    }
}
