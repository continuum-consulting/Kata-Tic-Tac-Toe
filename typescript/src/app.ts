console.log("Hello world");

const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
})

readline.question('What is your name? ', (name: string) => {
    console.log(`Hi ${name}`);
    readline.close();
})
