package pekan7;

public class TugasSorting {

    void sort(String a[]) {
    	int start = a.length - 6;
    	
    	 for (int i = start + 1; i < a.length; ++i) {
            String k = a[i];
            int j = i - 1;

            while (j >= 0 && a[j].compareTo(k) > 0) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = k;
        }
    }

    public static void main(String args[]) {
        String a[] = { "z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b", "a"};

        TugasSorting ob = new TugasSorting();
        ob.sort(a);

        for (String value : a)
            System.out.print(value + " ");
    }
}
