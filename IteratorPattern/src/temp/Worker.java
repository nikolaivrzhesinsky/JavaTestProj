package temp;

import temp.Collection;

import java.util.ArrayList;

public class Worker implements Collection {

    private String name;

    private ArrayList<String> opportunities;

    public Worker(String name, ArrayList<String> opportunities) {
        this.name = name;
        this.opportunities = opportunities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(ArrayList<String> opportunities) {
        this.opportunities = opportunities;
    }

    @Override
    public Iterator getIterator() {
        return new WorkerIterator();
    }

    private class WorkerIterator implements Iterator{

        int index=0;
        @Override
        public boolean hasNext() {
            if(index<opportunities.size()){
                return  true;
            }
            return false;
        }

        @Override
        public Object next() {
            return opportunities.get(index++);
        }
    }
}
