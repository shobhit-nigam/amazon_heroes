public class ChainResponsibilityEight {
  public static void main(String[] args) {
    // chain:
    // Firehandler --> LowFuelHandler --> null
    // the chain has just two handler with the firsthandler at
    // the head of chain
    // AbstractHandler lowFuelHandler = new LowFuelHandler(null);
    FireHandler fireHandler = new FireHandler(lowFuelHandler);

    // create emergency request that plane is running low on fuel
    LowFuelRequest lowFuelRequest = new LowFuelRequest();

    // Let the chain handle the request
    fireHandler.handleRequest(lowFuelRequest);

  }
}

abstract class AbstractRequest {
  // each request identified by a number
  int requestCode;

  public AbstractRequest(int requestCode) {
    this.requestCode = requestCode;
  }

  public int getRequestCode() {
    return requestCode;
  }
}

abstract class AbstractHandler {
  AbstractHandler next;

  public AbstractHandler(AbstractHandler next) {
    this.next = next;
  }

  public void setNext(AbstractHandler next) {
    this.next = next;
  }

  public void handleRequest(AbstractRequest request) {
    if (next != null) {
      next.handleRequest(request);
    }
  }
}

class FireDetectRequest extends AbstractRequest {
  // fire request with code 10
  public FireDetectRequest() {
    super(10);
  }
}

class LowFuelRequest extends AbstractRequest {
  public LowFuelRequest() {
    super(11);
  }
}

class FireHandler extends AbstractHandler {
  static int code = 10;

  public FireHandler(AbstractHandler successor) {
    super(successor);
  }

  public void handleRequest(AbstractRequest request) {
    if (code == request.getRequestCode()) {
      // handle the request here 

    } else {
      // if handler can not handle these type of request
      // it can call the super class forward request method
      super.handleRequest(request);
    }
  }
}
