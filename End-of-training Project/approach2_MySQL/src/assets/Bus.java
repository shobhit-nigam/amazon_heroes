package assets;

/**
 * The class Bus acts as a POJO which holds entity details for a Bus.
 * It supports retrieval and storage of Bus details. It is used in Upper Layer-to-Middle
 *  Layer/Operations package-to-Managers package data transmission.
 * About attributes :
 * busId - Unique ID
 * routeId - Is set when a bus is assigned to a route. Makes the Bus active. Default Value = 0
 * busType - Capacity or Total Number of Seats on a bus.
 * availability - Number of remaining seats / Seats available for booking. Default value = busType
 * timing - Is the start timing of a bus for a particular route. Represented by integer minutes for
 * the time of a day. Default value : -1
 * vehicleNo - Registration Number for a Bus
 **/

public class Bus {

  private int busId;
  private int routeId;
  private int busType;
  private int availability;
  private int timing;
  private String vehicleNo;

  public Bus(int busId, int availability, int busType, String vehicleNo) {
    this.busId = busId;
    this.availability = availability;
    this.busType = busType;
    this.vehicleNo = vehicleNo;
    this.routeId = 0;
    this.timing = -1;
  }

  public int getBusId() {
    return busId;
  }

  public int getAvailability() {
    return availability;
  }

  public int getTiming() {
    return timing;
  }

  public void setTiming(int timing) {
    this.timing = timing;
  }

  public int getBusType() {
    return busType;
  }

  public String getVehicleNo() {
    return vehicleNo;
  }

  public int getRouteId() {
    return routeId;
  }
}
