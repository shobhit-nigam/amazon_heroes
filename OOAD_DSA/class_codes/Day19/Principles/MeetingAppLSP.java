abstract class MeetingApp {
  public abstract void shareScreen();
  public abstract void chat();
  public abstract void askQnA();
  public abstract void putOnVideo();
}

interface ScreenAnnotation {
  public abstract void annotateScreen();
}

class AdobeConnect extends MeetingApp implements ScreenAnnotation {
  public void shareScreen() {
  }
  public void chat() {
  }
  public void annotateScreen() {
  }
  public void askQnA() {
  }
  public void putOnVideo(){
  }
}

class GoogleMeet extends MeetingApp  {
  public void shareScreen() {
  }
  public void chat() {
  }
  public void askQnA() {
  }
  public void putOnVideo(){
  }
}

