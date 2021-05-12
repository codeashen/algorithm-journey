package graph.basic;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadGraph {

    private static Scanner scanner;

    /**
     * 将指定文件中节点连接关系（边）的数据添加到图中
     *
     * @param graph    带填充边的图
     * @param filename 连接关系文件名
     */
    public static void graph(Graph graph, String filename) {

        readFile(filename);

        try {
            int V = scanner.nextInt();
            if (V < 0)
                throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
            assert V == graph.V();

            int E = scanner.nextInt();
            if (E < 0)
                throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");

            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                assert v >= 0 && v < V;
                assert w >= 0 && w < V;
                graph.addEdge(v, w);
            }
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from input stream, but the next token is \"" + token + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from input stream, but there are no more tokens available");
        }
    }

    private static void readFile(String filename) {
        assert filename != null;
        InputStream inputStream = ReadGraph.class.getClassLoader().getResourceAsStream(filename);
        if (inputStream == null) {
            throw new InputMismatchException("File not found");
        }
        scanner = new Scanner(inputStream, "UTF-8");
        scanner.useLocale(Locale.ENGLISH);
    }
}
