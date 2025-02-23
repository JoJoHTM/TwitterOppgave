import java.util.ArrayList;

public class TwitterAccount {
    private final String username;
    private ArrayList<TwitterAccount> followingList = new ArrayList<TwitterAccount>();
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();


    public TwitterAccount(String username) {
        this.username = username;
    }

    public String getUserName() {
        return username;
    }

    public void follow(TwitterAccount account) {
        account.followingList.add(this);
    }

    public void unfollow(TwitterAccount account) {
        account.followingList.remove(this);
    }

    public boolean isFollowing(TwitterAccount account) {
        return account.followingList.contains(this);
    }

    public boolean isFollowedBy(TwitterAccount account) {
        return this.followingList.contains(account);
    }

    public void tweet(String tweet) {
        tweets.add(new Tweet(this, tweet));
    }

    public void retweet(Tweet retweet) {
        if (retweet.getOriginalTweet() == null) {
            tweets.add(new Tweet(this, retweet));
        }
        else {
            tweets.add(new Tweet(this, retweet.getOriginalTweet()));
        }
    }

    public Tweet getTweet(int index) {
        return tweets.get(tweets.size() - index);
    }

    public int getTweetCount() {
        return tweets.size();
    }

    public int getRetweetCount() {
        int total = 0;
        for (Tweet tweet : this.tweets) {
            total += tweet.getRetweetCount();
        }
        return total;
    }
}
