package ood.dogdoor;

public class BarkRecognizerImpl implements BarkRecognizer
{
    private DogDoor dogDoor;

    public BarkRecognizerImpl(DogDoor door){
        this.dogDoor = door;
    }
    @Override public void recognize(String bark)
    {
        System.out.println("Dog barking");
        dogDoor.open();
    }
}
