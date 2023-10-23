public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Добро пожаловать в приложение калькулятор!");
        System.out.println("На скольких человек, вы планируете разделить счет?");
        String enteredValue = Check.enter();
        int countPeople = Integer.parseInt(Check.countPeople(enteredValue));
        Products.productAll(countPeople);
    }
}