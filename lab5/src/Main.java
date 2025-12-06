import functions.*;

public class Main {
    public static void main(String[] args) {

        FunctionPoint[] points1 = {
                new FunctionPoint(0.0, 0.0),
                new FunctionPoint(1.0, 1.0),
                new FunctionPoint(2.0, 128.0)
        };

        FunctionPoint[] points2 = {
                new FunctionPoint(0.0, 0.0),
                new FunctionPoint(1.0, 1.0),
                new FunctionPoint(2.0, 128.0)
        };

        FunctionPoint[] points3 = {
                new FunctionPoint(0.0, 0.0),
                new FunctionPoint(1.0, 3.8),
                new FunctionPoint(2.0, 15.3)
        };

        ArrayTabulatedFunction arrayFunc1 = new ArrayTabulatedFunction(points1);
        ArrayTabulatedFunction arrayFunc2 = new ArrayTabulatedFunction(points2);
        ArrayTabulatedFunction arrayFunc3 = new ArrayTabulatedFunction(points3);

        LinkedListTabulatedFunction listFunc1 = new LinkedListTabulatedFunction(points1);
        LinkedListTabulatedFunction listFunc2 = new LinkedListTabulatedFunction(points2);
        LinkedListTabulatedFunction listFunc3 = new LinkedListTabulatedFunction(points3);

        System.out.println("=== 1. Тестирование метода toString() ===");
        System.out.println();
        System.out.println("ArrayTabulatedFunction: " + arrayFunc1);
        System.out.println("LinkedListTabulatedFunction: " + listFunc1);
        System.out.println();

        System.out.println("=== 2. Тестирование метода equals() ===");
        System.out.println();

        System.out.println("2.1 Сравнение одинаковых ArrayTabulatedFunction:");
        System.out.println("arrayFunc1.equals(arrayFunc2) = " + arrayFunc1.equals(arrayFunc2));
        System.out.println("arrayFunc2.equals(arrayFunc1) = " + arrayFunc2.equals(arrayFunc1));

        System.out.println("\n2.2 Сравнение одинаковых LinkedListTabulatedFunction:");
        System.out.println("listFunc1.equals(listFunc2) = " + listFunc1.equals(listFunc2));
        System.out.println("listFunc2.equals(listFunc1) = " + listFunc2.equals(listFunc1));

        System.out.println("\n2.3 Сравнение ArrayTabulatedFunction и LinkedListTabulatedFunction с одинаковыми точками:");
        System.out.println("arrayFunc1.equals(listFunc1) = " + arrayFunc1.equals(listFunc1));
        System.out.println("listFunc1.equals(arrayFunc1) = " + listFunc1.equals(arrayFunc1));

        System.out.println("\n2.4 Сравнение разных функций:");
        System.out.println("arrayFunc1.equals(arrayFunc3) = " + arrayFunc1.equals(arrayFunc3));
        System.out.println("listFunc1.equals(listFunc3) = " + listFunc1.equals(listFunc3));
        System.out.println("arrayFunc1.equals(listFunc3) = " + arrayFunc1.equals(listFunc3));
        System.out.println();

        System.out.println("=== 3. Тестирование метода hashCode() ===");

        System.out.println();
        System.out.println("3.1 Хэш-коды одинаковых функций:");
        System.out.println("hashCode arrayFunc1 = " + arrayFunc1.hashCode());
        System.out.println("hashCode arrayFunc2 = " + arrayFunc2.hashCode());
        System.out.println("hashCode listFunc1 = " + listFunc1.hashCode());

        System.out.println("hashCode listFunc2 = " + listFunc2.hashCode());

        System.out.println("\n3.2 Хэш-коды разных функций:");
        System.out.println("hashCode arrayFunc3 = " + arrayFunc3.hashCode());
        System.out.println("hashCode listFunc3 = " + listFunc3.hashCode());

        System.out.println("\n3.3 Проверка согласованности equals() и hashCode():");
        System.out.println("arrayFunc1.equals(arrayFunc2) = " + arrayFunc1.equals(arrayFunc2) +
                ", hashCode равны? " + (arrayFunc1.hashCode() == arrayFunc2.hashCode()));
        System.out.println("listFunc1.equals(listFunc2) = " + listFunc1.equals(listFunc2) +
                ", hashCode равны? " + (listFunc1.hashCode() == listFunc2.hashCode()));
        System.out.println("arrayFunc1.equals(arrayFunc3) = " + arrayFunc1.equals(arrayFunc3) +
                ", hashCode равны? " + (arrayFunc1.hashCode() == arrayFunc3.hashCode()));

        System.out.println("\n3.4 Изменение объекта и хэш-кода:");
        ArrayTabulatedFunction arrayFuncModified = new ArrayTabulatedFunction(points1);
        System.out.println("Исходный hashCode: " + arrayFuncModified.hashCode());

        try {
            FunctionPoint point = arrayFuncModified.getPoint(1);
            point.setY(point.getY() + 0.001);
            arrayFuncModified.setPoint(1, point);
            System.out.println("hashCode после изменения Y на 0.001: " + arrayFuncModified.hashCode());
            System.out.println("Объект изменился? " + !arrayFunc1.equals(arrayFuncModified));
        } catch (Exception e) {
            System.out.println("Ошибка при изменении точки: " + e.getMessage());
        }
        System.out.println();

        System.out.println("=== 4. Тестирование метода clone() ===");
        System.out.println();

        System.out.println("4.1 Клонирование ArrayTabulatedFunction:");
        try {
            ArrayTabulatedFunction arrayOriginal = new ArrayTabulatedFunction(points1);
            ArrayTabulatedFunction arrayClone = (ArrayTabulatedFunction) arrayOriginal.clone();

            System.out.println("Оригинал: " + arrayOriginal);
            System.out.println("Клон: " + arrayClone);
            System.out.println("Оригинал == Клон? " + (arrayOriginal == arrayClone));
            System.out.println("Оригинал.equals(Клон)? " + arrayOriginal.equals(arrayClone));

            arrayOriginal.setPointY(1, 999.0);
            System.out.println("Оригинал после изменения: " + arrayOriginal);
            System.out.println("Клон после изменения оригинала: " + arrayClone);
            System.out.println("Клон не изменился? " + (!arrayOriginal.equals(arrayClone)));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n4.2 Клонирование LinkedListTabulatedFunction:");
        try {
            LinkedListTabulatedFunction listOriginal = new LinkedListTabulatedFunction(points1);
            LinkedListTabulatedFunction listClone = (LinkedListTabulatedFunction) listOriginal.clone();

            System.out.println("Оригинал: " + listOriginal);
            System.out.println("Клон: " + listClone);
            System.out.println("Оригинал == Клон? " + (listOriginal == listClone));

            System.out.println("Оригинал.equals(Клон)? " + listOriginal.equals(listClone));

            listOriginal.setPointY(1, 888.0);
            System.out.println("Оригинал после изменения: " + listOriginal);
            System.out.println("Клон после изменения оригинала: " + listClone);
            System.out.println("Клон не изменился? " + (!listOriginal.equals(listClone)));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Тестирование завершено ===");
    }
}