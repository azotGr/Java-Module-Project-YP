import java.util.Scanner;

public class Check {
    public static boolean isNumeric(String str)
    {
        try
        {
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }

    public static boolean isDouble(String str)
    {
        try
        {
            Double.parseDouble(str);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }

    public static String enter()
    {
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public static String countPeople(String enter)
    {
        boolean flag = true;
        while(flag)
        {
            if(isNumeric(enter))
            {
                int countPeople = Integer.parseInt(enter);
                if(countPeople == 1)
                {
                    System.out.println("Количество человек, должно быть больше единицы. Введите значение больше единицы.");
                    enter = enter();
                }
                else if (countPeople < 1)
                {
                    System.out.println("Ошибка, введите число больше единицы.");
                    enter = enter();
                }
                else
                {
                    flag = false;
                }
            }
            else
            {
                System.out.println("Некорректный ввод.Введите числовое значение, больше единицы.");
                enter = enter();
            }
        }
        return enter;
    }
    public static double checkPrice(String enter)
    {
        boolean flag = true;
        while(flag)
        {
            if (isDouble(enter.replace(',','.')))
            {
                if(Double.parseDouble(enter) <= 0)
                {
                    System.out.println("Ошибка, введите числовое значение, больше нуля");
                    enter = enter().replace(',','.');
                }
                else
                {
                    flag = false;
                }
            }
            else
            {
                System.out.println("Ошибка, введите числовое значение");
                enter = enter().replace(',','.');
            }
        }
        return Double.parseDouble(enter.replace(',','.'));
    }

    public static String print(double result)
    {
        String[] a = String.valueOf(result).split("[.]");
        int integralPart = Integer.parseInt(a[0]);
        int endOne = integralPart%10;
        int endTwo = integralPart%100;
        if(endOne == 1){
            return " рубль";
        }
        else if((endOne > 1 && endOne < 5) && !(endTwo>=11 && endTwo<=14)){
            return " рубля";
        }
        else if(endTwo >= 11 && endTwo <= 14){
            return " рублей";
        }
        else{
            return " рублей";
        }
    }
}
