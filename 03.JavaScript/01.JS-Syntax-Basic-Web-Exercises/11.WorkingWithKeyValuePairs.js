function solve(args) {
    let result = {};

    let neededKey = '';

    for (let i = 0; i < args.length; i++) {
        let currentInput = args[i].split(' ');
        let currentKey = currentInput[0];

        if (currentInput.length === 2) {
            let currentValue = currentInput[1];

            if (!(currentKey in result)) {
                result[currentKey] = '';
            }

            result[currentKey] = currentValue;
        } else if (currentInput.length === 1 && currentKey !== '') {
            neededKey = currentKey;
        }
    }

    if (neededKey in result) {
        console.log(result[neededKey]);
    } else {
        console.log('None');
    }
}

solve(['3 bla', '3 alb', '2', '']);