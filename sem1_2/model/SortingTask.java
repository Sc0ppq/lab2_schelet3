package sem1_2.model;

public class SortingTask extends Task {
    private int[] numbers;
    private AbstractSorter sorter; //strategia de sortare

    //constructorul care primeste id-ul, descrierea, vectorul de numere si strategia
    public SortingTask(String id, String description, int[] numbers, AbstractSorter sorter) {
        super(id, description); //apelam constructorul din Task
        this.numbers = numbers;
        this.sorter = sorter;
    }

    //afisam vectorul sortat folosind strategia aleasa
    public void execute() {
        System.out.println("Inainte de sortare:");
        printArray(numbers);
        sorter.sort(numbers);
        System.out.println("Dupa sortare::");
        printArray(numbers);
    }

    //metoda privata pt a afisa un vector de numere
    private void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}


//SORTARI

//defineste metoda de sortare
abstract class AbstractSorter {
    public abstract void sort(int[] array);
}

//implementare BUBBLE SORT
class BubbleSorter extends AbstractSorter {
    @Override
    public void sort(int[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] > array[j+1]) {
                    //schimam elementele
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
}

//implementare QUICK SORT
class QuickSorter extends AbstractSorter {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array,low,high);
            quickSort(array,low,pivotIndex-1);
            quickSort(array,pivotIndex+1,high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low-1);
        for (int j = low; j < high; j++) {
            if(array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }
}
