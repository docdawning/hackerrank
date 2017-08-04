#!/bin/bash
INPUT_FILE="stdin.txt"

if [ "$#" -eq 1 ] ; then
	INPUT_FILE=$1
fi

javac Solution.java
if [ "$?" -eq 0 ] ; then 
	cat $INPUT_FILE | java Solution
fi
