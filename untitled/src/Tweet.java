public class Tweet {
    private TwitterAccount author;
    private String text;
    private Tweet retweet;
    public int retweetCounter;

    public Tweet(TwitterAccount account, String text) {
        this.author = account;
        this.text = text;
    }

    public Tweet(TwitterAccount account, Tweet originalTweet) {
        if (originalTweet.author.equals(account)) {
            throw new IllegalArgumentException("Cannot retweet own tweet");
        }
        this.author = account;
        this.retweet = originalTweet;
        this.text = originalTweet.getText();
        originalTweet.retweetCounter++;
    }

    public String getText() {
        return text;
    }

    public TwitterAccount getOwner() {
        return author;
    }

    public Tweet getOriginalTweet() {
        if (retweet == null) {
            return null;
        }
        return retweet;
    }

    public int getRetweetCount() {
        return retweetCounter;
    }
}