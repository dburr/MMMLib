MMMのMOD用ライブラリ MMMLib 1.6.2 Rev5

拙作のMODで使用されるライブラリです。
とりあえず一緒に入れておいて下さい。



利用条件
	・動画等での使用、改造、転載すきにしてもよいのよ？
	・ただし、商用利用は除く。
	・あと、いかなる意味でも作者は責任をとりませぬ。


使い方
	・要Modloader。
	・%appdata%/.mincraft/versions/1.6.2ML/mods/にZIPのまま放りこんで下さい。
	・%appdata%/.mincraft/config/mod_MMM_MMMLib.cfgができるので設定はそちらで。
	・サーバー側で動作させた場合、クライアントで使用されたテクスチャパックのリストとして、
	　%appdata%/.mincraft/config/mod_MMM_textureList.cfgが作成されます。


設定
	・「renderHacking」はItemRendererの置き換えを指定します。
	　他MOD使用時にどうしても表示がおかしくなる場合はfalseにしてください。
	　但し、拙作のMODの一部で正しく表示が行われなくなります。
	・「isDebugMessage」はMMMLibが出力するデバッグメッセージの設定をします。
	・「startVehicleEntityID」は内部で使用される非生物系のEntityIDを
	　獲得するときの先頭番号を指定します。
	　Forge環境下ではあまり意味はありません。


注意
	・幾つかの自作MODの前提MODとなっているので、入っていないと起動できなくなる場合があります。



変更点
	20130908.1	1.6.2 Rev5 更新
				テクスチャ管理用クラスを追加。
				マルチモデルのアーマー発光処理を追加。
				他細々。




	20130720.1	1.6.2 Rev4 更新
				コンフィグ管理クラスを追加。
				アイテム拡張表示のForge対策。
				assetsディレクトリ関係の修正。
				テクスチャ管理クラスの追加。
				Steveモデルの首輪位置の修正。
				ブロックアイテムのテクスチャロードの不具合を解消。
				発光アーマー周りの追加、未調整。
	20130720.1	1.6.2 Rev3 更新
				古いテクスチャリソースを読めるようにした。
				IModelCapsパラメータの追加。
				他細々。
	20130717.1	1.6.2 Rev2 更新
				ModelPlateの拡大時の挙動を変更。
				アーマーテクスチャの解析がおかしかったのを修正。
				ModelMultiBaseへロープの取り付け位置関数を追加。
				透明化状態でも発光パーツは表示するようにした。
				表示用Entityの生成方法を変更。
	20130713.1	1.6.2 Rev1 バージョンアップ
				仕様変更に対する補助関数の追加。
	20130630.1	1.5.2 Rev7 更新
				ModelPlate調整。
				発光パーツの透過処理を変更。
				発光テクスチャ用にパラメータ追加、処理は未だ未実装。
				可変モデル対応用に一部関数を変更。
				ModelMultiBaseの取得パラメーター関数を追加変更。
				MMM_HelperにreplaceBlockを追加。
	20130618.1	1.5.2 Rev6 更新
				モデル表示用のクラスとしてModelBaseSoloの追加。
				IModelCapsにパラメーターを追加。
				ドキュメントの一部をLMMから移動。
				AlphaBlendの設定をLMMから移動。
	20130611.1	1.5.2 Rev5 更新
				EntityLiving用のEntityCapsを追加。
				モデル選択GUIをこちらへ移動。
				IModelCapsにパラメーターを追加。
				テクスチャ管理対応用インターフェースITextureEntityを大幅改装。
				SlotArmor修正。
				TextureBoxのカラービット管理を修正。
	20130606.1	1.5.2 Rev4 更新
				TextureManagerをインスタンスで扱うように変更。
				マルチ用修正。
				Entity乗っとり処理を微修正、一部を二重登録してnullEntityの生成を防ぐようにした。
				ModelMultiBaseのshowAllPartsを実装。
	20130531.1	1.5.2 Rev3 更新
				ModelBase類の機能絞込み。
				IModelCapsで取得できる値の追加。
				GUI関連(ToggleButton)の追加。
				他細々。
	20130522.1	1.5.2 Rev2 更新
				バージョン依存しないためのマルチモデル化。
				テクスチャ管理の最適化。
	20130412.1	1.5.2 Rev1 バージョンアップ
				バージョン依存しないためのマルチモデル化途中。
				LMMのモデルをこちらに移した。
	20130412.1	1.5.1 Rev5 更新
	20130412.1	1.5.1 Rev4 更新
				MobSelectウィンドウでBOSSを表示してもHPバーが出ないように修正。
				リビジョンチェック機構を追加。
	20130407.1	1.5.1 Rev3 更新
				MMM_Counterを修正。
	20130403.1	1.5.1 Rev2 更新
	20130310.1	1.5.1 Rev1 バージョンアップ
				アイテムの特殊表示周りを調整。
				ちょこちょこ修正。
	20130310.1	1.4.7 Rev6 修正
				アイテムの特殊表示周りを調整。
	20130212.1	1.4.7 Rev5 修正
				decPlayerInventoryをこちらへ移動。
				MMM_ModelDuoのテクスチャ判定を固く。
				野生色の獲得処理をブラッシュアップ。
	20130210.1	1.4.7 Rev4 修正
				Figure用スライダーをこっちに。
				avatar関係の処理を移植。
				刺さった矢関係の処理を修正。
				postRenderで親の移動回転を反映するように。
				アーマーテクスチャのNULL時の処理を修正。
				テクスチャのSVCL間通信の処理を修正。
	20130129.1	1.4.7 Rev3 修正
				モデルがブランクでも表示するように修正。
	20130128.1	1.4.7 Rev2 修正
	20130117.1	1.4.7 Rev1 バージョンアップ
	20130108.1	1.4.6 Rev5 修正
	20130104.1	1.4.6 Rev4 修正
	20121228.1	1.4.6 Rev3 修正
	20121224.1	1.4.6 Rev2 修正
	20121222.1	1.4.6 Rev1 バージョンアップ
	20121217.1	1.4.5 Rev4 修正
	20121204.1	1.4.5 Rev3 修正
				Forge環境下で動かなかったのを修正。
	20121202.1	1.4.5 Rev2 機能追加
	20121121.1	1.4.5 Rev1 バージョンアップ
	20121120.1	1.4.4 Rev1 バージョンアップ
	20121113.1	1.4.2 Rev2 ちょこっと修正
	20121021.1	1.4.2 Rev1 バージョンアップ
	20121021.1	1.3.2 Rev3 更新
				デバッグ用のやつが悪さをしていたのを修正。
	20121015.1	1.3.2 Rev2 更新
	20120922.1	1.3.2 Rev1 リリース

