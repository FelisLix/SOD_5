package sod5;


import lombok.Setter;

import java.util.LinkedList;

public class Bucket {
    @Setter
    private LinkedList<String> data;



    public void add(String value){

        if (data == null) {
            data = new LinkedList<>();
        }

        this.data.add(value);
    }

    public String findElement(String value){
        if (data != null) {
            for (String element : data) {
                if (element.equals(value)) {
                    return element;
                }
            }
        }
        return ":(";
    }


    public int findIndex(String value) {
        if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                String element = data.get(i);
                if (element.equals(value)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void remove(String value) {
        if (data != null) {
            int index = findIndex(value);
            if (index == -1) {
                System.out.println(":(");
            }
            data.remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            res.append(i);
            res.append(" ");
            res.append(data.get(i));
            res.append(" ");
        }
        return res.toString();
    }
}
