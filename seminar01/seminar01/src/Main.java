import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static int sum(int n){
        /*
Задание 1 (тайминг 5 минут)
Необходимо написать алгоритм, считающий сумму всех чисел
от 1 до N. Согласно свойствам линейной сложности,
количество итераций цикла будет линейно изменяться
относительно изменения размера N.
 */
        int result = 0;
        for(int i = 1; i <= n; i++)
            result += i;
        return result;
    }

    public static ArrayList<Integer> findSimpleNumber(int n) {
    /*
Задание 2 (тайминг 10 минут)
Написать алгоритм поиска простых чисел (делятся только на себя и
на 1) в диапазоне от 1 до N. В алгоритме будет использоваться
вложенный for, что явно говорит о квадратичной сложности, на этом
стоит акцентировать внимание
     */
        ArrayList<Integer> result = new ArrayList<>();
        boolean simple = true;
        for(int i = 2; i <= n; i++){
            simple = true;
            for(int j = 2; j < i; j++){
                if(i % j == 0){
                    simple = false;
                    break;
                }
            }
            if(simple){
                result.add(i);
            }
        }
        return result;
    }

    /*
    Задача 3 - Игральные кубики

    Есть K игральных кубиков. У каждого кубика N граней, на которых записаны числа от 1 до N.
    На вход программе поступает два целых числа K и N.
    Необходимо написать алгоритм поиска всех доступных комбинаций при броске всех этих кубиков.
    Вариант 1: количество кубиков может быть строго ограничено (например, 4 кубика).
    Вариант 2: количество кубиков будет динамическим (K задает пользователь).
     */

    public static int comb_1(int n){
        // k = 4
        int count = 0;
        // O(n^4)
        for(int a = 1; a <= n; a++)
            for(int b = 1; b <= n; b++)
                for(int c = 1; c <= n; c++)
                    for(int d = 1; d <= n; d++)
                        count++;
        return count;
    }

    public static int comb_2(int k, int n){
        if(k > 0)
            return comb_2_rec(1, k, n);
        return 0;
    }

    private static int comb_2_rec(int h, int k, int n){
        if(h == k + 1)
            return 1;
        int count = 0;
        for(int i = 1; i <= n; i++){
            count += comb_2_rec(h + 1, k, n);
        }
        return count;
    }

    /*
    Задача 4.1 - Числа Фибоначчи
    Числа Фибоначчи - это последовательность целых чисел. Первое и второе
    число Фибоначчи равны 1. Каждое следующее число равно вычисляется как
    сумма двух предыдущих значений.
        F(1) = 1;
        F(2) = 1;
        F(n) = F(n-1) + F(n-2)
    На вход прогамме поступает целое число N в отрезке [1; 100].
    Напишите рекурсивный алгоритм поиска числа Фибоначчи под номером N
     */

    public static int fib_rec(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        return fib_rec(n - 1) + fib_rec(n - 2);
    }

    /*
    Задача 4.1 - Числа Фибоначчи
    Числа Фибоначчи - это последовательность целых чисел. Первое и второе
    число Фибоначчи равны 1. Каждое следующее число равно вычисляется как
    сумма двух предыдущих значений.
        F(1) = 1;
        F(2) = 1;
        F(n) = F(n-1) + F(n-2)
    На вход прогамме поступает целое число N в отрезке [1; 100].
    Напишите линейный алгоритм поиска числа Фибоначчи под номером N
     */

    public static int fib_lin(int n){
        final int[] numbers = new int[n + 1];
        numbers[1] = 1;
        numbers[2] = 1;

        for (int i = 3; i <= n; i++)
            numbers[i] = numbers[i - 1] + numbers[i - 2];

        return numbers[n];
    }

    /*
    Задача 4.3 - Числа Фибаначчи
    Сравните время работы алгоритмов из задач 4.1 и 4.2;
    Для сравнения в языке java есть класс Date с методом getTime().
     */

    public static void test(){
        for (int n = 10; n <= 45; n++){
            Date start = new Date();
            fib_rec(n);
            Date end = new Date();
            long time1 = end.getTime() - start.getTime();

            start = new Date();
            fib_lin(n);
            end = new Date();
            long time2 = end.getTime() - start.getTime();

            System.out.printf("n: %d, rec: %d, lin: %d%n", n, time1, time2);
        }
    }

    public static void main(String[] args) {
//        ArrayList<Integer> result = findSimpleNumber(100);
//        for (Integer i:result)
//            System.out.println(i);
//        System.out.println(comb_1(6));
//        System.out.println(comb_2(4, 6));
//        System.out.println(fib_rec(10));
//        System.out.println(fib_lin(10));
        test();
    }


}
