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

      User user1 = new User("User3", "Lastname3", "user4@mail.ru");
      Car car1 = new Car("Audi",115322);
      user1.addCar(car1);
      userService.add(user1);
      User user2 = new User("User4", "Lastname4", "user4@mail.ru");
      Car car2 = new Car("Toyota",4123);
      user2.addCar(car2);
      userService.add(user2);

      System.out.println(userService.getUserByCar(4123));


      context.close();
   }
}
