package com.erasmus.task3;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Object[] street = {new Human(), new Auto(), new Bus(),new Human(), new Integer(1)};
        check1(street);
        check2(street);
        check3(street);
    }

    private static void check1(Object[] objects){
        int v=0,a=0,b=0,h=0,u=0;
        for (Object object : objects) {
            if(object instanceof Human)
                h++;
            else if(object instanceof Auto)
                a++;
            else if(object instanceof Bus)
                b++;
            else if(object instanceof Vehicle)
                v++;
            else
                u++;
        }
        printResult("Instance of: ",v,a,b,h,u);
    }

    private static void check2(Object[] objects){
        int v=0,a=0,b=0,h=0,u=0;
        for (Object object : objects) {
            if(Human.class.isInstance(object))
                h++;
            else if(Auto.class.isInstance(object))
                a++;
            else if(Bus.class.isInstance(object))
                b++;
            else if(Vehicle.class.isInstance(object))
                v++;
            else
                u++;
        }
        printResult("Is instance: ",v,a,b,h,u);
    }

    private static void check3(Object[] objects){
        HashMap<String,Integer> result = new HashMap<>();
        for (Object object : objects) {
            String name = object.getClass().getSimpleName();
            if(!result.containsKey(name))
                result.put(name,1);
            else
                result.put(name,
                        result.get(name)+1);
        }
        System.out.println(result.toString());
    }

    private static void printResult(String str, int v, int a, int b, int h, int u){
        System.out.println(str);
        System.out.format("Vehicle: %d, Auto: %d, Bus: %d, Human: %d, Unknown: %d %n",v,a,b,h,u);
    }
}
