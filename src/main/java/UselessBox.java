import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class UselessBox implements Runnable {

    AtomicBoolean enabled = new AtomicBoolean();
    static final long SWITCHOFF_TIMER = 1000L;
    private boolean isActive = true;

    public void setActive(boolean active) {
        isActive = active;
    }

    public void turnOn() {
        if (!enabled.get()) {
            enabled.set(true);
            System.out.println("Пользователь включил коробочку");
        }

    }

    public void turnOff() {

        while (isActive) {

            if (enabled.get()) {

                try {
                    Thread.sleep(SWITCHOFF_TIMER);
                    enabled.set(false);
                    System.out.println("Коробочка выключилась");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        System.out.println("Конец игры");
    }



    public boolean getEnabled() {
        return enabled.get();
    }

    @Override
    public void run() {
        turnOff();
    }
}
