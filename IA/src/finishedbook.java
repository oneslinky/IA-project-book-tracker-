public class finishedbook {
    public String bookTitle;
    public String authorName;
    public String starRating;
    public String genre;
    public String character;
    public String review;
    public String emotionScale;
    public finishedbook(){
        this.bookTitle="";
        this.authorName="";
        this.starRating="";
        this.genre="";
        this.character="";
        this.review="";
        this.emotionScale="";
    }
    public finishedbook(String a, String b, String c, String d, String e,String f, String g){
        this.bookTitle=a;
        this.authorName=b;
        this.starRating=c;
        this.genre=d;
        this.character=e;
        this.review=f;
        this.emotionScale=g;
    }
}
