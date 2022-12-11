package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private Long id;
   @Column(name = "model")
   private String model;

   public User getUser() {
      return user;
   }

   @Override
   public String toString() {
      return "Car{" +
              "id=" + id +
              ", model='" + model + '\'' +
              ", series=" + series +
              '}';
   }

   public User setUser(User user) {
      this.user = user;
      return user;
   }

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "user_id")
   private User user;

   public String getModel() {
      return model;
   }

   public Car(String model, int series) {
     // this.id = id;
      this.model = model;
      this.series = series;
   }

   public Car() {
   }

   public void setModel(String model) {
      this.model = model;
   }

   public int getSeries() {
      return series;
   }

   public void setSeries(int series) {
      this.series = series;
   }

   @Column(name = "series")
   private int series;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
}
