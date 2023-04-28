package collection.baseClasses;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.util.Date birthday; //Поле не может быть null
    private Float height; //Поле может быть null, Значение поля должно быть больше 0
    private int weight; //Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле может быть null
}