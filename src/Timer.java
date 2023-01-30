public class Timer {
    private int seconds;

    public Timer(int hours, int minutes, int seconds) {

        if (hours < 0){
            throw new IllegalArgumentException("Hours must be positive");
        }
        if (minutes < 0){
            throw new IllegalArgumentException("Minutes must be positive");
        }
        if (seconds < 0){
            throw new IllegalArgumentException("Seconds must be positive");
        }
        if (seconds >59 && (hours != 0 || minutes != 0)){
            throw new IllegalArgumentException("Illegal configuration: "+ hours+":"+minutes+":"+seconds);
        }
        if (minutes >59 && hours != 0){
            throw new IllegalArgumentException("Illegal configuration: "+ hours+":"+minutes+":"+seconds);
        }

        this.seconds = seconds;
        this.seconds += minutes*60;
        this.seconds += hours*60*24;
    }

    @Override
    public String toString() {
        int secs;
        int mins;
        int hours;

        String mfill = "";
        String sfill = "";

        mins = (int)(seconds /60);
        secs = seconds %60;
        hours = (int)(mins/60);
        mins = mins%60;
        if (mins < 10){
            mfill = "0";
        }
        if (secs < 10){
            sfill = "0";
        }
        return hours + ":"+mfill+mins+":"+ sfill+secs;
    }
    public void tick(){
        if (seconds == 0){
            System.out.println("beep");
        }
        else{
            seconds--;
        }
    }
    public void add30Sec(){
        seconds +=30;
    }

    public static void main(String[] args) {
        Timer t = new Timer(0, 0, 3601);
        System.out.println(t);
        for (int i = 0; i < 3603; i++) {
            t.tick();
            System.out.println(t);
        }
        try {
            t = new Timer(0, 1, 90);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            t = new Timer(0, -11, 8);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }


}
