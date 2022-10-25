This is a short and simple code example of a Gradle plugin that defines an extension object with a property.

I wrote this to illustrate a question:

**Is there a way to access an extension's properties during the configuration phase?**

### How to run this example

```shell
git clone https://github.com/Toldry/gradle_prop_configuration_phase_reproducer.git
cd gradle_prop_configuration_phase_reproducer/plugin
gradle publishToMavenLocal
cd src/test/resources/proj1
gradle greeting
```

The output:

```
> Task :greeting
hello2 and greetings1
```

2nd option:

```shell
gradle greeting -Pgreeting.message="hello3"
```

The output:
```
> Task :greeting
hello2 and salutations2

```

Please take a look at the code in these files to understand the output:
- `GreetingsPlugin.java`
- `GreetingsPluginExtension.java`
- `plugin/src/test/resources/proj1/build.gradle`


### What's happening here?

What I understand is happening is that during the configuration phase, the `greeting { }`
extension's properties are not yet accessible, so when `extension.getMessage().get()` is called,
it returns the value set in the convention method:
- in the 1st case it's the default value `'hello1'`
- in the second case because the `-Pgreeting.message` flag is set, it's the value `'hello3'`.

### The question, restated:
Is there a way to get the value defined in the `greeting { }` extension (the value `'hello2'` ) 
during the configuration phase? (i.e. inside the `apply` method in `GreetingsPlugin`, line 13)

