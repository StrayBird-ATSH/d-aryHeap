import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

class Heap {
    private ArrayList<Integer> heap = new ArrayList<>();
    private int ary;

    Heap(int ary) {
        this.ary = ary;
        defaultInitialize();
    }

    private void defaultInitialize() {
        for (int i = 0; i < 8 * ary; i++)
            heap.add(8 * ary - i);
    }

    private void maxHeapify(int i) {
        ArrayList<Integer> children = getChildren(i);
        if (children != null) {
            int greatestChildIndex = 0;
            int greatestChild = children.get(0);
            for (int j = 1; j < children.size(); j++) {
                if (children.get(j) > greatestChild) {
                    greatestChildIndex = j;
                    greatestChild = children.get(j);
                }
            }
            if (greatestChild > heap.get(i)) {
                heap.set(i * ary + greatestChildIndex, heap.get(i));
                heap.set(i, greatestChild);
            }
        }
    }

    @Nullable
    private ArrayList<Integer> getChildren(int i) {
        if (ary * i >= heap.size()) return null;
        else {
            ArrayList<Integer> children = new ArrayList<>();
            for (int j = 0; j < ary; j++) {
                if (ary * i + j < heap.size())
                    children.add(heap.get(ary * i + j));
            }
            return children;
        }
    }
}
