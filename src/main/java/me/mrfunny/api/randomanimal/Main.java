package me.mrfunny.api.randomanimal;

public class Main {

    public static void main(String[] args) {
        try{
            System.out.println(RandomAnimal.getRandomAnimalImage(AnimalType.CAT));
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
