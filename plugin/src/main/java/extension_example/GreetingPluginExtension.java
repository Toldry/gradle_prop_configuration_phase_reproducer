package extension_example;

import org.gradle.api.Project;
import org.gradle.api.provider.Property;

import javax.inject.Inject;

abstract class GreetingPluginExtension {
    abstract Property<String> getMessage();

    @Inject
    public GreetingPluginExtension(Project project) {
        getMessage().convention(project.getProviders().gradleProperty("greeting.message").orElse("hello1"));
    }
}