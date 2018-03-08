package edu.knoldus.application2;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class Operations {
    private twitter4j.Twitter twitter = new TwitterFactory().getInstance();
    private Query query;

    /* Import Twitter Configuration Files and set count of
    50 so that only 50 post related to hashTags will Printed */
    public Operations(final String hashTag) {
        Properties properties = new Properties();
        try {
            InputStream input = new FileInputStream("/home/knoldus/IdeaProjects"
                    + "/assignmentjava802/src/main/resources/config.properties");
            properties.load(input);
            twitter.setOAuthConsumer(properties.getProperty("consumerKey"),
                    properties.getProperty("consumerSecretKey"));
            twitter.setOAuthAccessToken(new AccessToken(properties.getProperty("accessToken"),
                    properties.getProperty("accessTokenSecret")));
            query = new Query(hashTag);
            query.setCount(50);
        } catch (Exception msg) {
            msg.printStackTrace();
        }
    }

    /* get Total Number Tweets On the
  Basis of HashTags*/
    public CompletableFuture<Integer> getTotalNoOfTweets() {
        return CompletableFuture.supplyAsync(() -> {
            Integer numOfTweetCounts = 0;
            try {
                numOfTweetCounts = twitter.search(query).getTweets().size();
            } catch (TwitterException msg) {
                msg.getMessage();
            }
            return numOfTweetCounts;
        }).thenApply(tweets -> {
            System.out.println("Total Number Of Tweets: " + tweets);
            return tweets;
        });
    }

    /* get AverageTweets Per Day On the
  Basis of HashTags*/

    public CompletableFuture<Double> getAverageTweetsPerDay() {
        return CompletableFuture.supplyAsync(() -> {
            Double averagePerDayTweetCount = 0.0;
            try {
                averagePerDayTweetCount = twitter.search(query).getTweets().size() / 7.0;
            } catch (TwitterException msg) {
                msg.getMessage();
            }
            return averagePerDayTweetCount;
        }).thenApply(tweets -> {
            System.out.println("Average Tweets Per Day: " + tweets);
            return tweets;
        });
    }

    /* get Average Number Of Likes On the
  Basis of HashTags*/

    public CompletableFuture<Double> getAverageNumOfLikes() {
        return CompletableFuture.supplyAsync(() -> {
            Double averageLikeTweetCount = 0.0;
            try {
                List<Status> twitterStatus = twitter.search(query).getTweets();
                Double tweetsCount = twitterStatus.size() + 0.0;
                averageLikeTweetCount = twitterStatus.parallelStream()
                        .map(tweets -> tweets.getFavoriteCount())
                        .reduce((t1, t2) -> t1 + t2).get() / tweetsCount;
            } catch (TwitterException msg) {
                msg.getMessage();
            }
            return averageLikeTweetCount;
        }).thenApply(tweets -> {
            System.out.println("Average Like PerTweet: " + tweets);
            return tweets;
        });
    }

    /* get Average Number Of ReTweets On the
  Basis of HashTags*/

    public CompletableFuture<Double> getAverageReTweets() {
        return CompletableFuture.supplyAsync(() -> {
            Double countOfReTweet = 0.0;
            try {
                List<Status> twitterStatus = twitter.search(query).getTweets();
                Double twitterSize = twitterStatus.size() + 0.0;
                countOfReTweet = twitterStatus.parallelStream()
                        .map(tweets -> tweets.getRetweetCount()).reduce((a, b) -> a + b).get() / twitterSize;
            } catch (TwitterException msg) {
                msg.getMessage();
            }
            return countOfReTweet;
        }).thenApply(tweets -> {
            System.out.println("Average ReTweets PerTweet: " + tweets);
            return tweets;
        });
    }
}
