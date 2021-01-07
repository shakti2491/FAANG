package ood.dogdoor;

import java.util.*;

public class DogDoorSimulator
{
    public static void main(String[] args)
    {
        DogDoor dogDoor = new DogDoorImpl();
        Remote remote = new Remote(dogDoor);
        BarkRecognizer barkRecognizer = new BarkRecognizerImpl(dogDoor);

        System.out.println("Barking");
        barkRecognizer.recognize("woof");
        try
        {
            Thread.sleep(100);
        }catch (InterruptedException ex){}
        System.out.println("barking");
        barkRecognizer.recognize("woof");
        System.out.println("back inside");
    }
}
