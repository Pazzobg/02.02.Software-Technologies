function solve(args) {
    args = args.sort((a, b) => b - a);

    let result = args.splice(0, 3);
    for (let num of result) {
        console.log(num);
    }

    /* Another solution:
    let total = Math.min(args.length, 3);
    for (let i = 0; i < total; i++) {
        console.log(args[i]);
    }
    */
}

solve([12, 10, 4, 100, 74, 86, 43]);