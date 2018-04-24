package ru.omsu.imit.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListDemo {
    public static int countChars(List<String> strings, char c){
        int res = 0;
        for(String str: strings){
            if(str.charAt(0) == c){
                res++;
            }
        }
        return res;
    }

    public static List<Human> getNamesakes(List<Human> humans, Human man){
        ArrayList<Human> result = new ArrayList<Human>();
        for(Human m: humans){
            if(m.getSurname().equals(man.getSurname())) result.add(m);
        }
        return result;
    }

    public static List<Human> removeHuman(List<Human> humans, Human man){
        ArrayList<Human> res = new ArrayList<Human>(humans);
        for(int i = 0; i < res.size(); i++){
            if(man.equals(res.get(i)))res.remove(i);
        }
        return res;
    }

    public static List<Set<Integer>> removeIntersects(List<Set<Integer>> sets, Set<Integer> temp){
        boolean flag = false;
        ArrayList<Set<Integer>> res = new ArrayList<Set<Integer>>();
        for(Set<Integer> set: sets){
            for(Integer i: temp){
                if(set.contains(i)){
                    flag = true;
                    break;
                }
            }

            if(flag){
                res.add(set);
                flag = false;
            }
        }
        return res;
    }
//TODO no 5
}
