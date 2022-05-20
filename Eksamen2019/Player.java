public class Player {
    private String nick;
    private int max, rounds;

    public Player (String nick) {
        this.nick = nick;
    }

    public String toStirng() {
        return nick+";"+rounds+";"+max;
    }
}
