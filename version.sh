#!/usr/bin/env bash
./versionizer.sh ./VERSION
ANXVERSION=$(cat ./VERSION|tail -n1|cut -d= -f2|tr -d '\r')
ANXVERSIONNUMBER=$(cat ./VERSION|head -n1|cut -d= -f2|tr -d '\r')

sed -i "s/$(cat ./src/ANXCamera/AndroidManifest.xml|grep android:versionCode|tr -d " ")/android:versionCode=\"${ANXVERSIONNUMBER}\"/g" ./src/ANXCamera/AndroidManifest.xml
sed -i "s/$(cat ./src/ANXCamera/AndroidManifest.xml|grep android:versionName|tr -d " ")/android:versionName=\"${ANXVERSION}\"/g" ./src/ANXCamera/AndroidManifest.xml

sed -i "s/$(cat ./src/ANXCameraMagisk/module.prop|grep versionCode=|tr -d " ")/versionCode=${ANXVERSIONNUMBER}/g" ./src/ANXCameraMagisk/module.prop
sed -i "s/$(cat ./src/ANXCameraMagisk/module.prop|grep version=|tr -d " ")/version=${ANXVERSION}/g" ./src/ANXCameraMagisk/module.prop

sed -i "s/$(cat ./src/ANXCameraUnity/module.prop|grep versionCode=|tr -d " ")/versionCode=${ANXVERSIONNUMBER}/g" ./src/ANXCameraUnity/module.prop
sed -i "s/$(cat ./src/ANXCameraUnity/module.prop|grep version=|tr -d " ")/version=${ANXVERSION}/g" ./src/ANXCameraUnity/module.prop

sed -i "s/$(cat ./src/ANXCameraPerseusStockLibsUnity/module.prop|grep versionCode=|tr -d " ")/versionCode=${ANXVERSIONNUMBER}/g" ./src/ANXCameraPerseusStockLibsUnity/module.prop
sed -i "s/$(cat ./src/ANXCameraPerseusStockLibsUnity/module.prop|grep version=|tr -d " ")/version=${ANXVERSION}/g" ./src/ANXCameraPerseusStockLibsUnity/module.prop

sed -i "s/$(cat ./src/ANXMiuiCameraMagisk/module.prop|grep versionCode=|tr -d " ")/versionCode=${ANXVERSIONNUMBER}/g" ./src/ANXMiuiCameraMagisk/module.prop
sed -i "s/$(cat ./src/ANXMiuiCameraMagisk/module.prop|grep version=|tr -d " ")/version=${ANXVERSION}/g" ./src/ANXMiuiCameraMagisk/module.prop

sed -i "s/$(cat ./src/ANX4K60Unity/module.prop|grep versionCode=|tr -d " ")/versionCode=${ANXVERSIONNUMBER}/g" ./src/ANX4K60Unity/module.prop
sed -i "s/$(cat ./src/ANX4K60Unity/module.prop|grep version=|tr -d " ")/version=${ANXVERSION}/g" ./src/ANX4K60Unity/module.prop

sed -i "s/$(cat ./src/Arnob48MPFix/module.prop|grep versionCode=|tr -d " ")/versionCode=${ANXVERSIONNUMBER}/g" ./src/Arnob48MPFix/module.prop
sed -i "s/$(cat ./src/Arnob48MPFix/module.prop|grep version=|tr -d " ")/version=${ANXVERSION}/g" ./src/Arnob48MPFix/module.prop

sed -i "s/$(cat ./src/ANXCamFix/module.prop|grep versionCode=|tr -d " ")/versionCode=${ANXVERSIONNUMBER}/g" ./src/ANXCamFix/module.prop
sed -i "s/$(cat ./src/ANXCamFix/module.prop|grep version=|tr -d " ")/version=${ANXVERSION}/g" ./src/ANXCamFix/module.prop

sed -i "s/$(cat ./src/ANXMimoji/module.prop|grep versionCode=|tr -d " ")/versionCode=${ANXVERSIONNUMBER}/g" ./src/ANXMimoji/module.prop
sed -i "s/$(cat ./src/ANXMimoji/module.prop|grep version=|tr -d " ")/version=${ANXVERSION}/g" ./src/ANXMimoji/module.prop

sed -i "s/$(cat ./src/KubilWhyredyFix/module.prop|grep versionCode=|tr -d " ")/versionCode=${ANXVERSIONNUMBER}/g" ./src/KubilWhyredyFix/module.prop
sed -i "s/$(cat ./src/KubilWhyredyFix/module.prop|grep version=|tr -d " ")/version=${ANXVERSION}/g" ./src/KubilWhyredyFix/module.prop

sed -i "s/$(cat ./src/LavendyFix/module.prop|grep versionCode=|tr -d " ")/versionCode=${ANXVERSIONNUMBER}/g" ./src/LavendyFix/module.prop
sed -i "s/$(cat ./src/LavendyFix/module.prop|grep version=|tr -d " ")/version=${ANXVERSION}/g" ./src/LavendyFix/module.prop
