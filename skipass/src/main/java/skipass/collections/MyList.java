package ua.yandex.skipass.collections;



public interface MyList {

    void add(Object e); //добавляет элемент в конец коллекции

    void add(int index, Object e); //добавляет элемент в указанное место коллекции, и бросает исключение если индекс выходит за рамки

    void addAll(Object[] c); //добавляет массив элементов в конец коллекции

    void addAll(int index, Object[] c); //добавляет массив элементов в указанное место коллекции, и бросает исключение если индекс выходит за рамки

    Object get(int index); //возвращает элемент по индексу, и бросает исключение если индекс выходит за рамки

    Object remove(int index); //удаляет элемент по индексу, и бросает исключение если индекс выходит за рамки

    void set(int index, Object e); //изменяет значение элемента, и бросает исключение если индекс выходит за рамки

    int indexOf(Object o); //поиск индекса по значению элемента (выводит индекс первого найденного, или -1 в случае его отсутствия)

    int size(); //размер коллекции

    void clear(); //удаляет содержимое коллекции

    boolean isEmpty(); //возвращает true если в коллекции нет элементов

    Object[] toArray(); //преобразует коллекцию в массив объектов

    String toString(); //возвращает строку, в которой через запятую выводятся значения элементов в коллекции
}
