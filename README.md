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
    <artifactId>RandomImageAPI</artifactId>
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
RandomImage.getRandomAnimalImage(AnimalType type);
//this may return url of random image as String
```
for example

```java
RandomImage.getRandomAnimalImage(AnimalType.CAT);
```
returns url as String of random cat image

if you want to get random image from custom request, you can use
```java
RandomImage.getRandomImageFromUserRequest(String searchData);
```
returns random image from your request

```java
// AnimalType
FOX, DOG, CAT
```
