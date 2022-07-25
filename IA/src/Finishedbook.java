public class Finishedbook {
    public String bookTitle;
    public String authorName;
    public String starRating;
    public String genre;
    public String character;
    public String review;
    public String emotionScale;
    public Finishedbook(String bT, String aN, String sR, String g, String c,String r, String eS){
        bookTitle = bT;
        authorName = aN;
        starRating = sR;
        genre = g;
        character = c;
        review = r;
        emotionScale = eS;
    }
    public void setBookTitle(String bT){
        bookTitle = bT;
    }
    public void setAuthorName(String aN){
        authorName = aN;
    }
    public void setStarRating(String sR){
        starRating = sR;
    }
    public void setGenre(String g){
        genre = g;
    }
    public void setCharacter(String c){
        character = c;
    }
    public void setReview(String r){
        review = r;
    }
    public void setEmotionScale(String eS){
        emotionScale = eS;
    }
    public String getBookTitle(){
       return  bookTitle;
    }
    public String getAuthorName(){
        return authorName;
    }
    public String getStarRating(){
        return starRating;
    }
    public String getGenre(){
        return genre;
    }
    public String getCharacter(){
        return character;
    }
    public String getReview(){
        return review;
    }
    public String getEmotionScale(){
        return emotionScale;
    }
    public String toString(){
        return "Book title:" + bookTitle + "~" + authorName + "~" + starRating + "~" + genre + "~" + character + "~" + review + "~" + emotionScale +  "~";
    }
}
