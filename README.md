## Laptop
> Класс **Laptop** содержит приватные переменные для хранения марки (**brand**), ОЗУ (**ram**), объема памяти (**storage**), операционной системы (**operatingSystem**) и цвета ноутбука (**color**). Он также имеет **конструктор**, который принимает значения этих переменных и инициализирует объект класса. Класс также содержит методы-геттеры (**getBrand(), getRam(), getStorage(), getOperatingSystem(), getColor()**) для получения значений переменных.

> Класс **Main** содержит метод **main**, который является точкой входа в программу. В этом методе создается набор ноутбуков с помощью метода **createLaptops()**. Затем пользователю предлагается ввести критерии для фильтрации ноутбуков с помощью метода **getFiltersFromUser()**. Полученные критерии сохраняются в виде **Map<String,** **List** \<**Object**> **filters**. Затем вызывается метод **filterLaptops()**, который принимает набор ноутбуков и критерии фильтрации и возвращает отфильтрованный список ноутбуков. Наконец, вызывается метод **printFilteredLaptops()**, который выводит отфильтрованные ноутбуки и критерии фильтрации на экран.

> Метод **createLaptops()** создает и возвращает набор ноутбуков, добавляя их в объект **HashSet\<Laptop>**.

> Метод getFiltersFromUser() запрашивает у пользователя ввод критериев фильтрации и сохраняет их в **Map<String, List\<Object>> filters**. Каждый критерий представлен числом, которое пользователь вводит, и в зависимости от этого числа запрашиваются соответствующие значения. Критерии и их значения сохраняются в **filters**.

> Метод **filterLaptops()** принимает набор ноутбуков и критерии фильтрации и возвращает отфильтрованный список ноутбуков. Он использует цикл **for-each** для прохода по каждому ноутбуку и проверяет, удовлетворяет ли он критериям фильтрации. Если нет, ноутбук удаляется из списка.

> Метод **printFilteredLaptops()** выводит на экран отфильтрованные ноутбуки и критерии фильтрации. Если отфильтрованных ноутбуков нет, выводится сообщение об этом.