import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

public class GetYaml {

    public Data getData(String filePath){
        // yamlファイルの読み込み
        try(InputStream in = new FileInputStream(new File(filePath))){

            Yaml yaml = new Yaml();
            return yaml.loadAs(in, Data.class);
            
        } catch (FileNotFoundException e) {
            System.out.println("エラー:"+e);

        } catch (IOException e) {
            System.out.println("エラー:"+e);

        } catch (Exception e){
            System.out.println("このプログラムでは読み込むことができないファイルです\nエラー:"+e);

        }
        return null;
    }
}
