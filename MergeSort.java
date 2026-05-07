import java.util.*;

/**
 * MergeSort Algorithm Implementation
 * 합병 정렬 구현
 */
public class MergeSort {

    /**
     * 리스트를 반으로 분할하고 재귀적으로 정렬
     */
    public List<Integer> mergeSort(List<Integer> inList) {
        if (inList.size() <= 1) {
            return inList;
        }

        int mid = inList.size() / 2;
        List<Integer> left = new ArrayList<>(inList.subList(0, mid));
        List<Integer> right = new ArrayList<>(inList.subList(mid, inList.size()));

        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 정렬된 두 개의 리스트를 하나로 합침
     */
    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // 양쪽 리스트의 원소를 비교하여 작은 순서대로 결과 리스트에 추가
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // 남아있는 원소 처리 (왼쪽)
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        // 남아있는 원소 처리 (오른쪽)
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}
