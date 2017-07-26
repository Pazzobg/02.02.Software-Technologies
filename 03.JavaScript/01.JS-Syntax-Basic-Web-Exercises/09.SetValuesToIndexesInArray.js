function solve(args) {
    let n = Number(args[0]);
    let resultArr = new Array(n).fill(0);

    for (let i = 1; i < args.length; i++) {
        let currentEntry = args[i].split(' ');
        let index = Number(currentEntry[0]);
        let value = Number(currentEntry[2]);

        resultArr[index] = value;
    }

    for (let num of resultArr) {
        console.log(num);
    }
}

solve(['5', '0 - 3', '3 - -1', '4 - 2' ]);