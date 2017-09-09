#!/bin/bash
EXEC=python3
INPUT_FILE="stdin.txt"

which $EXEC > /dev/null &> /dev/null
if [ "$#" -ne 0 ] ; then
	echo "Can't run because \"$EXEC\" isn't in the path (perhaps not even installed)"
	exit 1
fi

if [ "$#" -eq 1 ] ; then
	INPUT_FILE=$1
fi

if [ "$?" -eq 0 ] ; then
	if [ -f "$INPUT_FILE" ] ; then
		cat $INPUT_FILE | $EXEC Solution.py
	else
		$EXEC Solution.py
	fi
fi

echo -e "\n"
