
ROPRODEV=$(getprop ro.product.device)

ui_print "Your device is recognized as ->$ROPRODEV<-" 
ui_print "It should be one of below:" 
ui_print "  beryllium"
ui_print "  violet"
ui_print "  dipper"
ui_print "  polaris"
ui_print "  perseus"
ui_print "  cepheus"
ui_print "  lavender"
ui_print "  whyred"
ui_print "  equuleus"
ui_print "  raphael"
ui_print "  platina"
ui_print "  tulip"
ui_print "  gemini"
ui_print "  grus"
ui_print "  sirius"
ui_print "  davinci"
ui_print "  pyxis"
ui_print "  laurus"
ui_print ""
ui_print "In decreasing order of support"
ui_print "Needs Testing for"
ui_print "chiron jason mido sagit sakura vince wayne cactus cereus laurel_sprout lotus nitrogen onc riva rosy tiare ursa ysl daisy_sprout jasmine_sprout"

ui_print "ANX was here, it hates poco libs"

MNAME=$(grep_prop name $TMPDIR/module.prop)
MDEV=$(grep_prop author $TMPDIR/module.prop)
MVERS=$(grep_prop versionCode $TMPDIR/module.prop)
MROM=$(getprop ro.build.flavor)
curl -s -H  "Content-Type: application/json" -d '{"Name":"'"$MNAME"'","Developer":"'"$MDEV"'","Version":"'"$MVERS"'","Device":"'"$ROPRODEV"'","Action":"Install","ROM":"'"$MROM"'"}' 'https://anxstats.herokuapp.com/api/stats' > /dev/null &
