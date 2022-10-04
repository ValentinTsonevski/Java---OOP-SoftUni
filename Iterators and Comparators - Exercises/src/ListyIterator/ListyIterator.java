package ListyIterator;

import java.util.List;

public class ListyIterator {
    private List<String> elements;
    private int currentIndex;

    public ListyIterator(String... elements) {
        this.elements = List.of(elements);
        currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < this.elements.size() - 1;
    }

    public boolean move() {
       if(hasNext()){
         currentIndex++;
         return true;
       }
       return false;
    }

    public void print(){
        if(this.elements.isEmpty()){
            throw  new IllegalStateException("Invalid Operation.");

        }
        System.out.println(this.elements.get(currentIndex));
    }


}
