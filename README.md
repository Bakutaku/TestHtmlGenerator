# TestHtmlGenerator

> TestHtmlGeneratorについて

このツールではYaml形式のファイルをHTML形式の問題集に変化できるツールです。

> 使用方法

HtmlGenerator.javaを実行後、コンソールに用意した YAMLファイルのファイルパスを入力しEnterを押してください。

その後、生成されたHTMLを出力するフォルダのファイルパスを入力しEnterを押してください。

そうすると、先ほど入力したフォルダの中に「TestPreparationHtml.html」というファイルが生成されます。

> YAMLファイルの構造について

YAMLファイルの構造は以下のようになっております

```YAML
data:
  - q: 問題1
    c:
    - 選択1
    - 選択2
    a: 答え

  - q: 問題2
    c:
    - 選択1
    - 選択2
    a: 答え
```

また以下のように複数行の入力にも対応しています
```YAML
data:
  - q: |
      [1]
      問題
    c:
    - 選択1
    - 選択2
    a: |
      A:
      答え
```


> 注意事項

YAMLファイルの構造または入力したフォルダの中にすでに「TestPreparationHtml.html」が存在する場合はエラーが発生します。
