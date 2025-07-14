package com.example.evwheeler;

import java.io.IOException;

public class FindEv {
    int[] Calcprice(int[] indexList,int orp, double mileage, int commute) throws IOException {
        float[] orpev = {139999, 147499, 119000, 94878, 105057, 115235, 150674, 180000, 155553, 154337, 161861, 146074, 161074, 136440, 158921, 133960, 155219, 82098, 71500, 84648, 82098, 150000, 140386, 132225, 79625, 106119, 79216, 106680, 100600};
        double[] upk = {0.022099448, 0.020512821, 0.029801325, 0.021052632, 0.01986755, 0.01986755, 0.03, 0.03, 0.020689655, 0.026126126, 0.033333333, 0.026086957, 0.026086957, 0.042222222, 0.042222222, 0.035454545, 0.011538462, 0.004166667, 0.003333333, 0.004166667, 0.004166667, 0.022167488, 0.0075, 0.017142857, 0.003333333, 0.015, 0.003571429, 0.015, 0.01};

        int[] finalList = new int[indexList.length];
        for (int i = 0; i < indexList.length; i++) {
            float ice = orp;
            float ev = orpev[i];
            float ticecost = 0, tevcost = 0;
            for (int n = 1; n > 0; n++) {
                ticecost = (float) ((1 / mileage) * 30 * commute * 96.36);
                ice = ice + (ticecost * n);
                tevcost = (float) (commute * upk[i] * 7 * 30);
                ev = ev + (tevcost * n);
                if (ice > ev){
                    finalList[i] = n;
                    break;
                }
            }
        }
        return finalList;
    }

    static int[] CheckRange(int commute) {
        int[] ranges = {181, 195, 151, 95, 151, 151, 100, 100, 145, 111, 111, 115, 115, 90, 90, 110, 130, 60, 75, 60, 60, 203, 160, 70, 75, 80, 70, 80, 80};
        int[] arr = new int[10];
        int n=0;
        for (int i=0;i<ranges.length;i++) {
            if(n < 10 && ranges[i] < commute * 4 + 10) {
                arr[n] = i;
                n++;
            }
        }
        return arr;
    }
}
