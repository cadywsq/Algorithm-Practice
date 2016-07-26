public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int lineStart = 0;
        while (lineStart < words.length) {
            int len = words[lineStart].length(); 
            int lineEnd = lineStart + 1;

            // find the end word of the line
            // there will be a space after every word.
            while (lineEnd < words.length && len + 1 + words[lineEnd].length() <= maxWidth) {
                len += words[lineEnd++].length() + 1;
            }

            StringBuilder sb = new StringBuilder();
            int count = lineEnd - lineStart - 1; // lineEnd is excluded
            // when line only contains one word or reach the last line, it will be left justified.
            if (count == 0 || lineEnd == words.length) {
                for (int i = lineStart; i < lineEnd; i++) {
                    sb.append(words[i] + " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - len) / count;
                int longerSpace = (maxWidth - len) % count;
                for (int i = lineStart; i < lineEnd; i++) {
                    sb.append(words[i]);
                    if (i < lineEnd - 1) {
                        for (int j = 0; j <= spaces + (i - lineStart < longerSpace ? 1 : 0); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            result.add(sb.toString());
            lineStart = lineEnd;
        }
        return result;
    }
}