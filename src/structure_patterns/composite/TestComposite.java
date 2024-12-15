package structure_patterns.composite;

import structure_patterns.composite.editor.ImageEditor;
import structure_patterns.composite.shapes.Circle;
import structure_patterns.composite.shapes.CompoundShape;
import structure_patterns.composite.shapes.Dot;
import structure_patterns.composite.shapes.Rectangle;

import java.awt.*;
/*
Тип паттерна: структурный.
Шаги реализации:
1. Убедитесь, что ядро модели вашего приложения можно представить древовидной структурой. Разложите её
   на простые элементы и контейнера. Контейнера должны быть способны содержать и простые элементы и другие контейнера.
2. Создайте интерфейс с набором методов, которые можно применить и к просты и к составным компонентам.
3. Создайте класс-лист дерева, который будут наследовать простые элементы. Программа может строится на
   нескольких видах классов-листов дерева.
4. Создайте класс-контейнер, который будут наследовать составные элементы. В данном классе объявите поле типа массив
   (например Array-list) для хранения ссылок на включенные простые элементы. Поле-массив должно хранить в себе и листья
   и контейнеры, поэтому оно должно быть параметризовано интерфейсом.
5. При переопределение методов интерфейса необходимо помнить, что контейнер должен делегировать всю работу
   вложенным элементам.
6. Напишите методы добавления дочерних элементов в контейнер и удаления их из него.
   Данные методы могут быть объявлены в начальном интерфейсе. Это нарушит принцип разделения интерфейсов, т.к. методы
   будут пусты в классах-листьях дерева, но позволит использовать элементы одинаково с момента построения дерева.

Примеры использования:
java.awt.Container#add(Component) (практически все компоненты Swing)
javax.faces.component.UIComponent#getChildren() (практически все компоненты JSF UI - JavaServerFaces User Interface)
 */
public class TestComposite {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );

        String plus = """
                1. Можно использовать сложные древовидные структуры более гибко с применением полиморфизма
                   и рекурсии.
                2. Реализация принципа открытости-закрытости: благодаря древовидной структуре можно добавлять
                   новые виды элементов в приложение не нарушая существующий код. 
                """;

        String minus = """
                1. Может быть сложно создать общий интерфейс для сильно различающихся по функционалу классов.
                2. В определенных ситуациях придётся нарушить принцип разделения интерфейсов, создав
                   универсальный единый интерфейс, цель работы которого будет сложно понять.
                """;

        System.out.println("Плюсы:\n" + plus);
        System.out.println("Минусы:\n" + minus);
    }
}