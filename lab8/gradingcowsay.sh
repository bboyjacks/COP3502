#!/bin/bash
#Test your cowsay program.

javac cowsay.java

java cowsay Moo! Moo! > output
java cowsay -l >> output
java cowsay -f dragon RAWR! >> output
java cowsay -f cryptid ?!?! >> output
java cowsay -f >> output

less output
