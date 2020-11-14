# RandomAnimalAPI

Maven
```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>

[![](https://jitpack.io/v/SashaSemenishchev/RandomImageAPI.svg)](https://jitpack.io/#SashaSemenishchev/RandomImageAPI)

<dependency>
    <groupId>com.github.SashaSemenishchev</groupId>
    <artifactId>RandomImageAPI</artifactId>
    <version>VERSION</version>
</dependency>
```

or gradle

```
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
dependencies {
	implementation 'com.github.SashaSemenishchev:RandomAnimalAPI:VERSION'
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
