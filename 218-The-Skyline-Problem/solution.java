public class Solution {
        class Line implements Comparable<Line> {
        private int x;
        private int height;
        private boolean isStart;

        public Line(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Line o) {
            if (o.x != this.x) {
                return this.x - o.x;
            }
            if (o.isStart && this.isStart) {
                return o.height - this.height;
            }
            if (!o.isStart && !this.isStart) {
                return this.height - o.height;
            }
            return this.isStart ? -1 : 1;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<Line> lines = formatLines(buildings);
        PriorityQueue<Integer> lineHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<Line> skylines = new ArrayList<>();

        for (Line line : lines) {
            if (line.isStart) {
                // starting line of a range or height is higher than current max in this range, skyline changes.
                if (lineHeap.isEmpty() || line.height > lineHeap.peek()) {
                    skylines.add(line);
                }
                lineHeap.offer(line.height);
            } else {
                lineHeap.remove(line.height);
                // if the line is the right boundary of the range, add to skyline.
                if (lineHeap.isEmpty()) {
                    skylines.add(new Line(line.x, 0, false));
                } else if (line.height > lineHeap.peek()) {
                    skylines.add(new Line(line.x, lineHeap.peek(), true));
                }
            }
        }
        return formatSkyline(skylines);
    }

    private List<Line> formatLines(int[][] buildings) {
        List<Line> lines = new ArrayList<>();
        for (int[] building : buildings) {
            lines.add(new Line(building[0], building[2], true));
            lines.add(new Line(building[1], building[2], false));
        }
        Collections.sort(lines);
        return lines;
    }

    private List<int[]> formatSkyline(List<Line> skyline) {
        List<int[]> result = new ArrayList<>();
        for (Line line : skyline) {
            result.add(new int[]{line.x, line.height});
        }
        return result;
    }
}