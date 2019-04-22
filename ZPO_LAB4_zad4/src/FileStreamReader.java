import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileStreamReader {

    public FileStreamReader() {
        Stream<String> stringStream1 = null;
        Stream<String> stringStream2 = null;
        try {
            stringStream1 = Files.lines(Paths.get("dane.txt"));
            stringStream2 = Files.lines(Paths.get("dane.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> plsalaries = stringStream1
        .filter(s -> s.contains("PL"))
        .map(s -> new Person(s).getSalary())
        .sorted(Integer::compareTo)
        //.peek(System.out::println)
        .collect(Collectors.toList());

        System.out.println("-prawidłowy wynik :"
                + (plsalaries.get(plsalaries.size()-1)+plsalaries.get(plsalaries.size()-2))
                + " i "
                + (plsalaries.get(0)+plsalaries.get(1))
        );

//        solution 1
//        System.out.println("-------------\n");
//
//        List<String> personCountriesList = stringStream2.map(
//                s -> new Person(s).getCountry()).collect(Collectors.toList());
//        Set<String> personCountriesSet = new HashSet<>(personCountriesList);
//        for(String s : personCountriesSet)
//            System.out.println(s + "-" + Collections.frequency(personCountriesList, s));

//        solution 2
//        System.out.println("-------------\n");
//
//        List<String> personCountriesTmpList = stringStream2.map(
//                s -> new Person(s).getCountry()).collect(Collectors.toList());
//        System.out.println(personCountriesTmpList);
//        Set<String> personCountriesSet = new HashSet<>();
//        for(String s : personCountriesTmpList) {
//            //System.out.println(s + "-" + Collections.frequency(personCountriesSet, s));
//            personCountriesSet.add( s + "-" + Collections.frequency(personCountriesTmpList, s) + ", ");
//        }
//        System.out.println(personCountriesSet);

//        solution 3 map
        List<String> personCountriesTmpList = stringStream2.map(
                s -> new Person(s).getCountry()).collect(Collectors.toList());

        //System.out.println(personCountriesTmpList);
        Map<String, Integer>countriesMap = new LinkedHashMap<>();
        for (String seq : personCountriesTmpList) {
            Integer count = countriesMap.get(seq);
            countriesMap.put(seq, count == null ? 1 : count + 1);
        }
        System.out.println(countriesMap.toString().replaceAll("=", "-")
                .replaceAll("\\{","") .replaceAll("\\}",""));


//solution 4: not working
//        System.out.println("-------------\n");
//
//        List<String> personCountriesSet = stringStream2.map(
//                s -> new Person(s).getCountry()).collect(Collectors.toList());
//
//        StringBuilder sb = new StringBuilder();
//        for(String s : personCountriesSet){
//            //System.out.println(s + "-" + Collections.frequency(personCountriesSet, s));
//            String newCountry = s + "-" + Collections.frequency(personCountriesSet, s) + ", ";
//            sb.append(newCountry);
////            if(newCountry.equals(sb.toString().substring(sb.length()-6, sb.length()-1))){
////                sb.delete(sb.length()-6, sb.length()-1);
////                System.out.println("if");
////            }else{
////                //sb.append(newCountry);
////                System.out.println(sb.toString().substring(sb.length()-6, sb.length()-1));
////                System.out.println("else");
////            }
//        }
//        System.out.println(sb);
//        String tmp = sb.toString();
//        String solution = new String();
//        //System.out.println(sb.substring(0,6));
//        do{
//
//            tmp = tmp.replaceAll(tmp.substring(0,6), "");
//            System.out.println(tmp.substring(0,6));
//            System.out.println(tmp);
//        }while(!tmp.isEmpty());










    }
}
