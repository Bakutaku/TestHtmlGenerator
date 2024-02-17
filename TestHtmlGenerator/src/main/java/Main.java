import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 変数定義
        Data data;

        // インスタンス生成
        GetYaml getyaml = new GetYaml();
        HtmlGenerator html = new HtmlGenerator();
        Scanner sc = new Scanner(System.in);

        // 入力
        System.out.print("yamlのファイルパスを入力してください＞");
        String filePath = sc.next();


        // ファイル取得
        data = getyaml.getData(filePath);

        // 生成先の入力
        System.out.print("yamlを生成するフォルダパスを入れてください>");
        String ps = sc.next();
        sc.close();

        // HTMLファイル生成
        System.out.println("HTMLファイルの生成を開始します\n少々お待ちください");
        html.generate(data, ps);
        System.out.println("生成が完了しました");
    }
}
