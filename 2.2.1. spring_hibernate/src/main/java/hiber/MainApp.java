package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.hibernate.Cache;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("ВАЗ", 2114);
      Car car2 = new Car("ВАЗ", 2115);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      User u1 = new User("User1", "Lastname1", "user1@mail.ru");
      User u2 = new User("User2", "Lastname2", "user2@mail.ru");
      User u3 = new User("User3", "Lastname3", "user3@mail.ru");
      User u4 = new User("User4", "Lastname4", "user4@mail.ru");
//      u1.setCar(car1);
//      u2.setCar(car1);


      userService.add(u1.setCar(car1).setUser(u1));
      userService.add(u2.setCar(car2).setUser(u2));
      userService.add(u3);
      userService.add(u4);


//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
      int i = 1;
      for (User u : userService.listUsers()) {
         System.out.println(i++ + ") " + u + " " + u.getCar());
      }
      System.out.println("------------------------------------------------------------------------------------");
      try {
         System.out.println(userService.ownerCarByModelAndSeries("ВАЗw", 2114));
      } catch (NoResultException e) {
         System.out.println("Данного пользователя не существует");
      }

      context.close();
   }
}
