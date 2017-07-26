function solve(args) {

    let myObj = {};

    for (token of args) {
        token = token.split(' ->');
        let currentProp = token[0].trim();
        let valToken = token[1].trim();
        let currentValue = isNaN(valToken) ? valToken : Number(valToken);

        if (!currentProp in myObj) {
            myObj[currentProp] = '';
        }

        myObj[currentProp] = currentValue;
    }

    console.log(JSON.stringify(myObj));
}

solve([
    'name -> Angel',
    'surname -> Georgiev',
    'age -> 20',
    'grade -> 6.00',
    'date -> 23/05/1995',
    'town -> Sofia'
]);