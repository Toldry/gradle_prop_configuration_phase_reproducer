This is a short and simple code example of a Gradle plugin that defines an extension object a property.

I wrote this example in order to illustrate a question I have:

**Is there a way to access an extension's properties during the configuration phase?**

### How to run this example

```shell
git clone [url to this repo]
cd extension_example
gradle publishToMavenLocal
cd plugin/src/test/resources/proj1
gradle greeting
```

The output:

```
> Task :greeting
hello2 and greetings1

BUILD SUCCESSFUL in 402ms
1 actionable task: 1 executed
```

2nd option:

```shell
gradle greeting -Pgreeting.message="hello3"
```

The output:
```
> Task :greeting
hello2 and salutations2

BUILD SUCCESSFUL in 386ms
1 actionable task: 1 executed

```

### What's happening here?

Please take a moment to look at the code in `GreetingsPlugin.java` and `GreetingsPluginExtension.java`.

What I understand is happening is that during the configuration phase, the `greeting { }`
extension's properties are not yet accessible, so when `extension.getMessage().get()` is called,
it returns the value set in the convention method:
- in the 1st case it's the default value `'hello1'`
- in the second case because the `-Pgreeting.message` flag is set, it's the value `'hello3'`.

### The question, restated:
Is there a way to get the value defined in the `greeting { }` extension (the value `'hello2'` ) 
during the configuration phase? (i.e. inside the `apply` method in `GreetingsPlugin`, line 13)