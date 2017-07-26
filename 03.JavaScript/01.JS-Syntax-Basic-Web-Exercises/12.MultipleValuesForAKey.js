function solve(args) {
    let result = {};

    let neededKey = '';

    for (let i = 0; i < args.length; i++) {
        let currentInput = args[i].split(' ');
        let currentKey = currentInput[0];

        if (currentInput.length === 2) {
            let currentValue = currentInput[1];

            if (!(currentKey in result)) {
                result[currentKey] = [];
            }

            result[currentKey].push(currentValue);

        } else if (currentInput.length === 1 && currentKey !== '') {
            neededKey = currentKey;
        }
    }

    if (neededKey in result) {
        result[neededKey].forEach(x => console.log(x));
    } else {
        console.log('None');
    }
}

solve([ '3 test', '3 test1', '4 test2', '4 test3', '4 test5', '4', '' ]);