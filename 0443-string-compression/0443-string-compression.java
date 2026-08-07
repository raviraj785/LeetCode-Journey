class Solution {
    public int compress(char[] chars) {

        int write = 0;

        int count = 1;

        for (int i = 1; i < chars.length; i++) {

            char curr = chars[i];
            char prev = chars[i - 1];

            if (curr == prev) {
                count++;
            } else {

                chars[write++] = prev;

                if (count > 1) {
                    String str = "" + count;

                    for (int j = 0; j < str.length(); j++) {
                        chars[write++] = str.charAt(j);
                    }
                }

                count = 1;
            }
        }

        // Last group
        chars[write++] = chars[chars.length - 1];

        if (count > 1) {
            String str = "" + count;

            for (int j = 0; j < str.length(); j++) {
                chars[write++] = str.charAt(j);
            }
        }

        return write;
    }
}