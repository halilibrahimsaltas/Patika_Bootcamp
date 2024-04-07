import java.util.TreeSet;

public class Main  {

    public static void main(String[] args) {
        BookComparator t1 = new BookComparator();
        BookComparatorName t2 = new BookComparatorName();

        TreeSet<Book> books = new TreeSet<>(t1);
        TreeSet<Book> booksN = new TreeSet<>(t2);

        Book yaban = new Book("Yaban",198,"Yakup Kadri Karaosmanoğlu",1932);
        Book hur = new Book("Hür Şehrin İnsanları",752,"Kemal Tahir",1976);
        Book esir = new Book("Esir Şehrin İnsanları",437,"Yakup Kadri Karaosmanoğlu",1956);
        Book dune = new Book("Dune",692,"Frank Herbert",1965);
        Book celik1 = new Book("Tüfek, Mikrop ve Çelik",664,"Jared Diamond",1997);

        books.add(yaban);
        books.add(hur);
        books.add(esir);
        books.add(dune);
        books.add(celik1);
        booksN.add(yaban);
        booksN.add(hur);
        booksN.add(esir);
        booksN.add(dune);
        booksN.add(celik1);

        System.out.println("Alphabetical sorting");
        System.out.println("-----------------------");
        for (Book j : booksN){
            System.out.println(j.getName());
        }
        System.out.println("By number of pages");
        System.out.println("-----------------------");
        for(Book i : books){
            System.out.println(i.getName());
        }

    }
}