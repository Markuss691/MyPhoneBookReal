//1 - Добавить контакт
//        2 - Удалить контакт
//        3 - Изменить контакт
//        4 - Просмотр данных контакта
//        5 - Поиск контакта
//        6 - Сортировка контактов
//        7 - Список контактов
//        8 - Вызов контакта
//        0 - Выход

//1 - Добавить контакт
//        5 - Поиск контакта
//        6 - Сортировка контактов
//        7 - Список контактов
//        0 - Выход

//        2 - Удалить контакт
//        3 - Изменить контакт
//        4 - Просмотр данных контакта
//        8 - Вызов контакта

public enum menuOperations {
    add(1),
    del(2),
    edit(3),
    view(4),
    search(5),
    sort(6),
    list(7),
    call(8),
    exit(0);

    menuOperations(int code) {
        this.code = code;
    }
    public static menuOperations getEnumByCode(int code) throws Exception {
        for (menuOperations c : menuOperations.values()) {
            if (c.code == code) {
                return c;
            }
        }
        throw new Exception("Error code");
    //    return menuOperations.exit;
    }
    private final int code;
}
