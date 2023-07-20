package in.stackroute.springrestjpacodingchallenge.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    private int feedbackID;
    private String comment;

    @OneToOne
    private Product product;
    @OneToOne
    private User user;

    public Feedback(){}

    public Feedback(int feedbackID, String comment, Product product, User user) {
        this.feedbackID = feedbackID;
        this.comment = comment;
        this.product = product;
        this.user = user;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
