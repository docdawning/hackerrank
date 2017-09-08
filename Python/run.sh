#!/bin/bash
INPUT_FILE="stdin.txt"

if [ "$#" -eq 1 ] ; then
	INPUT_FILE=$1
fi

if [ "$?" -eq 0 ] ; then
	if [ -f "$INPUT_FILE" ] ; then
		cat $INPUT_FILE | python Solution.py
	else
		python Solution.py
	fi
fi

echo -e "\n"
