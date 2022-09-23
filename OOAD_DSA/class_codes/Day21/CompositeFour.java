import java.util.List;
import java.util.ArrayList;

public class CompositeFour {

  public static void main(String[] args) {
    Module objs = new OSystem();
    Module objj = new JavaDS();

    Atlas objAtlas = new Atlas();

    objAtlas.addModule(objs);
    objAtlas.addModule(objj);

    objAtlas.displayModuleName();
    
  }
}

// base component
interface Module {
  // some more attributes
  void displayModuleName();
}

// leaf(s)
class OSystem implements Module {
  public void displayModuleName() {
    System.out.println(getClass().getSimpleName());
  }
}

class JavaDS implements Module {
  public void displayModuleName() {
    System.out.println(getClass().getSimpleName());
  }
}
// composite element 

class Atlas implements Module {
  List<Module> subModules;

  public Atlas() {
    this.subModules = new ArrayList<>();
  }

  public void displayModuleName() {
    subModules.forEach(Module::displayModuleName);
  }

  public void addModule(Module objm) {
    subModules.add(objm);
  }

  public void deleteModule(Module objm) {
    subModules.remove(objm);
  }

}
