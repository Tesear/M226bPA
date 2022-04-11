import java.util.ArrayList;

public class Standard {

    // Fügt die Standard-Games hinzu
    Standard(ArrayList<ArrayList<String>> arrayList){
        ArrayList<String> data_default = new ArrayList<>();
        data_default.add("Minecraft");
        data_default.add("Cool, Sandbox");
        data_default.add("Minecraft ist ein OpenWorld-Sandbox-Spiel");
        ArrayList<String> data_default2 = new ArrayList<>();
        data_default2.add("Counter-Strike: Global Offensive");
        data_default2.add("Competitive, FPS");
        data_default2.add("CS:GO ist ein Taktischer Shooter, bei dem Teamwork die wichtigste Rolle spielt");
        arrayList.add(data_default);
        arrayList.add(data_default2);
    }
}