public class User implements Runnable {

    UselessBox uselessBox;

    static final int TIMES_TO_PLAY = 5;
    static final long TURNON_TIMER = 4000L;

    public User(UselessBox uselessBox) {
        this.uselessBox = uselessBox;
    }

    public void turnOn() {

        for (int i = 0; i < TIMES_TO_PLAY; i++) {
            try {
                Thread.sleep(TURNON_TIMER);
                if (!uselessBox.getEnabled()) {
                    uselessBox.turnOn();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        turnOn();
    }
}
