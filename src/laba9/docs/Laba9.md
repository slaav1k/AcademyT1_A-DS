# Практическое задание 9

**Условие**

В рамках первого вебинара, посвященного парадигмам программирования, разбирались вопросы реализации
объектно-ориентированного подхода к программированию. Задание представляет собой необходимость переработать показанный
на вебинаре калькулятор таким образом, чтобы он реализовывал свою функциональность не через внедрение зависимостей, а
через подтягивание (dependency pull).

**Задание**

В рамках занятия была разобрана реализация объектно-ориентированного калькулятора со следующей структурой кода:

```java
class OperationMaker {
    Supplier<Model> datareader;
    Consumer<Model> printer;
    Map<String, BinaryOperator<Integer>> operations = new HashMap<>();

    public void make() {
        Model model = datareader.get();
        model.res = operations
                .get(model.op)
                .apply(model.x, model.y);
        printer.accept(model);
    }
}

class DataReader implements Supplier<Model> {
    @Override
    public Model get() {
        Model model = new Model();
        Scanner sc = new Scanner(System.in);
        model.op = sc.next();
        model.x = sc.nextInt();
        model.y = sc.nextInt();
        return model;
    }
}

class Printer implements Consumer<Model> {
    @Override
    public void accept(Model model) {
        System.out.println(model.x + model.op + model.y + "=" + model.res);
    }
}

class PlusOperation implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer x, Integer y) {
        return x + y;
    }
}

class MinusOperation implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer x, Integer y) {
        return x - y;
    }
}

class Model {
    int x, y, res;
    String op;
}
```

Для окончательного формирования результата в main методе были созданы все необходимые объекты и далее внедрены в
необходимые поля.

```java
public class Start {
    public static void main(String[] args) throws Exception {
        OperationMaker maker = new OperationMaker();
        maker.datareader = new DataReader();
        maker.printer = new Printer();
        maker.operations.put("+", new MinusOperation());
        maker.operations.put("-", new PlusOperation());
        maker.make();
    }
}
```

Измените порядок формирования объекта калькулятора таким образом, чтобы все созданные объекты хранились в
централизованном хранилище, а калькулятор получал бы на него ссылку и сам выбирал все интересующие его объекты для
внедрения.

**ПО для выполнения задания и как развернуть окружение**

Выполнять задание можно в любой IDE.

**Формат результата**

Решение должно быть представлено в форме исходного кода, включающего реализованный код метода и тесты демонстрации его
работоспособности.


