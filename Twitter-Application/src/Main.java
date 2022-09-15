import twitter4j.conf.ConfigurationBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {
        FileReader twitterKeys=new FileReader("/Users/abhijith.be/Desktop/Twitter/TwitterApplication/src/twitter.properties");
        Properties fileProperties=new Properties();
        fileProperties.load(twitterKeys);
        System.out.println(fileProperties.getProperty("apikey"));
        String apiKey=fileProperties.getProperty("apikey");
        String apiSecretKey=fileProperties.getProperty("apisecretkey");
        String accessKey=fileProperties.getProperty("accesstoken");
        String accessSecretKey=fileProperties.getProperty("accesssecrettoken");
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while(flag){
            System.out.println("Enter the Choice");
            System.out.println("1.Post a Tweet");
            System.out.println("2.Get Home TimeLines");
            System.out.println("3.Exit");
            int choice=sc.nextInt();
            if(choice==3){
                break;
            }
            switch (choice){
                case 1:
                    System.out.println("Enter the Tweet to Post");
                    String tweetMessage=sc.next();
                    PostTweet postObject=new PostTweet();
                    postObject.postTweet(tweetMessage,apiKey,apiSecretKey,accessKey,accessSecretKey);
                    break;
                case 2:
                    GetTimeline timelineObject=new GetTimeline();
                    timelineObject.getTimeline(apiKey,apiSecretKey,accessKey,accessSecretKey);
                    break;
                default:
                    System.out.println("Wrong Choice Entered");
                    break;
            }
        }

    }
}
