package sem1_2.model;

public class StackContainer extends AbstractContainer {
    
    @Override
    public Task remove() {
        //LIFO-se elimina ultimul task adaugat
        if(!tasks.isEmpty()){
            return tasks.remove(tasks.size()-1);
        } else return null;
    }
}
