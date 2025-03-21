# avaj-launcher


javac -d out $(find avaj_launcher/src -name "*.java")  : to compile

java -cp out com.app.Main scenario.txt  : to run the program

find out -name "*.class" -type f -delete  : to remove all the .class file in the out directory