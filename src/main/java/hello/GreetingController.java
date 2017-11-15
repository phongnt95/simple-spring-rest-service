package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String index(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello, Welcome!!!";
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/counter")
    public long counter(@RequestParam(value="name", defaultValue="World") String name) {
        return counter.incrementAndGet();
    }

    @RequestMapping("/env")
    public String env(@RequestParam(value="name", defaultValue="World") String name) {
        return System.getenv().get("MyEnv");
    }
}
