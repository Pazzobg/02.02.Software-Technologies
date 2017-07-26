function solve(args) {
    let counter = 0;

    for (let num of args){
        if (num < 0) {
            counter++;
        }
    }

    console.log(counter % 2 === 0 ? 'Positive' : 'Negative');
}

solve([ '9', '3', '17' ]);