package MethodReference;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MainMethodReference {
    public static void main(String[] args) {
        /*
        Java da metodların referanlarını birer değişkende tutmamız mümkündür. Yazdığımız ya da kütüphane de var olan
        metodlara istediğimiz değişkene depolayıp, çağırabildiğimiz bir özelliktir.
         */

       MathematicalOperation mathematicalOperation = MathematicalOperationImpl::add;
        System.out.println(mathematicalOperation.add(1,2));

        Consumer<String> println = System.out::println;
        println.accept("Test");

        Supplier<Double> random = Math::random;
        println.accept(String.valueOf(random.get()));

        Supplier<String> createString = MainMethodReference::createString;
        println.accept(createString.get());

        Function<Double, Long> round = Math::round;
        Long num = round.apply(1.7);
        println.accept(String.valueOf(num));

        BiFunction<Integer, Integer, Integer>  add = MathematicalOperationImpl::add;
        Integer addResult = add.apply(2,3);
        println.accept(String.valueOf(addResult ));

        List<BiFunction<Integer, Integer, Integer>> operations = Arrays.asList(
                MathematicalOperationImpl::add,
                MathematicalOperationImpl::multiply,
                MathematicalOperationImpl::extract
        );
        System.out.println("Please enter two number: ");
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();

        int finalResult = 0;
        for (BiFunction<Integer, Integer, Integer> operation : operations){
            Integer result = operation.apply(num1, num2);
            finalResult+=result;
        }
        println.accept(String.valueOf(finalResult));

    }
    //Methodların referanslarını tutma yöntemleri

    /*
    Consumer: Bir method statikse, sadece parametre alıp void dönüş yapmıyorsa consumer referansı ile gösterilebilir.
     */

    /*
    Supplier: Parametre almadan dönüş yapan metodlar için kullanılır.
     */

    /*
    Function Sınıfı: Bir parametre alıp dönüş yapan metodlar için kullanılır.
     */

    /*
   BiFunction Sınıfı: İki parametre alıp dönüş yapan metodlar için kullanılır.
     */

    public static String createString(){
        return "test";
    }

}
