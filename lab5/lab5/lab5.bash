cat > src/main/java/com/repository/ShapeRepository.java << 'EOF'
package com.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-репозиторий для управления коллекцией объектов
 * Добавлен в рамках рефакторинга лабораторной работы 5
 */
public class ShapeRepository<T> {
    private List<T> items = new ArrayList<>();
    
    /**
     * Добавляет элемент в коллекцию
     */
    public void add(T item) {
        if (item != null) {
            items.add(item);
            System.out.println("Элемент добавлен в коллекцию");
        }
    }
    
    /**
     * Удаляет элемент по индексу
     */
    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            System.out.println("Элемент удален");
            return true;
        }
        return false;
    }
    
    /**
     * Обновляет элемент по индексу
     */
    public boolean update(int index, T newItem) {
        if (index >= 0 && index < items.size() && newItem != null) {
            items.set(index, newItem);
            System.out.println("Элемент обновлен");
            return true;
        }
        return false;
    }
    
    /**
     * Возвращает все элементы
     */
    public List<T> getAll() {
        return new ArrayList<>(items);
    }
    
    /**
     * Возвращает количество элементов
     */
    public int size() {
        return items.size();
    }
}
EOF