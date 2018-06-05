package academy.learnprogramming;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //Create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //Get the NumberGenerator bean from the context
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        //get random number
        int number = numberGenerator.next();

        //log number
        log.info("number = {}", number);

        // get the Game bean from the context
        Game game = context.getBean(Game.class);

//        game.reset();

        //close context
        context.close();
    }

}
