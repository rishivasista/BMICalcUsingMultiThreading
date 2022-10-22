package server;

public class BMRCalculatorBrain {
    String gender = "";
    int weight = 0;
    int height =0;
    int age = 0;
    double result;
    BMRCalculatorBrain(String gender, int weight, int height, int age){
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
        if(gender.toLowerCase().equals("male")){
            result = getBMRForMale();
            return String.valueOf(result);
        }
        else if(gender.toLowerCase().equals("female")){
            result = getBMRForFemale();
            return String.valueOf(result);
        }
        else{
            System.out.println("Gender should be Male or Female");
            return "";
        }
    }
}
