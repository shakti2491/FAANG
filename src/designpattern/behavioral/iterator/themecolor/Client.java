package designpattern.behavioral.iterator.themecolor;

public class Client
{
    public static void main(String[] args)
    {
        IIterator<ThemeColor> itr = ThemeColor.getIterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
