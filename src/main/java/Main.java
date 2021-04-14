public class Main {
    public static void main(String[] args) {

        UselessBox uselessBox = new UselessBox();
        User user = new User(uselessBox);

        Thread threadUselessBox = new Thread(null, uselessBox, "Коробочка");
        Thread threadUser = new Thread(null, user, "Пользователь");

        threadUselessBox.start();
        threadUser.start();

        try {
            threadUser.join();
            uselessBox.setActive(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
