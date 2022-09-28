package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> data;

    public CustomList() {
        this.data = new ArrayList();
    }

    public void add(T element){
      data.add(element);
    }

    public void remove(int index){
       data.remove(index);
    }

    public boolean contains(T element){
        for (T el : data) {
            if(el.equals(element)){
                return true;
            }
        }
        return false;
    }

    public void swap(int index1,int index2){
        Collections.swap(data,index1,index2);
    }

    public long countGreaterThan(T element){
        return data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax(){
       return data.stream().max(Comparator.naturalOrder()).get();
    }

    public T getMin(){
        return data.stream().min(Comparator.naturalOrder()).get();
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();

        for (T element : data) {
            sb.append(String.format("%s%n",element.toString()));
        }

        return sb.toString().trim();
    }
}
