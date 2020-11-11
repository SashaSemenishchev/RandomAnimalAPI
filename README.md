# RandomAnimalAPI

Maven
```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>

<dependency>
	<groupId>com.github.SashaSemenishchev</groupId>
    <artifactId>RandomAnimalAPI</artifactId>
    <version>1.0</version>
</dependency>
```

And gradle

```
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
dependencies {
	implementation 'com.github.SashaSemenishchev:RandomAnimalAPI:1.0'
}
```


how to use this api

```java
RandomAnimal.getRandomAnimalImage(AnimalType type);
//this may return url of random image as String
```
for example

```java
RandomAnimal.getRandomAnimalImage(AnimalType.CAT);
```
returns url as String of random cat image

```java
// AnimalType
FOX, DOG, CAT
```
