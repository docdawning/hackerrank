//Refs: https://www.hackerrank.com/challenges/ctci-array-left-rotation

package main
import "os"
import "bufio"
import "fmt"
import "strconv"

//Input handling help from here: https://github.com/gersakbogdan/golang-hackerrank/blob/master/two_arrays.go

func main() {
	var n,k int
	io := bufio.NewReader(os.Stdin)
	fmt.Fscan(io, &n)
	fmt.Fscan(io, &k)

	array := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(io, &array[(i+n-k)%n])
	}

	for i := 0; i < n; i++ {
		fmt.Print(strconv.Itoa(array[i])+" ")
	}
}
