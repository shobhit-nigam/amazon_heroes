package managers;

import assets.Feedback;
import customExceptions.ApplicationException;
import queryHelper.QueryBuilder;

/**
 * The class FeedbackManager is a child class of BaseManager.
 * It works as a middle layer between the dbTools package/Lower Layer and the Operations
 * package/Upper Layer.
 * It contains functions related to Feedback table such as read, create a record, validate data
 * from table, operation specific functions which require db support, etc.
 * It is used by the Upper Layers/Operations classes.
 * It utilizes Lower Layer/dbTools package and helper classes via the parent - BaseManager which
 * converts system exceptions to ApplicationExceptions.
 **/

public class FeedbackManager extends BaseManager {

  private static FeedbackManager feedbackManager;

  public static FeedbackManager getInstance() {
    if (feedbackManager == null) {
      feedbackManager = new FeedbackManager();
    }
    return feedbackManager;
  }

  public boolean create(Feedback feedback) throws ApplicationException {
    QueryBuilder queryBuilder = this.getInsertInstance()
            .onTable("feedback")
            .insertValue("feedbackid", feedback.getFeedbackId())
            .insertValue("comment", feedback.getComment())
            .insertValue("userid", feedback.getUserId());

    String sqlQuery = this.buildQuery(queryBuilder);

    this.executeQuery(sqlQuery);

    return true;
  }
}
