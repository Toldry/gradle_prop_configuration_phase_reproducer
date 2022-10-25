//package extension_example;
//
//import org.gradle.api.DefaultTask;
//import org.gradle.api.provider.Property;
//import org.gradle.api.tasks.Input;
//import org.gradle.api.tasks.TaskAction;
//
//abstract public class GreetingTask extends DefaultTask {
//    @Input
//    abstract public Property<String> getMessage();
//
//    @TaskAction
//    public void greet() {
//        System.out.println(getMessage().get());
//    }
//}
