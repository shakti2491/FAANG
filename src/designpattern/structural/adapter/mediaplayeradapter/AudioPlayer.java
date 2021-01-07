package designpattern.structural.adapter.mediaplayeradapter;

public class AudioPlayer implements MediaPlayer
{
    MediaAdapter mediaAdapter;
    @Override public void play(String audioType, String fileName)
    {
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: " + fileName);
        }
        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
    }



}
