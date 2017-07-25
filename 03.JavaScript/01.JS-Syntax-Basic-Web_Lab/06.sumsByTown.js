function solve(args) {
    let result = {};
    let objects = args.map(JSON.parse);

    for (let obj of objects) {
        let name = obj.town;
        let income = obj.income;

        if (!result[name] && result[name] !== 0 ) {
            result[name] = 0;
        }

        result[name] += income;
    }

    let orderedTowns = Object.keys(result).sort();

    for (let i = 0; i < orderedTowns.length; i++) {
        console.log(`${orderedTowns[i]} -> ${result[orderedTowns[i]]}`)
    }
}

solve([
    '{"town":"Sofia","income":200}',
    '{"town":"Varna","income":120}',
    '{"town":"Pleven","income":60}',
    '{"town":"Varna","income":70}'

]);