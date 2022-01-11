package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainStreamProcess {
    public static void main(String[] args) {
        /* Stream oluşturmak için List yada benzer sınıflar zorunlu değil
         * Direk Stream sınıfının özelliklerini kullanarak da stream oluşturup işlem yapabiliriz
         * empty
         * of
         * generate
         * iterate
         * range
         * rangeClosed
         */

        /*
         * - Intermediate operations
         *   filter()
         *   map()
         *   flatMap()
         *   distinct()
         *   sorted()
         *   peek()
         *   limit()
         *   skip()
         *
         * - Terminal Operations
         *   forEach()
         *   forEachOrdered()
         *   toArray()
         *   reduce()
         *   collect()
         *   min()
         *   max()
         *   count()
         *   anyMatch()
         *   allMatch()
         *   noneMatch()
         *   findFirst()
         *   findAny()
         *
         * Terminal operatorler stremleri sonlandıran işlemlerdir.
         * Intermediate operationlar streamleri kapatmaz.
         */

        Stream<String> stream = Stream.empty();
        Stream<String> stringStream = Stream.of("Tugba","Nur","Cakir");
        stringStream
                .filter(name->name.length()>4)
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("-----------");

         /*
        limit bir ara yani intermediate operasyon oldugu için terminal operasyonlarıyla işlemi tamamlamamız gerekir.
            örneğin.forEach() operasyonu.
            limit den sonra forEach() kullandık.
         */

        Stream<String> nameStream= Stream.generate(()-> "Ali").limit(10);
        nameStream.forEach(System.out::println);


        //iterate
        Stream.iterate(5,i->i+2).limit(4).forEach(System.out::println);

        /*primitive streams
        //primitive data tipleri için daha farklı özellikleri barındıran stream sınıflarıda mevcuttur.
        min max sum average
        */
        IntStream range = IntStream.range(1, 10);
        int sum = range.sum();
        System.out.println(sum);

        Stream.generate(()->1).limit(3).skip(1).forEach(System.out::println);

        System.out.println("---------");

        //Stream ler lazy initialization özelliğine sahiptir..
        //terminali olmayan streamler çalışmaz. bir streami terminal fonksiyonları ile bitirmek lazım.


        /*Streamlerde sonsuzlarla çalışma
            intermediate operasyonlar lazy dir. ardından terminal fonksiyonu verirsek infinite olur.
         */
        Stream<Integer> infiniteStream = Stream.iterate(0,i->i+1);
        infiniteStream.skip(1000).limit(10).forEach(System.out::println);

        //içerisinde c olan kelimeleri yazdır ve new line komutlarını kaldır.

        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla elementum metus ut dui placerat, at ultricies dui scelerisque. Aenean cursus nunc non lacus fermentum, sed consequat urna gravida. Duis a elementum ligula, non scelerisque urna. Fusce vel lectus pharetra, sollicitudin sapien vitae, vehicula neque. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sit amet diam rutrum, dapibus ligula ac, tincidunt dolor. Aenean elementum varius nunc, in porta tellus tempor vitae. Duis accumsan fringilla libero, non laoreet arcu. Nullam blandit dolor sit amet sapien facilisis scelerisque. Nam rhoncus, tortor eget faucibus bibendum, erat sapien ornare nisi, quis malesuada nunc ex vel magna. Suspendisse justo diam, luctus sit amet auctor sed, dignissim eget ipsum. Etiam vestibulum augue eu tortor dictum, ac rhoncus leo facilisis. In maximus dui sed interdum porta. Vestibulum ut orci quis arcu bibendum commodo.\n" +
                "\n" +
                "Ut ipsum nulla, scelerisque ut mollis id, rutrum at felis. Vestibulum tincidunt porttitor tortor ut pharetra. Sed consequat eros dui, vel bibendum mi maximus at. Maecenas convallis convallis felis. Etiam dictum libero nulla, semper faucibus massa facilisis in. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus eu nunc sit amet dolor pretium semper. Etiam ut facilisis metus. Curabitur commodo tortor auctor condimentum ultricies. Duis pulvinar purus quis pellentesque iaculis.\n" +
                "\n" +
                "Suspendisse non posuere lorem. Maecenas eu neque magna. Maecenas pulvinar lorem ac pharetra cursus. Suspendisse aliquam velit ut accumsan ultricies. Morbi semper urna lectus, non suscipit tellus imperdiet vel. Suspendisse quis tincidunt dolor, id accumsan nisi. Suspendisse vehicula elit.";


        text = text.replace("\n", " ");
        List<String> textArray = Arrays.asList(text.split(" "));
        List<String> filteredText = textArray.stream().filter(element->element.contains("c")).collect(Collectors.toList());
        filteredText.forEach(System.out::println);

    }

}
