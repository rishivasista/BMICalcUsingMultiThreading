package server;

public class BMICalculatorBrain {
    int height = 0;
    int weight = 0;

    BMICalculatorBrain(int height, int weight){
        this.height = height;
        this.weight = weight;
    }

    double convertToCM(int height){
        return height/100;
    }

    String getResult(){
        double result = weight/((height/100) * (height /100));
        return String.valueOf(result);
    }
}
