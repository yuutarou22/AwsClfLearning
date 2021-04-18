# AWS CLF 学習アプリ

AWSのCLF(クラウドプラクティショナー）試験の学習アプリです。

## 経緯

AWS CLF試験を受けようと思う。

どうせ学習するならAWSと連携したアプリを作って、AndroidもAWSも理解を深めようという動機から。

## S3の導入
- IAMの追加
- 

## 参考（技術面）
- Toolbarの実装
  - [基礎](https://note.com/fiasjawn/n/n403266120226)
  - [importでハマった](https://qiita.com/tkmd35/items/a0af2b985491ddef7bc7)
  - [Menuをカスタマイズ](https://developer.android.com/training/appbar/actions?hl=ja)
  - [ActionBarとの違い](https://moewe-net.com/android/toolbar)
- kotlin-android-extensions
  - clickListenerを実装する際大活躍だったプラグインがAndroidStudio4.1から消えてるっぽい
  - [概要](https://qiita.com/superman9387/items/9df8038c4db92a7136c8)
  - [設定方法](https://minpro.net/kotlin-android-extensions-gone-from-android-studio-4-1)
- AdMob
  - [導入](https://developers.google.com/admob/android/quick-start?hl=ja#import_the_mobile_ads_sdk)
  - [サンプル広告コード](https://developers.google.com/admob/android/test-ads#sample_ad_units)
  - [バナー広告](https://developers.google.com/admob/android/banner?hl=ja#kotlin_1)
  - [ストア公開し、リンク付けしないと本番広告は表示されない](https://www.yukiiworks.com/archives/267)
- ViewPager
  - [ViewPagerの実装](https://developer.android.com/training/animation/screen-slide?hl=ja)
  - [画面遷移後に表示されなくなってハマった](https://qiita.com/tomoteru/items/1e2328b05fb8257f4192)
    - FragmentManagerではなく、ChildFragmentMangerを使わないといけなかった。
  - [PagerSlidingTabStripっていうのもある](https://qiita.com/kkkaaakkku/items/3e5297455795861f17f1)
- EpandableListView（折り畳み可能ListView）
  - [実装方法](https://tekulearn.jimdofree.com/%E9%96%8B%E7%99%BA/%E9%A0%85%E7%9B%AE1-10/6-%E3%83%AA%E3%82%B9%E3%83%88%E3%82%92%E8%A1%A8%E7%A4%BA/)
  - [実装方法２](http://android-note.open-memo.net/sub/list_view__make_expandable_list_view.html)
- Fuel
  - [kittinunf/fuel](https://github.com/kittinunf/fuel)
  - [http通信ライブラリ](https://blog.masterka.net/archives/2275)
  - [Qiitaの記事](https://qiita.com/naoi/items/8df1409ad48ad8f3c632)
  - [joinメソッドで処理待ち](https://github.com/kittinunf/fuel/blob/da920c5fc0ed19e8082b09f24002e4abf68f2005/fuel/src/main/kotlin/com/github/kittinunf/fuel/core/requests/CancellableRequest.kt#L34)
- WebViewでlinkタップ時にブラウザに飛ばないようにする
  - [shouldOverrideUrlLoading](https://asahima.hatenablog.jp/entry/2017/01/08/000000)
- ListView
  - [設定画面ではBaseAdapterを使った](https://qiita.com/Tsumugi/items/47f31bb7351979a45653)
  - [onItemClickListenerを実装しているのに反応しない場合](https://blog.goo.ne.jp/shunsuke222/e/4eff69bb74ea9db47f644ff37aef88c7)
    - SwitchWidgetがタッチイベントを先に検知しているみたい。そのせいでListの要素のタッチイベントが走らないようになっていた。
    - Switchの「focusableInTouchMode」と「focusable」をFalseに設定して対応
    - [上位LayoutのdescendantFocusabilityをblocksDescendantsにするとかもある](https://teratail.com/questions/37876)
- SharedPreferences
  - [使い方](https://akira-watson.com/android/kotlin/sharedpreferences-datastorage.html)
  - [SharedPreferencesの管理方法](https://qiita.com/ryo_mm2d/items/b90dbbd726183c20c14c)
- シェア機能の実装
  - [IntentのcreateChooserっての使う](https://lineocean.com/2017/04/20/138/)
- 非同期処理について
  - [API30からAsyncTaskは非推奨となった](https://developer.android.com/reference/android/os/AsyncTask)
    - https://tips.priart.net/52/
  - [非同期処理の8つの方法](https://banbara-studio.hatenablog.com/entry/2018/06/07/141305)
  - [AsyncTask基本の基](https://qiita.com/sasaki_shunsuke/items/19967025e4cde8be3da7)
- Coroutineについて
  - [Coroutine概観](https://qiita.com/kawmra/items/ee4acb7db61f70dec9a8)
  - [逆引きCoroutine](https://qiita.com/kumamotone/items/8972dc5732a48c90f0dd)

## 参考（UI/UX）
- 文字や背景にピュアブラックを使ってはいけない理由
  - [黒のカラーコードに#000000を使うのはイケてないっていうお話](https://uxmilk.jp/73614)
- ダークモード対応
  - [独自のThemeを作成する方法](https://qiita.com/s17er/items/04a080181c860ea84694)
    - 独自属性（アトリビュート）を作成->attrs.xml
      - 色以外でも可
    - 独自テーマを作成->styles.xml
    - 色を定義->colors.xml
  - [ダークモードの色について](https://qiita.com/keidroid/items/920e655fa6823b533ba1)
  - [Themeについて](https://konifar.hatenablog.com/entry/2019/02/11/122825)

## 参考（問題）
- [【公式】AWSクラウドプラクティショナーの基礎知識](https://aws.amazon.com/jp/training/course-descriptions/cloud-practitioner-essentials/)
- [問題集](https://www.amazon.co.jp/dp/4797397403/ref=cm_sw_em_r_mt_dp_U_NGakEb305PQ0C)
