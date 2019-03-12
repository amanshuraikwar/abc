echo ""
echo "[SCRIPT] Compiling and Running............STARTED"
echo ""
javac -verbose -Xstdout log.txt $(find abc -name "*.java") && java abc.Driver >> out.txt
echo "[SCRIPT] Compile............STARTED"
echo ""
cat log.txt
echo ""
echo "[SCRIPT] Compile............COMPLETE"
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