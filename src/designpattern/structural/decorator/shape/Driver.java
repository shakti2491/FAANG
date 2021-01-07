package designpattern.structural.decorator.shape;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Driver
{
    public static void main(String[] args)
    {

        Circle circle = new Circle(10);
        System.out.println(circle.info());
        ColoredShape coloredShape = new ColoredShape(new Square(10),"blue");
        System.out.println(coloredShape.info());

        System.out.println(  new TransparentShape(new ColoredShape(new Circle(5),"green"),50).info()

        );

        compareVersion("1.2.3","1.2.3.0");
    }

    public static int compareVersion(String version1, String version2) {

        String[] nums1 = version1.split(".");
        String[] nums2 = version2.split(".");

        int n1 = nums1.length;
        int n2 = nums2.length;
        int i1,i2;
        for(int i =0; i<Math.max(n1,n2);i++){
            i1 = i<n1 ?Integer.parseInt(nums1[i]):0;
            i2 = i<n2 ?Integer.parseInt(nums2[i]):0;

            if(i1!=i2)
                return i1>i2?1:-1;
        }

        return 0;

    }
}
