package assets;

/**
 * The class Stop acts as a POJO which holds entity details for a Stop.
 * It supports retrieval and storage of Stop details. It is used in Upper Layer-to-Middle
 * Layer/Operations package-to-Managers package data transmission.
 * About attributes :
 * stopId - Unique ID
 * stopName - Location name for the Stop
 **/

public class Stop {

  private int stopId;
  private String stopName;

  public Stop(int stopId, String stopName) {
    this.stopId = stopId;
    this.stopName = stopName;
  }

  public int getStopId() {
    return stopId;
  }

  public String getStopName() {
    return stopName;
  }
}