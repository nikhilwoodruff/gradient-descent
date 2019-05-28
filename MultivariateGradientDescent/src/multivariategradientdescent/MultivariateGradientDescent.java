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
public class MultivariateGradientDescent {
    float[] weights;
    /**
     * @param args the command line arguments
     */
    public MultivariateGradientDescent(int size)
    {
        weights = new float[size + 1];
        for(int i = 0; i < size + 1; i++)
        {
            weights[i] = 2 * ((float) Math.random() - 0.5f);
        }
    }
    void fit(float[][] x, float[] y, int numEpochs, float learningRate)
    {
        float[][] xWithBias = new float[x.length][x[0].length + 1];
        for(int i = 0; i < x.length; i++)
        {
            xWithBias[i][0] = 1;
            for(int j = 0; j < x[0].length; j++)
            {
                xWithBias[i][j + 1] = x[i][j];
            }
        }
        for(int k = 0; k < numEpochs; k++)
        {
            x = xWithBias;
            for(int i = 0; i < weights.length; i++)
            {
                float sumOfPairs = 0;
                for(int j = 0; j < weights.length; j++)
                {
                    sumOfPairs += weights[j] * getSumOfPairs(extractSeries(x, i), extractSeries(x, j));
                }
                float sumOfYPair = getSumOfPairs(extractSeries(x, i), y);
                float combinedPairs = sumOfPairs - sumOfYPair;
                float meanFactor = 2;
                meanFactor /= x.length;
                float gradient = meanFactor * combinedPairs;
                float deltaWeight = learningRate * -gradient;
                weights[i] += deltaWeight;
            }
            printWeights(false);
        }
    }
    void printWeights(boolean round)
    {
        for(int i = 0; i < weights.length; i++)
        {
            float weight = weights[i];
            if(round)
            {
                weight = (float) Math.round(weight);
            }
            System.out.println("W" + i + ": " + weight);
        }
    }
    float[] extractSeries(float[][] superSeries, int index)
    {
        float[] subSeries = new float[superSeries.length];
        for(int i = 0; i < superSeries.length; i++)
        {
            subSeries[i] = superSeries[i][index];
        }
        return subSeries;
    }
    float getSumOfSeries(float[] series)
    {
        float sum = 0;
        for(int i = 0; i < series.length; i++)
        {
            sum += series[i];
        }
        return sum;
    }
    float getSumOfPairs(float[] series1, float[] series2)
    {
        float sum = 0;
        for(int i = 0; i < series1.length; i++)
        {
            sum += series1[i] * series2[i];
        }
        return sum;
    }
    
}
