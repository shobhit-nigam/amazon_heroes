abstract class MeetingShareScreen {
  public abstract void shareScreen();
}

abstract class MeetingChat {
  public abstract void chat();
}

abstract class MeetingQnA {
  public abstract void askQnA();
}

interface MeetingVideo {
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

  public void putOnVideo() {
  }
}

class GoogleMeet extends MeetingApp {
  public void shareScreen() {
  }

  public void chat() {
  }

  public void askQnA() {
  }

  public void putOnVideo() {
  }
}

class WhatsApp implements MeetingVideo extends MeetingChat{
  public void putOnVideo(){
  }
  public void chat(){

  }
}