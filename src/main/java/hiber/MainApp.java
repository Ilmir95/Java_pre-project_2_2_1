package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User ilmir = new User("Ilmir", "Khafizov", "ilmir131313@yandex.ru");
        User elza = new User("Elza", "Zamaltdinova", "elza95@yandex.ru");
        User Timur = new User("Timur", "Pavlov", "TiPav@google.com");
        User Danil = new User("Danil", "Battalov", "danil-95@mail.ru");
        User Insaf = new User("Insaf", "Taziev", "insaf@tatar.ru");

        Car bmw = new Car("BMW", 5);
        Car audi = new Car("Audi", 3);
        Car nissan = new Car("Nissan", 4);
        Car lada = new Car("Lada", 14);
        Car geely = new Car("Geely", 3);
        userService.add(ilmir.setCar(bmw).setUser(ilmir));
        userService.add(elza.setCar(audi).setUser(elza));
        userService.add(Timur.setCar(nissan).setUser(Timur));
        userService.add(Danil.setCar(lada).setUser(Danil));
        userService.add(Insaf.setCar(geely).setUser(Insaf));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }
        System.out.println(userService.getUserToModelAndSeries("Nissan", 4));
        context.close();
    }
}
