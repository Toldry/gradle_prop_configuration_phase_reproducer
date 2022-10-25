package extension_example;

import org.gradle.api.Project;
import org.gradle.api.Plugin;


public class GreetingsPlugin implements Plugin<Project> {
    public void apply(Project project) {
        GreetingPluginExtension extension = project.getExtensions().create("greeting", GreetingPluginExtension.class);
        final String secondMessagePart;

        // Access the property value at configuration phase
        if(extension.getMessage().get().equals("hello1")) {
            secondMessagePart = " and greetings1";
        } else {
            secondMessagePart = " and salutations2";
        }

        project.getTasks().register("greeting", task -> {
            task.doLast(t -> {
                // Access the property value at execution phase
                String message = extension.getMessage().get();
                project.getLogger().info(message + secondMessagePart);
                System.out.println(message + secondMessagePart);
            });
        });
    }
}







