import java.util.*;

public class CoveringSegments {

    private static List<Long> optimalPoints(Segment[] segments) {
        //write your code here
        Arrays.sort(segments);
        List<Long> point = new ArrayList<>();
        int pointTrack = 0;
        for (int i = 0; i < segments.length; i++) {
            Long start = segments[i].start;
            Long end = segments[i].end;
            if(point.isEmpty()){
                point.add(end);
            }
            if(point.get(pointTrack) < start) {
                point.add(end);
                pointTrack++;
            } else if (point.get(pointTrack) > end) {
                point.remove(pointTrack);
                point.add(end);
            }
        }

        return point;
    }

    private static class Segment implements Comparable<Segment>{
        Long start, end;

        Segment(Long start, Long end) {
            this.start = start;
            this.end = end;
        }

        public Long getStart(){
            return this.start;
        }

        @Override
        public int compareTo(Segment compareSegment) {
            Long compareSegs = ((Segment) compareSegment).getStart();

            return this.start.compareTo(compareSegs);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            Long start, end;
            start = scanner.nextLong();
            end = scanner.nextLong();
            segments[i] = new Segment(start, end);
        }
        List<Long> points = optimalPoints(segments);
        System.out.println(points.size());
        for (Long point : points) {
            System.out.print(point + " ");
        }
    }
}
 
