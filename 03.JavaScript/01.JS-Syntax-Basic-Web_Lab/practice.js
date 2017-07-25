function solve([args]) {
    [num1, num2, num3] = args.split(' ').map(Number);
    console.log(num1 + "|" + num2 + "|" + num3);
}
solve([ '8 15 7']);