package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainStream {
    public static void main(String[] args) {
        /*
         Stream:
         Streamlar collection interface ini implemente eden sınıflara gelen bir özelliktir.
         Streamlar collection elementlerinin içinde dolaşma yöntemimizi değiştirir.

         */

        //normalde dizideki elemanları toplasam

        List<Integer> numberList = Arrays.asList(1,5,4,3,7,2,3,5,6);
        int result = 0;
        for(Integer num: numberList){
            result+=num;
        }
        System.out.println("ResultNormal: "+result);

        //Stream ile dizideki elemanları toplamak istersem

        int resultStream = numberList.stream().mapToInt(num->num).sum();
        //mapToInt() primitive tipe dönüştürüyor kullanılacak elemanları

        System.out.println("Result Stream: "+resultStream);

        //Stream ile dizideki elemanları filtreleme

        List<Integer> numbers= Arrays.asList(1,5,4,3,7,2,3,5,6);
        List<Integer> filteredNumbers = numberList.stream().filter(num->num>3).collect(Collectors.toList());
        //.collect(Collectors.toList()) bu bana filtrelenmiş yeni bir dizi dönderir
        System.out.println(filteredNumbers);

        //Stream ile unique olmayan değerleri kaldıralım
        List<Integer> numbers1 =  Arrays.asList(2,4,5,6,1,2,4,5,0,3,0);
        System.out.println(numbers1);
        List<Integer> filteredNumbers1 = numbers1.stream().distinct().collect(Collectors.toList());
        filteredNumbers1.forEach(System.out::println);

    }
}
