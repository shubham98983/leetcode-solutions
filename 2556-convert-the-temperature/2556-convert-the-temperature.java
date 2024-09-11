class Solution {
    public double[] convertTemperature(double celsius) {
        double[] ans = new double[2];
        double kelvin = celsius+273.15;
        double fah = (9/5.0*celsius)+32;
        ans[0]=kelvin;
        ans[1]=fah;
        return ans;
    }
}