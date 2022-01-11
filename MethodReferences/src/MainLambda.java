import MethodReference.MathematicalOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MainLambda {
    public static void main(String[] args) {
        /*
        Lambda expression:
            Kolay metod yazmanın bir yöntemi metod referanslar aracılığıyla kullanışlı oluyor.
         */
        MathematicalOperation mathematicalOperation = new MathematicalOperation() {
            @Override
            public int add(int num1, int num2) {
                return num1 + num2;
            }
        };
        System.out.println(mathematicalOperation.add(2, 4));

        MathematicalOperation mathematicalOperation1 = ((num1, num2) -> num1 + num2);
        //burada sanki bir sınıf yazmışım gibi lambda fonksiyon oluşturdum.
        // Tekrar bir sınıf oluşturup interface den implement almama gerek kalmadı.
        //Lambda oluşturduğum sınıfta tek bir metod olması gerekir.
        // Interfacede birden fazla  metod olursa lambda nın kafası karışabilir.

        System.out.println(mathematicalOperation1.add(4, 3));

        List<String> names = Arrays.asList("Tugba", "Eray");
        names.forEach(System.out::println);

        /*foreach le listi yazdırmak yerine kendi oluşturduğu forEach döngüsünü kullanarak consumer tipinde parametre alan
            foreach döngüsüne consumet tipinde olan System.out::println metoduyla yazdırdık.
         */

        //bunu lambda ile yapmak istersem consumer ın yapısına uygun bir şekilde fonksiyon yazabilirim.
        names.forEach((obj) -> System.out.println(obj));
        //consumer: parametre alan ama void olan tipti.


        //Lambda expression alan bir method örneği

        //Bu Filtreleme işlemlerini service katmanlarında kullanabilirim.

        List<String> nameList = Arrays.asList("Eray", "Caner", "Ceren");
        List<Integer> numList = Arrays.asList(3,4,5,6,7,8,10);
        System.out.println(nameList);
        System.out.println(numList);
        System.out.println("----");

        //isimleri filtreleme
        List<String> filteredNameList = filter(nameList, name->name.startsWith("C")); //! olursa Eray gelir.
        System.out.println(filteredNameList);

        //sayıları filtreleme
        List<Integer> filteredNumList = filter(numList, (number)->number>3);
        System.out.println(filteredNumList);

    }

    private static <T > List < T > filter(List < T > list, Function < T, Boolean > filterFunction) {
        List<T> filteredList = new ArrayList<>();
        for (T item : list) {
            if (filterFunction.apply(item)) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }
}
