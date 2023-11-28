package venturedive.question2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Sorry, I don't exactly remember the problem description now
 */
class Result {

    /*
     * Complete the 'getLatestKRequests' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY requests
     *  2. INTEGER K
     */

    public static List<String> getLatestKRequests(List<String> requests, int K) {
        List<String> latestRequests = new ArrayList<>();

        for (int i = requests.size() - 1; i >= 0 ; i--) {
            if(!lookupInLatestRequests(latestRequests, requests.get(i))) {
                latestRequests.add(requests.get(i));
            } else {
                continue;
            }

            if(latestRequests.size() == K) {
                return latestRequests;
            }
        }


        return latestRequests;
    }

    //Can be done with map but for now doing this way
    private static boolean lookupInLatestRequests (List<String> latestRequests, String item) {
        for (String req: latestRequests) {
            if (req.equals(item)) {
                return true;
            }
        }
        return false;
    }

}

public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int requestsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> requests = IntStream.range(0, requestsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int K = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.getLatestKRequests(requests, K);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
