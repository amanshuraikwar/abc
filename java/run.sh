echo ""
echo "[SCRIPT] Compiling and Running............STARTED"
javac -verbose -Xstdout log.txt $(find abc -name "*.java") && java abc.Driver >> out.txt
echo ""
echo "[SCRIPT] File Parsing............STARTED"
echo ""
cat log.txt | grep parsing
echo ""
echo "[SCRIPT] File Parsing............COMPLETE"
echo ""
echo "[SCRIPT] Run............START"
echo ""
cat out.txt
echo ""
echo "[SCRIPT] Run............COMPLETE"
echo ""
echo "[SCRIPT] Compiling and Running............COMPLETE"
echo ""
rm log.txt
rm out.txt