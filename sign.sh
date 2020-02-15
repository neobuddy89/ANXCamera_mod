#!/usr/bin/env bash

# adjust $BUILDTOOLSPATH if needed
BUILDTOOLSPATH=/opt/android-sdk/build-tools/29.0.2

cp ./out/ANXCamera-Unsigned.apk ./out/ANXCamera-to-be-signed.apk
$BUILDTOOLSPATH/apksigner sign --key ../ANXMiuiPortTools/testkey.pk8 --cert ../ANXMiuiPortTools/testkey.x509.pem ./out/ANXCamera-to-be-signed.apk
mv ./out/ANXCamera-to-be-signed.apk ./out/ANXCamera-Unaligned.apk
$BUILDTOOLSPATH/zipalign -f 4  ./out/ANXCamera-Unaligned.apk ./out/ANXCamera.apk
