package january;

class ProJustThatSong {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int length = 0;

        StringBuilder sb;
        for (String i : musicinfos) {
            Music k = new Music(i);
            sb = new StringBuilder();

            int a = 0;
            int l = 0;
            while (l < k.time) {
                sb.append(k.music.charAt(a));
                if (k.music.charAt(a) != '#') {
                    l++;
                }
                a = ++a % k.music.length();
            }

            if (k.music.charAt(a) == '#') {
                sb.append('#');
            }

            k.music = sb.toString();

            int index;
            while ((index = k.music.indexOf(m)) != -1) {
                if (index + m.length() < k.music.length() && k.music.charAt(index + m.length()) == '#') {
                    k.music = k.music.substring(index + m.length() + 1);
                } else {
                    if (k.time > length) {
                        length = k.time;
                        answer = k.title;
                    }
                    break;
                }
            }
        }

        if (answer.equals("")) {
            return "(None)";
        }

        return answer;
    }

    public static class Music {
        int time;
        String title;
        String music;

        public Music(String str) {
            String[] s = str.split(",");
            time = time(s[0], s[1]);
            title = s[2];
            music = s[3];
        }
    }

    public static int time(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");

        return Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1])
                - Integer.parseInt(s[0]) * 60 - Integer.parseInt(s[1]);
    }
}
