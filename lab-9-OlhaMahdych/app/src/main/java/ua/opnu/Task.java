package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    // Завдання 1
    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            if (list.get(i).length() <= list.get(i + 1).length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
            i--; // корекція індексу після видалення
        }
    }

    // Завдання 2
    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i, list.get(i));
        }
    }

    // Завдання 3
    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    // Завдання 4
    public void removeDuplicates(List<String> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            }
        }
    }

    // Завдання 5
    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++; // пропустити доданий ****
            }
        }
    }

    // Завдання 6
    public boolean isPalindrome(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        boolean isPalindrome = true;

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            stack.push(num);
            queue.offer(num);
        }

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num != stack.pop()) {
                isPalindrome = false;
            }
            queue.offer(num);
        }

        return isPalindrome;
    }

    // Завдання 7
    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num < 0) stack.push(num);
            else queue.offer(num);
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // відсортувати чергу за зростанням
        List<Integer> temp = new ArrayList<>(queue);
        Collections.sort(temp);
        queue.clear();
        queue.addAll(temp);
    }

    // Завдання 8
    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num % 2 == 0) queue.offer(num);
            else stack.push(num);
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.removeLast());
        }
    }

    // Завдання 9
    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            max = Math.max(max, s.length());
        }
        return max;
    }

    // Завдання 10
    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    // Завдання 11
    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }

    // Завдання 12
    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        for (String val : map.values()) {
            if (!values.add(val)) return false;
        }
        return true;
    }

    // Завдання 13
    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey()) && map2.get(entry.getKey()).equals(entry.getValue())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    // Завдання 14
    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> reversed = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            // При конфлікті беремо останнє значення
            reversed.put(entry.getValue(), entry.getKey());
        }
        return reversed;
    }


    // Завдання 15
    public int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int val : map.values()) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }

        int minCount = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() < minCount || (entry.getValue() == minCount && entry.getKey() < minValue)) {
                minCount = entry.getValue();
                minValue = entry.getKey();
            }
        }
        return minValue;
    }

    // Завдання 16
    public int maxOccurrences(List<Integer> list) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxCount = 0;
        for (int num : list) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            maxCount = Math.max(maxCount, freq.get(num));
        }
        return maxCount;
    }
}
