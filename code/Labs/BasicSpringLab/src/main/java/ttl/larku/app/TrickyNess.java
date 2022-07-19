package ttl.larku.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

interface Trick {
    public void doTrick();
}

@Component
@Primary
//@Profile("dev")
class Trick1 implements Trick {
    @Override
    public void doTrick() {
        System.out.println("HandStand");
    }
}

@Component
//@Profile("prod")
class Trick2 implements Trick {
    @Override
    public void doTrick() {
        System.out.println("CartWheel");
    }
}

@Component
class Circus {
//    @Autowired
//    @Qualifier("trick2")
//    private Trick trick;

    @Autowired
    private List<Trick> tricks;

    public void startShow() {
//        trick.doTrick();
        tricks.forEach(Trick::doTrick);
    }

    public static void main(String args[]) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().addActiveProfile("prod");
        context.scan("ttl.larku.app");
        context.refresh();

        Circus circus = context.getBean("circus", Circus.class);
        circus.startShow();
    }
}