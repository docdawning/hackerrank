def print_rangoli(size):
	import sys
	for row in range(1,size+1):
		print_rangoli_row(row, size)
	for row in reversed(range(1, size)):
		print_rangoli_row(row, size)	

def print_rangoli_row(row, size):
	ALPHABET_START_ASCII_INDEX_OFFSET=97-1

	#print "Row: "+row.__str__()+", Size: "+size.__str__()
	#Row: 1, Size: 5	--------e--------
	#Row: 2, Size: 5	------e-d-e------
	#Row: 3, Size: 5	----e-d-c-d-e----
	#Row: 4, Size: 5	--e-d-c-b-c-d-e--
	#Row: 5, Size: 5	e-d-c-b-a-b-c-d-e
	#Row: 4, Size: 5	--e-d-c-b-c-d-e--
	#Row: 3, Size: 5	----e-d-c-d-e----
	#Row: 2, Size: 5	------e-d-e------
	#Row: 1, Size: 5	--------e--------

	rowString = ""
	while (row > 0):
		if (row != size):
			if (rowString == ""):
				rowString = getCharForSizeAndRow(size, row)
			else:
				rowString = getCharForSizeAndRow(size, row)+"-"+rowString+"-"+getCharForSizeAndRow(size, row)

		if (row == size):
			rowString = rowString[:len(rowString)/2] + "a" + rowString[len(rowString)/2:]
	
		row = row-1

	boxWidth = (2*size)-1+(2*(size-1))
	
	#wrap the string with boxWidth/2 "-" characters
	numberOfPaddingDashes = (boxWidth - rowString.__len__())/2
	rowString = (numberOfPaddingDashes*"-") + rowString + (numberOfPaddingDashes*"-")

	print rowString

def getCharForSizeAndRow(size, row):
	ALPHABET_START_ASCII_INDEX_OFFSET=97-1
	return chr(ALPHABET_START_ASCII_INDEX_OFFSET+(size-row+1))


if __name__ == '__main__':
	n = int(raw_input())
	print_rangoli(n)
