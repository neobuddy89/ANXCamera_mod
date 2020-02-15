#!/usr/bin/env bash
ANXVERSION=$(cat ./VERSION|tail -n1|cut -d= -f2|tr -d '\r')
echo $ANXVERSION

cp -i ./out/ANXCamera.apk ./src/ANXCameraUnity/system/priv-app/ANXCamera/
rm ./out/ANXCameraUnity.zip
rm ./out/ANXCameraUnity_*.zip
zip ./out/ANXCameraUnity.zip ./src/ANXCameraUnity/*
cp ./out/ANXCameraUnity.zip ./out/ANXCameraUnity_$ANXVERSION.zip
adb push ./out/ANXCameraUnity.zip /sdcard/zips

# zip ./out/Arnob48MPFix.zip ./src/Arnob48MPFix/*
# cp ./out/Arnob48MPFix.zip ./out/Arnob48MPFix_$ANXVERSION.zip

# zip ./out/Dyneteve48MPFix.zip ./src/Dyneteve48MPFix/*
# cp ./out/Dyneteve48MPFix.zip ./out/Dyneteve48MPFix_$ANXVERSION.zip

# zip ./out/KubilWhyredyFix.zip ./src/KubilWhyredyFix/*
# cp ./out/KubilWhyredyFix.zip ./out/KubilWhyredyFix_$ANXVERSION.zip


# rm ./out/LavendyFix.zip
# rm ./out/LavendyFix_*.zip
# zip ./out/LavendyFix.zip ./src/LavendyFix/*
# cp ./out/LavendyFix.zip ./out/LavendyFix_$ANXVERSION.zip


# rm ./out/ANXCamFix.zip
# rm ./out/ANXCamFix_*.zip
# rm ./out/ANXCustLibs.zip
# rm ./out/ANXCustLibs_*.zip
# zip ./out/ANXCustLibs.zip ./src/ANXCamFix/*
# cp ./out/ANXCustLibs.zip ./out/ANXCustLibs_$ANXVERSION.zip

# adb push ./out/ANXCustLibs.zip  /sdcard/zips


# rm ./out/ANXMimoji.zip
# rm ./out/ANXMimoji_*.zip
# zip ./out/ANXMimoji.zip ./src/ANXMimoji/*
# cp ./out/ANXMimoji.zip ./out/ANXMimoji_$ANXVERSION.zip

# adb push ./out/ANXMimoji.zip  /sdcard/zips
