import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HtmlGenerator {

    public void generate(Data data, String ps){
        // 変数定義
        List<String> questions = new ArrayList<String>();
        int count = 0;


        // HTMLファイル生成
        try{
            // リソースファイルを取得
            try(InputStream resource = getClass().getClassLoader().getResourceAsStream("dataUp.txt")){

                File dir = new File(ps);

                // リソースファイルが取得できなかった場合
                if(resource == null && !dir.isDirectory()){
                    System.out.println("エラー:ファイルまたはフォルダが見つかりませんでした");
                    return;
                }

                // 書き込む先のファイルを指定
                File file = new File(ps,"TestPreparationHtml.html");

                // ファイルがあるかどうか
                if(!file.exists()){
                    // ファイルがなかった場合
                    // ファイルを生成
                    file.createNewFile();

                    // インスタンス生成
                    Scanner sc = new Scanner(resource,"UTF-8"); // ファイルの中身を取得するため

                    try(BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"UTF-8"))){
                        while(sc.hasNext()){
                            bf.write(sc.nextLine()+"\n");
                        }
                    }

                    sc.close();
                }else{
                    // なかった場合
                    System.out.println("すでに生成済みのファイルが存在するため生成できません");
                    return;
                }
            }

            // ファイルの中身の問題をHTMlに変換
            for(Data.Question q : data.getData()){
                // データ成形
                // 問題文改行
                String tmp = "";
                for(String str : q.getQ().split("\n")){
                    tmp += str + "<br>\n";
                }
                q.setQ(tmp);

                // 答え改行
                tmp = "";
                for(String str : q.getA().split("\n")){
                    tmp += str + "<br>\n";
                }
                q.setA(tmp);

                // 選択肢改行
                List<String> tempList = new ArrayList<>();
                for(String c : q.getC()){
                    tmp = "";
                    for(String str : c.split("\n")){
                        tmp += str + "<br>\n";
                    }
                    String tmp2 = "";
                    for(String str2 : tmp.split(" ")){
                        tmp2 += str2 + "&nbsp;";
                    }
                    tempList.add(tmp2);
                }
                q.setC(tempList);
                

                // 空白
                tmp = "";
                for(String str : q.getQ().split(" ")){
                    tmp += str + "&nbsp;";
                }
                q.setQ(tmp);

                // 問題文
                questions.add("    <li>"+q.getQ()+"</li>");
                questions.add("    <li>");
                questions.add("        <ul class=\"pick\">");

                // 回答
                for(String c : q.getC()){
                    if(c != null){
                        questions.add("            <li>"+c+"</li>");
                    }
                }
                // 答え
                questions.add("        </ul>");
                questions.add("    </li>");
                questions.add("    <li><input type=\"button\" value=\"答えを表示\" onclick=\"disp('a"+count+"')\"></li>");
                questions.add("    <li class=\"dispReset\" id=\"a"+count+"\">"+q.getA()+"</li>");
                count++;
            }

            // ファイルに追加
            File file = new File(ps,"TestPreparationHtml.html");

            try(BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"UTF-8"))){
                for(String str : questions){
                    bf.write(str+"\n");
                }
            }


            // リソースファイルを取得
            try(InputStream resource = getClass().getClassLoader().getResourceAsStream("dataUnder.txt")){

                // リソースファイルが取得できなかった場合
                if(resource == null){
                    System.out.println("エラー:ファイルまたはフォルダが見つかりませんでした");
                    return;
                }

                // インスタンス生成
                Scanner sc = new Scanner(resource,"UTF-8"); // ファイルの中身を取得するため

                try(BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"UTF-8"))){
                    while(sc.hasNext()){
                        bf.write(sc.nextLine()+"\n");
                    }
                }

                sc.close();
            }


        }catch(Exception e) {
            System.out.println("エラー:"+e);
        }
    }
}
