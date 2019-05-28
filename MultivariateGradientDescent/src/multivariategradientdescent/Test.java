/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multivariategradientdescent;

/**
 *
 * @author 12nwoodruff
 */
public class Test {
    public static void main(String[] args) {
        // TODO code application logic here
        MultivariateGradientDescent mGD = new MultivariateGradientDescent(3);
        //b = 2, w1 = 2, w2 = 0, w3 = 5
        float[] x1 = new float[] {1, 2, 4};
        float[] x2 = new float[] {3, 2, 2};
        float[] x3 = new float[] {5, 4, 4};
        float[] x4 = new float[] {1, 4, 1};
        float[] y = new float[] {24, 18, 32, 9};
        float[][] xComposite = new float[][] {x1, x2, x3, x4};
        mGD.fit(xComposite, y, 10000, 1e-1f);
    }
}
