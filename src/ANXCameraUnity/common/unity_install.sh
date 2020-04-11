
ROPRODEV=$(getprop ro.product.vendor.device)


no_notch_devices="
raphael
polaris
perseus
whyred
gemini
sirius
davinci"

case $no_notch_devices in
    *${ROPRODEV}*)
        echo "ro.miui.notch=0" > $TMPDIR/common/system.prop
        notch="hasn't"
        ;;
    *)
        echo "ro.miui.notch=1" > $TMPDIR/common/system.prop
        notch="has"
        ;;
esac

ui_print "Your device is recognized as ->$ROPRODEV<- and it $notch got notch"
ui_print "It should be one of below:" 
ui_print "  beryllium"
ui_print "  violet"
ui_print "  dipper"
ui_print "  polaris"
ui_print "  perseus"
ui_print "  cepheus"
ui_print "  lavender"
ui_print "  equuleus"
ui_print "  raphael"
ui_print "  grus"
ui_print "  sirius"
ui_print "  davinci"
ui_print "  pyxis"
ui_print "  laurus"
ui_print "  laurel_sprout"
ui_print "  jasmine_sprout"
ui_print "  ginkgo"
ui_print "  begonia"
ui_print "  willow"
ui_print "  tucana"
ui_print "  phoenix"
ui_print ""
ui_print "In decreasing order of support"
ui_print "Needs Testing for"
ui_print "old devices"

rm -rf /sdcard/.ANXCamera/cheatcodes/
mkdir -p /sdcard/.ANXCamera/cheatcodes/
cp -R $TMPDIR/system/etc/ANXCamera/cheatcodes/* /sdcard/.ANXCamera/cheatcodes/

rm -rf /sdcard/.ANXCamera/cheatcodes_reference/
mkdir -p /sdcard/.ANXCamera/cheatcodes_reference/
cp -R $TMPDIR/system/etc/ANXCamera/cheatcodes/* /sdcard/.ANXCamera/cheatcodes_reference/


rm -rf /sdcard/.ANXCamera/features/
mkdir -p /sdcard/.ANXCamera/features/
cp -R $TMPDIR/system/etc/device_features/* /sdcard/.ANXCamera/features/

rm -rf /sdcard/.ANXCamera/features_reference/
mkdir -p /sdcard/.ANXCamera/features_reference/
cp -R $TMPDIR/system/etc/device_features/* /sdcard/.ANXCamera/features_reference/

MNAME=$(grep_prop name $TMPDIR/module.prop)
MDEV=$(grep_prop author $TMPDIR/module.prop)
MVERS=$(grep_prop versionCode $TMPDIR/module.prop)
MROM=$(getprop ro.build.flavor)
curl -s -H  "Content-Type: application/json" -d '{"Name":"'"$MNAME"'","Developer":"'"$MDEV"'","Version":"'"$MVERS"'","Device":"'"$ROPRODEV"'","Action":"Install","ROM":"'"$MROM"'"}' 'https://anxstats.herokuapp.com/api/stats' > /dev/null &
