function solve(args) {
    let n = Number(args[0]);

    let result = "";

    for (let i = 1; i <= n; i++) {
        if (checkForSymmetry("" + i)) {     // send empty str "" to the funct instead of num.tostring() there;
            result += i + ' ';
        }
    }

    console.log(result);

    function checkForSymmetry(num) {
        let length = num.length;

        for (let i = 0; i < length / 2; i++) {
            if (num[i] !== num[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}

solve(['750']);