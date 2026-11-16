# Aggiunge al manifest Android: fotocamera, apertura da widget (carrds://) e il widget stesso
p = 'android/app/src/main/AndroidManifest.xml'
s = open(p, encoding='utf-8').read()
perm = '<uses-permission android:name="android.permission.CAMERA" />\n    <uses-feature android:name="android.hardware.camera" android:required="false" />\n'
if 'permission.CAMERA' not in s:
    s = s.replace('<application', perm + '    <application', 1)
link = ('<intent-filter>\n'
        '                <action android:name="android.intent.action.VIEW" />\n'
        '                <category android:name="android.intent.category.DEFAULT" />\n'
        '                <category android:name="android.intent.category.BROWSABLE" />\n'
        '                <data android:scheme="carrds" />\n'
        '            </intent-filter>\n        ')
s = s.replace('</activity>', link + '</activity>', 1)
rec = ('<receiver android:name=".CarrdsWidget" android:exported="false">\n'
       '            <intent-filter><action android:name="android.appwidget.action.APPWIDGET_UPDATE" /></intent-filter>\n'
       '            <meta-data android:name="android.appwidget.provider" android:resource="@xml/carrds_widget_info" />\n'
       '        </receiver>\n    ')
s = s.replace('</application>', rec + '</application>', 1)
open(p, 'w', encoding='utf-8').write(s)
print('manifest ok')
