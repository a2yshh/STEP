import java.time.LocalDateTime;

class Post {
    String author;
    String content;
    LocalDateTime time;

    public Post(String author, String content) {
        this.author = author;
        this.content = content;
        this.time = LocalDateTime.now();
    }

    public void display() {
        System.out.println(author + " posted: " + content + " at " + time);
    }
}

class InstagramPost extends Post {
    int likes;
    String hashtags;

    public InstagramPost(String author, String content, String hashtags, int likes) {
        super(author, content);
        this.hashtags = hashtags;
        this.likes = likes;
    }

    @Override
    public void display() {
        System.out.println("📸 Instagram Post by " + author);
        System.out.println(content + " " + hashtags);
        System.out.println("❤️ Likes: " + likes + " | Posted at: " + time);
        System.out.println("---------------------------------");
    }
}

class TwitterPost extends Post {
    int retweets;

    public TwitterPost(String author, String content, int retweets) {
        super(author, content);
        this.retweets = retweets;
    }

    @Override
    public void display() {
        System.out.println("🐦 Twitter Post by " + author);
        System.out.println(content + " (" + content.length() + " chars)");
        System.out.println("🔁 Retweets: " + retweets + " | Posted at: " + time);
        System.out.println("---------------------------------");
    }
}

class LinkedInPost extends Post {
    int connections;

    public LinkedInPost(String author, String content, int connections) {
        super(author, content);
        this.connections = connections;
    }

    @Override
    public void display() {
        System.out.println("💼 LinkedIn Post by " + author);
        System.out.println("\"" + content + "\"");
        System.out.println("Connections Engaged: " + connections + " | Posted at: " + time);
        System.out.println("---------------------------------");
    }
}

public class SocialMedia {
    public static void main(String[] args) {
        Post insta = new InstagramPost("Alice", "Enjoying the sunset!", "#nature #sunset", 120);
        Post twitter = new TwitterPost("Bob", "Just launched a new project!", 45);
        Post linkedin = new LinkedInPost("Charlie", "Excited to start my new role at XYZ Corp.", 300);

        insta.display();
        twitter.display();
        linkedin.display();
    }
}

