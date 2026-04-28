package com.nb.estudo.config;

import com.nb.estudo.entities.Category;
import com.nb.estudo.entities.Order;
import com.nb.estudo.entities.Product;
import com.nb.estudo.entities.User;
import com.nb.estudo.entities.enums.OrderStatus;
import com.nb.estudo.repositories.CategoryRepository;
import com.nb.estudo.repositories.OrderRepository;
import com.nb.estudo.repositories.ProductRepository;
import com.nb.estudo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {
        Category cat1=new Category(null,"Eletronics");
        Category cat2=new Category(null,"Books");
        Category cat3=new Category(null,"Computers");

        Product p1= new Product(null,"The Lord..........","Lorem ipsum",90.5,"");
        Product p2= new Product(null,"Smart Tv","Ndf dsf sasdsadsad",2190.0,"");
        Product p3= new Product(null,"Macbook Pro","Nam sadas dasd",1250.0,"");
        Product p4= new Product(null,"PC Gamer","Donec aliquet",1200.0,"");
        Product p5= new Product(null,"Rails for Dummies","Cras fringila",100.99,"");

        User u1=new User(null,"Maria Brown","maria@gmail.com","988888888","123456");
        User u2=new User(null,"Alex Green","alex@gmail.com","977777777","123456");

        Order o1=new Order(null, Instant.parse("2019-06-20T19:53:07z"), OrderStatus.PAID,u1);
        Order o2=new Order(null, Instant.parse("2019-07-21T03:42:07z"),OrderStatus.WAITING_PAYMENT,u2);
        Order o3=new Order(null, Instant.parse("2019-07-22T15:21:07z"),OrderStatus.WAITING_PAYMENT,u1);

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
