package model;

public class Line {
    private int start;
    private int end;
    private String content;

    public Line(int start, int end, String content) {
        this.start = start;
        this.end = end;
        this.content = content;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "{"+start+"}{"+end+"}"+content;
    }
}
