package wk9;

public class Exercise4 {
    public class Exercise4 {
        public String join(Iterable<String> strings) {
            String[] gesucht = {"Joe", "Tara", "Sue"};

            for (String wort : gesucht) {
                boolean gefunden = false;

                for (String vorhanden : strings) {
                    if (wort.equals(vorhanden)) {
                        gefunden = true;
                        break;
                    }
                }

                if (!gefunden) {
                    return "Java ist nicht cool";
                }
            }

            return "Java ist cool";
        }
    }
}
