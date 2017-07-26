function solve(args) {
    let loopEnd = args.length;
    let result = [];
    for (let i = 0; i < loopEnd; i++) {
        let currentInput = args[i].split(' ');
        let command = currentInput[0];

        switch (command) {
            case "add":
                let num = Number(currentInput[1]);
                result.push(num);
                break;
            case "remove":
                let index = Number(currentInput[1]);
                if (index > -1 && index < result.length) {
                    result.splice(index, 1);
                }
        }
    }

    for (let value of result) {
        console.log(value);
    }
}

solve(['add 3', 'add 5', 'remove 2', 'remove 0', 'add 7' ]);