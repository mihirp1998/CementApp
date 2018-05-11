package com.example.mihir.myapplication;

import android.icu.math.BigDecimal;

public class Matrix {
    private int len[] = {5,8,8,7,7,7,7};
    private float[][] inputMatrix;
    public Matrix( int row,int col)
    {
        inputMatrix = new float[row][col];
        for(int i =0;i<row;i++){
            for(int j = 0;j<col;j++){
                inputMatrix[i][j] = 0;
            }
        }
    }
    public void inputData(int a, int b, float data)
    {
        inputMatrix[a][b] = data;
    }
    public void initArr(float arr[][]){
        inputMatrix = arr;
    }

    public float computeSumAt(int a){
        float sum = 0 ;
        for(int i =0;i<len[a];i++){
            sum = sum + inputMatrix[i][a];
        }
//        inputMatrix[len[a]-1][a] = sum;
        return sum;
    }



//start

    public float clinkerProduction(){
        float ans =  (inputMatrix[0][0] * 24)/(float)1.6;
        return round(ans,4);
    }
    public float conPSum(){
        float sum = 0;
        for(int i =0 ;i<7;i++){
            System.out.println("val "+ inputMatrix[i][1]);
            sum = sum + inputMatrix[i][1];
        }
        return round(sum,4);

    }
    public static float round(float number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        float tmp = number * pow;
        return ( (float) ( (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) ) ) / pow;
    }
    public float pcSum(){
        float sum = 0;
        for(int i =7 ;i<10;i++){
            sum = sum + inputMatrix[i][0];
        }
        sum = sum + inputMatrix[5][0];
        return round(sum,4);
    }

    public float klinSum(){
        float sum = 0;
        for(int i =6 ;i<9;i++){
            sum = sum + inputMatrix[0][i];
        }
        sum = sum + inputMatrix[6][0];
        return round(sum,4);
    }



    public float consumptionAdbHcv(){
        float num = inputMatrix[3][0]+ inputMatrix[4][0] - (inputMatrix[3][0] * inputMatrix[5][0]/100) -(inputMatrix[4][0] * inputMatrix[6][0]/100);
        num = num - (inputMatrix[3][0]*inputMatrix[8][0]/100) - (inputMatrix[3][0]*inputMatrix[9][0]/100) - (inputMatrix[4][0]*inputMatrix[0][7]/100) - (inputMatrix[4][0]*inputMatrix[0][8]/100);
        //num = num - (inputMatrix[3][0]*inputMatrix[7][0]/100) -(inputMatrix[4][0]*inputMatrix[0][6]/100);
        float output = (num * 24 );
        return round(output,4);
        //     return output;
    }
    public float consumptionAdbMcv(){
        float num = inputMatrix[3][0]+ inputMatrix[4][0] - (inputMatrix[3][0] * inputMatrix[5][0]/100) -(inputMatrix[4][0] * inputMatrix[6][0]/100);
        num = num - (inputMatrix[3][0]*inputMatrix[9][0]/100) - - (inputMatrix[4][0]*inputMatrix[0][8]/100)- (inputMatrix[3][0]*inputMatrix[7][0]/100) -(inputMatrix[4][0]*inputMatrix[0][6]/100);
        float output = (num * 24 );
        return round(output,4);
    }
    public float consumptionAdbLcv(){
        float num = inputMatrix[3][0]+ inputMatrix[4][0] - (inputMatrix[3][0] * inputMatrix[5][0]/100) -(inputMatrix[4][0] * inputMatrix[6][0]/100);
        num = num - (inputMatrix[3][0]*inputMatrix[7][0]/100) -(inputMatrix[4][0]*inputMatrix[0][6]/100)-(inputMatrix[3][0]*inputMatrix[8][0]/100) -(inputMatrix[4][0]*inputMatrix[0][7]/100);;
        float output = (num * 24 );
        return round(output,4);
    }
    public float consumptionAdbPetCoke(){
        float num = (((inputMatrix[3][0]* inputMatrix[5][0])/100)+ (inputMatrix[4][0] * inputMatrix[6][0]/100))*24;
        return round(num,4);
    }


    public float consumptionAdbTyreChips(){
        float num = inputMatrix[1][0]* 24;
        return round(num,4);
    }
    public float consumptionAdbOtherAf(){
        return round(inputMatrix[2][0] * 24,4);
    }
    public float consumptionArbHcv(float consumptionAdbHcv){
        float val = (consumptionAdbHcv/(100 - inputMatrix[0][5]))*100;
        return round(val,4);
    }
    public float consumptionArbMcv(float consumptionAdbMcv){
        float val = (consumptionAdbMcv/(100 - inputMatrix[1][5]))*100;
        return round(val,4);
    }
    public float consumptionArbLcv(float consumptionAdbLcv){
        float val = (consumptionAdbLcv/(100 - inputMatrix[2][5]))*100;
        return round(val,4);
    }
    public float consumptionArbPetCoke(float consumptionAdbpetcoke){
        float val = (consumptionAdbpetcoke/(100 - inputMatrix[3][5]))*100;
        return round(val,4);
    }

    public float consumptionArbTyreChips(float consumptionAdbtyrechips){
        float val = (consumptionAdbtyrechips/(100 - inputMatrix[4][5]))*100;
        return val;
    }


    public float consumptionArbOtherAf(float consumptionAdbOtherAf){
        float val = (consumptionAdbOtherAf/(100 - inputMatrix[5][5]))*100;
        return val;
    }


    public float consumptionAdbPerHcv(float consumptionAdbHcv,float consumptionAdbSum){
        float val = (consumptionAdbHcv*100)/consumptionAdbSum;
        return val;
    }
    public float consumptionAdbPerMcv(float consumptionAdbMcv,float consumptionAdbSum){
        float val = (consumptionAdbMcv*100)/consumptionAdbSum;
        return val;
    }
    public float consumptionAdbPerLcv(float consumptionAdbLcv,float consumptionAdbSum){
        float val = (consumptionAdbLcv*100)/consumptionAdbSum;
        return val;
    }
    public float consumptionAdbPerPetCoke(float consumptionAdbPetCoke,float consumptionAdbSum){
        float val = (consumptionAdbPetCoke*100)/consumptionAdbSum;
        return val;
    }
    public float consumptionAdbPerTyreChips(float consumptionAdbTyreChips,float consumptionAdbSum){
        float val = (consumptionAdbTyreChips*100)/consumptionAdbSum;
        return val;
    }
    public float consumptionAdbPerOtherAf(float consumptionAdbOtherAf,float consumptionAdbSum){
        float val = (consumptionAdbOtherAf*100)/consumptionAdbSum;
        return val;
    }



    public float consumptionArbPerHcv(float consumptionArbHcv,float consumptionArbSum){
        float val = (consumptionArbHcv*100)/consumptionArbSum;
        return val;
    }
    public float consumptionArbPerMcv(float consumptionArbMcv,float consumptionArbSum){
        float val = (consumptionArbMcv*100)/consumptionArbSum;
        return val;
    }
    public float consumptionArbPerLcv(float consumptionArbLcv,float consumptionArbSum){
        float val = (consumptionArbLcv*100)/consumptionArbSum;
        return val;
    }
    public float consumptionArbPerPetCoke(float consumptionArbPetCoke,float consumptionArbSum){
        float val = (consumptionArbPetCoke*100)/consumptionArbSum;
        return val;
    }
    public float consumptionArbPerTyreChips(float consumptionArbTyreChips,float consumptionArbSum){
        float val = (consumptionArbTyreChips*100)/consumptionArbSum;
        return val;
    }
    public float consumptionArbPerOtherAf(float consumptionArbOtherAf,float consumptionArbSum){
        float val = (consumptionArbOtherAf*100)/consumptionArbSum;
        return val;
    }



    public float consumptionArbSum(float a, float b , float c , float d, float e ,float f){
        return a + b + c + d + e + f;
    }
    public float consumptionAdbSum(float a, float b , float c , float d, float e ,float f){
        return a + b + c + d + e + f;
    }




    public float fuelCostHcv(float consumptionArbHcv){
        float val = consumptionArbHcv * inputMatrix[0][3];
        return val;
    }


    public float fuelCostMcv(float consumptionArbMcv){
        float val = consumptionArbMcv * inputMatrix[1][3];
        return val;
    }
    public float fuelCostLcv(float consumptionArbLcv){
        float val = consumptionArbLcv * inputMatrix[2][3];
        return val;
    }


    public float fuelCostPetCoke(float consumptionArbPetCoke){
        float val = consumptionArbPetCoke * inputMatrix[3][3];
        return val;
    }

    public float fuelCostTyreChips(float consumptionArbTyreChips){
        float val = consumptionArbTyreChips * inputMatrix[4][3];
        return val;
    }

    public float fuelCostOtherAf(float consumptionArbOtherAf){
        float val = consumptionArbOtherAf * inputMatrix[5][3];
        return val;
    }
    //end
    public float fuelCostSum(float a, float b, float c, float d , float e, float f){
        float val =  a + b + c + d + e + f;
        return val;
    }

    public float rawMaterialCost(){
        float numSum = 0 ;
        for(int i = 0 ;i<7;i++){
            numSum = numSum + (inputMatrix[i][1] * inputMatrix[i][2]);
        }
        float denomSUm = 0;
        for(int i = 0;i<7;i++){
            denomSUm = denomSUm + inputMatrix[i][1];
        }
        return numSum/denomSUm;
    }

    public float rawMixCost(float rawMaterialCost){
        return (float)(rawMaterialCost * 1.52);
    }

    public float fuelCost(float fuelCostSum,float clinkerProduction){
        return fuelCostSum/clinkerProduction;
    }

    public float  clinkerCost(float a , float b){
        return a + b;
    }

    public float specificHeat(float[] arr,float clinkerProduction){
        float numSum = 0 ;

        for(int i = 0 ;i<4;i++){
            numSum = numSum + (arr[i] * inputMatrix[6][4]);
        }
        for(int i = 4 ;i<6;i++){
            numSum = numSum + (arr[i] * inputMatrix[i][4]);
        }
        float denomSUm = clinkerProduction ;

        return numSum/denomSUm;
    }



    public float[][] getInputMatrix(){
        return inputMatrix;
    }

}