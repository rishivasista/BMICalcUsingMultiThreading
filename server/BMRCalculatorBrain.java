package server;

public class BMRCalculatorBrain {
    int gender = 0;
    int weight = 0;
    int height =0;
    int age = 0;
    double result;
    BMRCalculatorBrain(int gender, int weight, int height, int age){
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    double getBMRForMale(){
        return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
    }

    double getBMRForFemale(){
        return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
    }
    String getResult(){
        if(gender==1){
            result = getBMRForMale();
            return "Your BMR is " + String.valueOf(result) + "\n\n";
        }
        else if(gender==2){
            result = getBMRForFemale();
            return "Your BMR is " + String.valueOf(result) + "\n\n";
        }
        else{
            System.out.println("Gender should be Male or Female");
            return "";
        }
    }
}
