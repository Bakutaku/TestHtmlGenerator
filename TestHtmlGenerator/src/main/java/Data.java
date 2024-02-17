import java.util.List;

public class Data {
    private List<Question> data;

    public List<Question> getData() {
        return data;
    }

    public void setData(List<Question> data) {
        this.data = data;
    }

    public static class Question{
        private String q;
        private List<String> c;
        private String a;

        public String getQ() {
            return q;
        }

        public void setQ(String q) {
            this.q = q;
        }

        public List<String> getC() {
            return c;
        }

        public void setC(List<String> c) {
            this.c = c;
        }

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }
}
