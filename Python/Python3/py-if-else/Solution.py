#Refs: https://www.hackerrank.com/challenges/py-if-else/problem

if __name__ == '__main__':
	n = int(input())
	if (n % 2 != 0):
		print("Weird")
	else:
		if n in range(2, 6):
			print("Not Weird")
		if n in range(6, 21):
			print("Weird")
		if n > 20:
			print("Not Weird")
