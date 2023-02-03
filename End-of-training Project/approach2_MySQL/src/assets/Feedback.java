package assets;

/**
 * The class Feedback acts as a POJO which holds entity details for a user Feedback.
 * It supports retrieval and storage of Feedback details. It is used in Upper Layer-to-Middle
 * Layer/Operations package-to-Managers package data transmission.
 * About attributes :
 * feedbackId - Unique ID
 * comment - Comment string provided by the user.
 * userId - Feedback provider's user ID.
 **/

public class Feedback {

  private int feedbackId;
  private String comment;
  private int userId;

  public Feedback(int feedbackId, int userId, String comment) {
    this.feedbackId = feedbackId;
    this.comment = comment;
    this.userId = userId;
  }

  public int getFeedbackId() {
    return feedbackId;
  }

  public String getComment() {
    return comment;
  }

  public int getUserId() {
    return userId;
  }
}
