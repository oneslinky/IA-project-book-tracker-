public class Quotes {
    public String bookTitle;
    public String q0;
    public String q1;
    public String q2;
    public String q3;
    public String q4;
    public String q5;
    public String q6;
    public String q7;
    public String q8;
    public String q9;
    public Quotes(String bt, String q0, String q1,String q2, String q3, String q4, String q5, String q6, String q7, String q8, String q9){
        bookTitle = bt;
        this.q0 = q0;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
        this.q9 = q9;
    }
    public String getBookTitle(){
        return bookTitle;
    }
    public String getQ0() {
        return q0;
    }
    public String getQ1() {
        return q1;
    }
    public String getQ2() {
        return q2;
    }
    public String getQ3() {
        return q3;
    }
    public String getQ4() {
        return q4;
    }
    public String getQ5() {
        return q5;
    }
    public String getQ6() {
        return q6;
    }
    public String getQ7() {
        return q7;
    }
    public String getQ8() {
        return q8;
    }
    public String getQ9() {
        return q9;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public void setQ0(String q0) {
        this.q0 = q0;
    }
    public void setQ1(String q1) {
        this.q1 = q1;
    }
    public void setQ2(String q2) {
        this.q2 = q2;
    }
    public void setQ3(String q3) {
        this.q3 = q3;
    }
    public void setQ4(String q4) {
        this.q4 = q4;
    }
    public void setQ5(String q5) {
        this.q5 = q5;
    }
    public void setQ6(String q6) {
        this.q6 = q6;
    }
    public void setQ7(String q7) {
        this.q7 = q7;
    }
    public void setQ8(String q8) {
        this.q8 = q8;
    }
    public void setQ9(String q9) {
        this.q9 = q9;
    }
    public String toString(){
        return "Book title:" + bookTitle + "\n" + q0 + "~" + q1 + "~" + q2 + "~" + q3+ "~" + q4 + "~" + q5+ "~" + q6 + "~" + q7+ "~" + q8 + "~" + q9 +";\n";
    }
}