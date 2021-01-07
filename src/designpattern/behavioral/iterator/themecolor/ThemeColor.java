package designpattern.behavioral.iterator.themecolor;


public enum  ThemeColor
{
    RED,ORANGE,BLACK,WHITE;

    public static IIterator<ThemeColor> getIterator() {
        return new ThemeColorIterator();
    }

    private static class ThemeColorIterator implements IIterator<ThemeColor> {
        private int position;

        @Override public boolean hasNext()
        {
            return position <ThemeColor.values().length;
        }

        @Override public ThemeColor next()
        {
            return ThemeColor.values()[position++];
        }
    }
}
