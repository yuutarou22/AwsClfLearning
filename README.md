# AWS CLF 学習アプリ

AWSのCLF(クラウドプラクティショナー）試験の学習アプリです。

## 経緯

AWS CLF試験を受けようと思う。

どうせ学習するならAWSと連携したアプリを作って、ついでに広告つけて小遣い稼ぎしたい。。。

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

## 参考（UI/UX）
- [文字や背景にピュアブラックを使ってはいけない理由](https://uxmilk.jp/73614)
  - 黒のカラーコードに#000000を使うのはイケてないっていうお話
