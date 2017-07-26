function solve(args) {
    for (let i = 0; i < args.length; i++) {
        let currentLine = args[i];

        if (currentLine === "Stop") break;

        console.log(currentLine);
    }
}

solve([ '3', '6', '5', '4', 'Stop', '10', '12' ]);